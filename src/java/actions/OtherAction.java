/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import controllers.*;
import entities.*;
import java.util.ArrayList;
import java.util.List;
import util.SendSMS;

/**
 *
 * @author sonnguyen
 */
public class OtherAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private HttpServletRequest request;
    private Map<String, Object> session;
    private OtherController otherController;
    private CongTy congTy;
    private List<CongTy> lstCongTy;
    private List<ThongBao> lstThongBao;
    private List<TinNhanEmail> lstHopThuDen = new ArrayList<>();
    private List<TinNhanEmail> lstHopThuDi = new ArrayList<>();
    private List<SinhVienFile> lstFile = new ArrayList<>();

    public List<SinhVienFile> getLstFile() {
        return lstFile;
    }

    public void setLstFile(List<SinhVienFile> lstFile) {
        this.lstFile = lstFile;
    }

    public List<TinNhanEmail> getLstHopThuDen() {
        return lstHopThuDen;
    }

    public void setLstHopThuDen(List<TinNhanEmail> lstHopThuDen) {
        this.lstHopThuDen = lstHopThuDen;
    }

    public List<TinNhanEmail> getLstHopThuDi() {
        return lstHopThuDi;
    }

    public void setLstHopThuDi(List<TinNhanEmail> lstHopThuDi) {
        this.lstHopThuDi = lstHopThuDi;
    }

    public List<ThongBao> getLstThongBao() {
        return lstThongBao;
    }

    public void setLstThongBao(List<ThongBao> lstThongBao) {
        this.lstThongBao = lstThongBao;
    }

    public List<CongTy> getLstCongTy() {
        return lstCongTy;
    }

    public void setLstCongTy(List<CongTy> lstCongTy) {
        this.lstCongTy = lstCongTy;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public CongTy getCongTy() {
        return congTy;
    }

    public void setCongTy(CongTy congTy) {
        this.congTy = congTy;
    }

    public OtherAction() {
        otherController = new OtherController();
    }

    public String GetAllHome() {
        lstCongTy = otherController.GetAllCongTy();
        lstThongBao = otherController.GetAllThongBao();
        lstFile = otherController.GetAllFile();
        session.put("lstCongTy", lstCongTy);
        session.put("lstFile", lstFile);
        session.put("SQLHome", "SQLHome");
        return SUCCESS;
    }

    public String GetAllHopThu() {
        String email = (String) session.get("email");
        lstHopThuDen = otherController.GetAllHopThuDen(email);
        lstHopThuDi = otherController.GetAllHopThuDi(email);
        session.put("GetAllEmail", "GetAllEmail");
        return SUCCESS;
    }

    public String SaveHopThu() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        TinNhanEmail tinNhanEmail = new TinNhanEmail();
        if (request.getParameter("typeEmail") == null) {
            tinNhanEmail.setLoaiEmail(false); // true là email/ false là phản hồi
        } else {
            tinNhanEmail.setLoaiEmail(true); // true là email/ false là phản hồi
        }
        if (request.getParameter("mssv") == null) {
            tinNhanEmail.setMssv(0);
        } else {
            int x = Integer.parseInt(request.getParameter("mssv"));
            tinNhanEmail.setMssv(x);
        }
        tinNhanEmail.setNguoiGui((String) session.get("email"));
        tinNhanEmail.setNguoiNhan(request.getParameter("nguoiNhan"));
        tinNhanEmail.setNoiDung(request.getParameter("noiDung"));
        tinNhanEmail.setThoiGian(sqlDate);
        tinNhanEmail.setTieuDe(request.getParameter("tieuDe"));
        if (otherController.SaveHopThu(tinNhanEmail)) {
            GetAllHopThu();
            return SUCCESS;
        }
        return ERROR;
    }

    public String GetPass() {
        String email = request.getParameter("email");
        int dienThoai = Integer.parseInt(request.getParameter("dienThoai"));
        List<Login> lstLogins = new ArrayList<>();
        lstLogins = otherController.GetPass(email);

        try {
            //Send SMS
            SendSMS sendSMS = new SendSMS();
            sendSMS.sendSMSCustomer("" + dienThoai + "", "Xin chao " + email + ". Mat khau cua ban la: " + lstLogins.get(0).getPassword() + ". Send By NguyenCongSon");
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.put("resetPass", "resetPass");
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
