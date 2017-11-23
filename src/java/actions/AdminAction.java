/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import controllers.*;
import entities.*;
import entitiesmapping.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author sonnguyen
 */
public class AdminAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private HttpServletRequest request;
    private Map<String, Object> session;

    private AdminController adminController;
    private List<Login> lstLogin = new ArrayList<>();
    private List<AdminLogin> lstAdminLogin = new ArrayList<>();
    private List<SinhVien> lstSinhVien = new ArrayList<>();
    private List<SinhVienDiem> lstSinhVienDiem = new ArrayList<>();
    private List<GiangVien> lstGiangVien = new ArrayList<>();
    private List<CongTy> lstCongTy = new ArrayList<>();
    private List<DeTai> lstDeTai = new ArrayList<>();
    private List<ThongBao> lstThongBao = new ArrayList<>();
    private List<Logs> lstLogs = new ArrayList<>();

    public List<DeTai> getLstDeTai() {
        return lstDeTai;
    }

    public void setLstDeTai(List<DeTai> lstDeTai) {
        this.lstDeTai = lstDeTai;
    }

    public List<ThongBao> getLstThongBao() {
        return lstThongBao;
    }

    public void setLstThongBao(List<ThongBao> lstThongBao) {
        this.lstThongBao = lstThongBao;
    }

    public List<Logs> getLstLogs() {
        return lstLogs;
    }

    public void setLstLogs(List<Logs> lstLogs) {
        this.lstLogs = lstLogs;
    }

    public List<CongTy> getLstCongTy() {
        return lstCongTy;
    }

    public void setLstCongTy(List<CongTy> lstCongTy) {
        this.lstCongTy = lstCongTy;
    }

    public List<GiangVien> getLstGiangVien() {
        return lstGiangVien;
    }

    public void setLstGiangVien(List<GiangVien> lstGiangVien) {
        this.lstGiangVien = lstGiangVien;
    }

    public List<SinhVienDiem> getLstSinhVienDiem() {
        return lstSinhVienDiem;
    }

    public void setLstSinhVienDiem(List<SinhVienDiem> lstSinhVienDiem) {
        this.lstSinhVienDiem = lstSinhVienDiem;
    }

    public List<SinhVien> getLstSinhVien() {
        return lstSinhVien;
    }

    public void setLstSinhVien(List<SinhVien> lstSinhVien) {
        this.lstSinhVien = lstSinhVien;
    }

    public List<AdminLogin> getLstAdminLogin() {
        return lstAdminLogin;
    }

    public void setLstAdminLogin(List<AdminLogin> lstAdminLogin) {
        this.lstAdminLogin = lstAdminLogin;
    }

    public List<Login> getLstLogin() {
        return lstLogin;
    }

    public void setLstLogin(List<Login> lstLogin) {
        this.lstLogin = lstLogin;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public AdminAction() {
        adminController = new AdminController();
    }

    public String GetAllTaiKhoan() {
        lstLogin = adminController.GetAllTaiKhoan();

        session.put("QuanLyTaiKhoan", "QuanLyTaiKhoan");
        for (int i = 0; i < lstLogin.size(); i++) {
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setStt(i);
            adminLogin.setEmail(lstLogin.get(i).getEmail());
            if (lstLogin.get(i).getRule() == 0) {
                adminLogin.setLoaiTaiKhoan("Sinh Viên");
            }
            if (lstLogin.get(i).getRule() == 1) {
                adminLogin.setLoaiTaiKhoan("Giảng viên phụ trách");
            }
            if (lstLogin.get(i).getRule() == 2) {
                adminLogin.setLoaiTaiKhoan("Giảng viên hưóng dẫn");
            }
            if (lstLogin.get(i).getRule() == 3) {
                adminLogin.setLoaiTaiKhoan("Đại diện công ty");
            }
            if (lstLogin.get(i).getRule() == 4) {
                adminLogin.setLoaiTaiKhoan("ADMIN");
            }
            lstAdminLogin.add(adminLogin);
        }
        return SUCCESS;
    }

    public String XoaTaiKhoan() {
        if (adminController.XoaTaikhoan((String) request.getParameter("email"))) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;
    }

    public String ResetPass() {
        if (adminController.ResetPass((String) request.getParameter("email"))) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;
    }

    public String GetAllSinhVien() {
        lstSinhVien = adminController.GetAllSinhVien();
        session.put("QuanLySinhVien", "QuanLySinhVien");
        return SUCCESS;
    }

    public String AddTaiKhoan() {
        Login login = new Login();
        login.setEmail(request.getParameter("email"));
        login.setPassword(request.getParameter("email"));
        login.setRule(Integer.parseInt(request.getParameter("rule")));
        if (adminController.AddTaiKhoan(login)) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;
    }

    public String XoaSinhVien() {
        int mssv = Integer.parseInt(request.getParameter("mssv"));
        if (adminController.XoaSinhVien(mssv)) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;
    }

    public String GetAllDiem() {
        lstSinhVienDiem = adminController.GetAllDiem();
        session.put("QuanLyDiem", "QuanLyDiem");
        return SUCCESS;
    }

    public String XoaDiemSinhVien() {
        int mssv = Integer.parseInt(request.getParameter("mssv"));
        if (adminController.XoaSinhVienDiem(mssv)) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;

    }

    public String GetAllGiangVien() {
        lstGiangVien = adminController.GetAllGiangVien();
        session.put("QuanLyGiangVien", "QuanLyGiangVien");
        return SUCCESS;
    }

    public String XoaGiangVien() {
        int id = Integer.parseInt(request.getParameter("id"));
        if (adminController.XoaGiangVien(id)) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;
    }

    public String GetAllCongTy() {
        lstCongTy = adminController.GetAllCongTy();
        session.put("QuanLyCongTy", "QuanLyCongTy");
        return SUCCESS;
    }

    public String XoaCongTy() {
        int id = Integer.parseInt(request.getParameter("msct"));
        if (adminController.XoaCongTy(id)) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;
    }

    public String GetAllDeTai() {
        lstDeTai = adminController.GetAllDeTai();
        session.put("QuanLyDeTai", "QuanLyDeTai");
        return SUCCESS;
    }

    public String XoaDeTai() {
        int id = Integer.parseInt(request.getParameter("id"));
        if (adminController.XoaDeTai(id)) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;
    }
    public String GetAllThongBao() {
        lstThongBao = adminController.GetAllThongBao();
        session.put("QuanLyThongBao", "QuanLyThongBao");
        return SUCCESS;
    }

    public String XoaThongBao() {
        int id = Integer.parseInt(request.getParameter("id"));
        if (adminController.XoaThongBao(id)) {
            session.put("ThanhCong", "ThanhCong");
        }
        session.put("Thatbai", "Thatbai");
        return SUCCESS;
    }

     public String GetAllLogs() {
        lstLogs = adminController.GetAllLogs();
        session.put("QuanLyLogs", "QuanLyLogs");
        return SUCCESS;
    }
     public String LogoutAdmin() {
        session.clear();
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
