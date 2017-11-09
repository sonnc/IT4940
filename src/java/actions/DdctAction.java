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
import actions.*;
import entities.CongTy;
import entities.DaiDienCongTy;
import entities.DeTai;
import entities.GiangVienHuongDan;
import entities.Login;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author sonnguyen
 */
public class DdctAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private HttpServletRequest request;
    private Map<String, Object> session;
    private DdctController daiDienCongTyController;
    private DaiDienCongTy daiDien;
    private CongTy congTy;
    private File myFile;
    private File myFileLOGO;
    private String myFileFileName;
    private String myFileLOGOFileName;
    private String path;
    private GiangVienHuongDan nhanVien;
    private List<DaiDienCongTy> lstDaiDienCongTy = new ArrayList<>();
    private List<DeTai> lstDeTai = new ArrayList<>();
    private List<CongTy> lstCongTy = new ArrayList<>();
    private List<GiangVienHuongDan> lstGiangVienHuongDan = new ArrayList<>();

    public GiangVienHuongDan getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(GiangVienHuongDan nhanVien) {
        this.nhanVien = nhanVien;
    }

    public List<DeTai> getLstDeTai() {
        return lstDeTai;
    }

    public void setLstDeTai(List<DeTai> lstDeTai) {
        this.lstDeTai = lstDeTai;
    }

    public List<CongTy> getLstCongTy() {
        return lstCongTy;
    }

    public void setLstCongTy(List<CongTy> lstCongTy) {
        this.lstCongTy = lstCongTy;
    }

    public List<GiangVienHuongDan> getLstGiangVienHuongDan() {
        return lstGiangVienHuongDan;
    }

    public void setLstGiangVienHuongDan(List<GiangVienHuongDan> lstGiangVienHuongDan) {
        this.lstGiangVienHuongDan = lstGiangVienHuongDan;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public List<DaiDienCongTy> getLstDaiDienCongTy() {
        return lstDaiDienCongTy;
    }

    public void setLstDaiDienCongTy(List<DaiDienCongTy> lstDaiDienCongTy) {
        this.lstDaiDienCongTy = lstDaiDienCongTy;
    }

    public String getMyFileLOGOFileName() {
        return myFileLOGOFileName;
    }

    public void setMyFileLOGOFileName(String myFileLOGOFileName) {
        this.myFileLOGOFileName = myFileLOGOFileName;
    }

    public File getMyFileLOGO() {
        return myFileLOGO;
    }

    public void setMyFileLOGO(File myFileLOGO) {
        this.myFileLOGO = myFileLOGO;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public DaiDienCongTy getDaiDien() {
        return daiDien;
    }

    public void setDaiDien(DaiDienCongTy daiDien) {
        this.daiDien = daiDien;
    }

    public CongTy getCongTy() {
        return congTy;
    }

    public void setCongTy(CongTy congTy) {
        this.congTy = congTy;
    }

    public DdctAction() {
        daiDienCongTyController = new DdctController();
    }

    public String CapNhatDDCT() {
        String avatar = null;
        String linkLOGO = null;
        List<CongTy> lstCongTy = new ArrayList<>();
        try {
            path = request.getSession().getServletContext().getRealPath("/").concat("images/avatar/");
            File fileToCreate = new File(path, this.myFileFileName);
            FileUtils.copyFile(this.myFile, fileToCreate);
            avatar = "images/avatar/" + myFileFileName;
            File fileToCreateLOGO = new File(path, this.myFileLOGOFileName);
            FileUtils.copyFile(this.myFileLOGO, fileToCreateLOGO);
            linkLOGO = "images/avatar/" + myFileLOGOFileName;

        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        congTy.setAvatar(linkLOGO);
        lstCongTy = daiDienCongTyController.GetMSCT(congTy.getEmail());
        if (lstCongTy.size() == 0) {
            if (daiDienCongTyController.CapNhatCongTy(congTy)) {
                lstCongTy = daiDienCongTyController.GetMSCT(congTy.getEmail());
                daiDien.setAvatar(avatar);
                daiDien.setEmail((String) session.get("emailCT"));
                daiDien.setMaCongTy(lstCongTy.get(0).getMsct());
                if (daiDienCongTyController.CapNhatDDCT(daiDien)) {
                    lstDaiDienCongTy = daiDienCongTyController.GetDaiDienCongTy((String) session.get("emailCT"));
                    session.put("role", "3");
                    session.put("lstDaiDienCongTy", lstDaiDienCongTy);
                    return SUCCESS;
                }
            }
        } else if (lstCongTy.size() == 1) {
            lstCongTy = daiDienCongTyController.GetMSCT(congTy.getEmail());
            daiDien.setAvatar(avatar);
            daiDien.setEmail((String) session.get("emailCT"));
            daiDien.setMaCongTy(lstCongTy.get(0).getMsct());
            if (daiDienCongTyController.CapNhatDDCT(daiDien)) {
                lstDaiDienCongTy = daiDienCongTyController.GetDaiDienCongTy((String) session.get("emailCT"));
                session.put("lstDaiDienCongTy", lstDaiDienCongTy);
                return SUCCESS;
            }
        }
        return ERROR;
    }

    public String GetChiTietCongTy() {
        lstDaiDienCongTy = daiDienCongTyController.GetDaiDienCongTy((String) session.get("email"));
        int ms = lstDaiDienCongTy.get(0).getMaCongTy();
        lstCongTy = daiDienCongTyController.GetChiTietCongTy(ms);
        lstDeTai = daiDienCongTyController.GetDeTai(ms);
        lstGiangVienHuongDan = daiDienCongTyController.GetAllGVHDofACongTy(ms);
        session.put("CTCongTy", "CTCongTy");
        return SUCCESS;
    }

    public String GetAllNhanVien() {
        lstDaiDienCongTy = daiDienCongTyController.GetDaiDienCongTy((String) session.get("email"));
        int ms = lstDaiDienCongTy.get(0).getMaCongTy();
        lstGiangVienHuongDan = daiDienCongTyController.GetAllGVHDofACongTy(ms);
        session.put("NhanVien", "NhanVien");
        return SUCCESS;
    }

    public String AddNhanVien() {
        Login l = new Login();
        l.setEmail(nhanVien.getEmail());
        l.setPassword(nhanVien.getDienThoai());
        l.setRule(2);
        if (daiDienCongTyController.SaveTKNhanVien(l)) {
            String avatar = null;
            try {
                path = request.getSession().getServletContext().getRealPath("/").concat("images/avatar/");
                File fileToCreate = new File(path, this.myFileFileName);
                FileUtils.copyFile(this.myFile, fileToCreate);
                avatar = "images/avatar/" + myFileFileName;
            } catch (Exception e) {
                e.printStackTrace();
                addActionError(e.getMessage());
            }
            lstDaiDienCongTy = daiDienCongTyController.GetDaiDienCongTy((String) session.get("email"));
            int ms = lstDaiDienCongTy.get(0).getMaCongTy();
            nhanVien.setAvatar(avatar);
            nhanVien.setMsct(ms);
            if (daiDienCongTyController.SaveNhanVien(nhanVien)) {
                return SUCCESS;
            }
        }
        return ERROR;
    }

    public String LogOut() {
        session.clear();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}
