/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controllers.LoginController;
import controllers.*;
import entities.Login;
import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import controllers.LogController;
import entities.DaiDienCongTy;
import java.io.IOException;

/**
 *
 * @author sonnguyen
 */
public class LoginActions extends ActionSupport implements SessionAware, ServletRequestAware {

    private HttpServletRequest request;
    private Map<String, Object> session;
    private LoginController loginController;
    private SinhvienController sinhvienController;
    private LogController logController;
    private DdctController daiDienCongTyController;
    private GvttController giangVienThucTapController;
    private GvhdController giangVienHuongDanController;

    // tạo các list lưu thông tin
    private List<SinhVien> lstSinhVien = new ArrayList<>();
    private List<DaiDienCongTy> lstDaiDienCongTy = new ArrayList<>();
    private List<Login> lstLogin = new ArrayList<>();
    private List<GiangVien> lstGiangVienThucTap = new ArrayList<>();
    private List<GiangVienHuongDan> lstGiangVienHuongDan = new ArrayList<>();

    public List<GiangVien> getLstGiangVienThucTap() {
        return lstGiangVienThucTap;
    }

    public void setLstGiangVienThucTap(List<GiangVien> lstGiangVienThucTap) {
        this.lstGiangVienThucTap = lstGiangVienThucTap;
    }

    public List<GiangVienHuongDan> getLstGiangVienHuongDan() {
        return lstGiangVienHuongDan;
    }

    public void setLstGiangVienHuongDan(List<GiangVienHuongDan> lstGiangVienHuongDan) {
        this.lstGiangVienHuongDan = lstGiangVienHuongDan;
    }

    public List<Login> getLstLogin() {
        return lstLogin;
    }

    // get-set list
    public void setLstLogin(List<Login> lstLogin) {
        this.lstLogin = lstLogin;
    }

    public List<DaiDienCongTy> getLstDaiDienCongTy() {
        return lstDaiDienCongTy;
    }

    public void setLstDaiDienCongTy(List<DaiDienCongTy> lstDaiDienCongTy) {
        this.lstDaiDienCongTy = lstDaiDienCongTy;
    }

    public List<SinhVien> getLstSinhVien() {
        return lstSinhVien;
    }

    public void setLstSinhVien(List<SinhVien> lstSinhVien) {
        this.lstSinhVien = lstSinhVien;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public LoginActions() {
        loginController = new LoginController();
        sinhvienController = new SinhvienController();
        logController = new LogController();
        daiDienCongTyController = new DdctController();
        giangVienHuongDanController = new GvhdController();
        giangVienThucTapController = new GvttController();

    }

    public void Validate() {
        if (request.getParameter("password").length() < 8) {
            addFieldError("password", "Mật khẩu không được nhỏ hơn 8 ký tự");
        }

    }

    /**
     * Phương thức đăng nhập vào hệ thống Các tham số cần truyền vào là: 0: Sinh
     * viên 1: giảng viên hướng dẫn 2: giảng viên phụ trách 3: Đại diện công ty
     * 4: quản trị viên
     *
     * @version 1.0
     * @since 27/10/2017
     * @param email email cảu các đối tượng
     * @param pass mật khẩu của các đối tưọng
     * @author Cong Son NGUYEN
     *
     */
    public String Login() throws IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        logController.Log(email, "Đăng nhập vào hệ thống.");
        List<Login> lstLogin = new ArrayList<>();
        lstLogin = loginController.Login(email, pass);
        if (lstLogin.size() == 1) { // kiểm tra xem có tài khoản không
            logController.Log(email, "Đăng nhập THÀNH CÔNG vào hệ thống.");
            session.put("email", email); // lưu email
            if (lstLogin.get(0).getRule() == 0) { // sinh viên có role = 0
                session.put("role", "0");
                int mssv = Integer.parseInt(email.substring(0, 8));
                session.put("mssv", mssv);
                lstSinhVien = sinhvienController.GetInfoSinhVien(mssv); // lấy thông tin sinh viên
                if (lstSinhVien.size() == 0) { // kiểm tra sinh viên đã cập nhật thông tin chưa
                    return "updateInfoSinhVien";
                } else {
                    session.put("lstSinhVien", lstSinhVien);
                    return SUCCESS;
                }
            } else if (lstLogin.get(0).getRule() == 1) {
                session.put("role", "1");
                lstGiangVienThucTap = giangVienThucTapController.GetInfoGiangVien(email);
                if (lstGiangVienThucTap.size() == 1) {
                    session.put("lstGiangVienThucTap", lstGiangVienThucTap);
                    return SUCCESS;
                } else {
                    return "updateGiangVienThucTap";
                }
            } else if (lstLogin.get(0).getRule() == 2) {
                lstGiangVienHuongDan = giangVienHuongDanController.GetInfo(email);
                session.put("lstGiangVienHuongDan", lstGiangVienHuongDan);
                session.put("role", "2");
                session.put("msgvhd", lstGiangVienHuongDan.get(0).getId());
                return SUCCESS;
            } else if (lstLogin.get(0).getRule() == 3) {
                lstDaiDienCongTy = daiDienCongTyController.GetDaiDienCongTy(request.getParameter("email"));
                session.put("lstDaiDienCongTy", lstDaiDienCongTy);
                session.put("role", "3");
            } else if (lstLogin.get(0).getRule() == 4) {
                session.put("role", "4");
            }
        } else {
            logController.Log(email, "Đăng nhập thất bại: lỗi tài khoản hoặc mật khẩu không đúng");
            addFieldError("error", "Tài khoản hoặc mật khẩu không đúng");
            return INPUT;
        }
        return SUCCESS;
    }

    public String CreateAccount() {
        if (request.getParameter("password").length() < 8) {
            addFieldError("error", "Mật khẩu không được nhỏ hơn 8 ký tự");
            return INPUT;
        }
        if (!request.getParameter("password").equals(request.getParameter("repeatPassword"))) {
            addFieldError("error", "Mật khẩu không khớp");
            return INPUT;
        }
        lstLogin = loginController.CheckAccount(request.getParameter("email"));
        if (lstLogin.size() == 0) {
            Login l = new Login();
            l.setEmail(request.getParameter("email"));
            l.setPassword(request.getParameter("password"));
            l.setRule(3);
            if (loginController.CreateAccount(l)) {
                session.put("email", request.getParameter("email"));
                return SUCCESS;
            }

        } else if (lstLogin.size() == 1) {
            session.put("email", request.getParameter("email"));
            return SUCCESS;
        }
        return ERROR;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
