/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controllers.*;
import entities.*;
import entitiesmapping.SinhVienDiemThi;
import entitiesmapping.SinhVienvaThucTap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author sonnguyen
 */
public class GvhdAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private HttpServletRequest request;
    private Map<String, Object> session;
    private GvhdController gvhdController;
    private DdctController daiDienCongTyController;
    private GvttController giangVienThucTapController;
    private List<SinhVienvaThucTap> lstSinhVienvaThucTap = new ArrayList<>();
    private List<SinhVien> lstSinhVien = new ArrayList<>();
    private List<SinhVienKnvaLt> lstKNLT = new ArrayList<>();
    private List<SinhVienMucTieu> lstMucTieu = new ArrayList<>();
    private File myFile;
    private File myFileDanhGia;
    private String myFileFileName;
    private String myFileDanhGiaFileName;
    private String path;

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public File getMyFileDanhGia() {
        return myFileDanhGia;
    }

    public void setMyFileDanhGia(File myFileDanhGia) {
        this.myFileDanhGia = myFileDanhGia;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getMyFileDanhGiaFileName() {
        return myFileDanhGiaFileName;
    }

    public void setMyFileDanhGiaFileName(String myFileDanhGiaFileName) {
        this.myFileDanhGiaFileName = myFileDanhGiaFileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SinhVien> getLstSinhVien() {
        return lstSinhVien;
    }

    public void setLstSinhVien(List<SinhVien> lstSinhVien) {
        this.lstSinhVien = lstSinhVien;
    }

    public List<SinhVienKnvaLt> getLstKNLT() {
        return lstKNLT;
    }

    public void setLstKNLT(List<SinhVienKnvaLt> lstKNLT) {
        this.lstKNLT = lstKNLT;
    }

    public List<SinhVienMucTieu> getLstMucTieu() {
        return lstMucTieu;
    }

    public void setLstMucTieu(List<SinhVienMucTieu> lstMucTieu) {
        this.lstMucTieu = lstMucTieu;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public List<SinhVienvaThucTap> getLstSinhVienvaThucTap() {
        return lstSinhVienvaThucTap;
    }

    public void setLstSinhVienvaThucTap(List<SinhVienvaThucTap> lstSinhVienvaThucTap) {
        this.lstSinhVienvaThucTap = lstSinhVienvaThucTap;
    }

    public GvhdAction() {
        gvhdController = new GvhdController();
        daiDienCongTyController = new DdctController();
        giangVienThucTapController = new GvttController();
    }

    public String GetAllSinhVien() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        lstSinhVien = gvhdController.GetAllSinhVien();
        lstSinhVienThucTap = gvhdController.GetAllSinhVienThucTap((int) session.get("msgvhd"));
        for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
            for (int j = 0; j < lstSinhVien.size(); j++) {
                if (lstSinhVien.get(j).getMssv() == lstSinhVienThucTap.get(i).getMssv()) {
                    SinhVienvaThucTap sinhVienvaThucTap = new SinhVienvaThucTap();
                    sinhVienvaThucTap.setHoTen(lstSinhVien.get(j).getHoTen());
                    sinhVienvaThucTap.setMssv(lstSinhVien.get(j).getMssv());
                    sinhVienvaThucTap.setKhoa(lstSinhVien.get(j).getKhoa());
                    sinhVienvaThucTap.setLop(lstSinhVien.get(j).getLop());
                    sinhVienvaThucTap.setMaDeTai(lstSinhVienThucTap.get(i).getMaDeTai());
                    sinhVienvaThucTap.setThoiGianBatDau(lstSinhVienThucTap.get(i).getThoiGianBatDau());
                    sinhVienvaThucTap.setThoiGianKetThuc(lstSinhVienThucTap.get(i).getThoiGianKetThuc());
                    lstSinhVienvaThucTap.add(sinhVienvaThucTap);
                    continue;
                }

            }

        }
        session.put("GVHDSinhVienThucTap", "GVHDSinhVienThucTap");
        return SUCCESS;
    }

    public String ChamDiemSinhVien() {
        List<TinNhanEmail> lstTinNhanEmail = new ArrayList<>();
        List<HeSoDiem> lsHeSoDiem = new ArrayList<>();
        lstTinNhanEmail = giangVienThucTapController.SoLuongPhanHoi(Integer.parseInt(request.getParameter("mssv")));
        lsHeSoDiem = giangVienThucTapController.GetHeSoDiem();
        int soLuong = lstTinNhanEmail.size();
        SinhVienDiem diem = new SinhVienDiem();
        diem.setMssv(Integer.parseInt(request.getParameter("mssv")));
        diem.setDiemBaoCaoQuaTrinh(Double.parseDouble(request.getParameter("diemQuaTrinh")));
        diem.setCuoiKy(Double.parseDouble(request.getParameter("diemCuoiKy")));
        diem.setDiemPhanHoi(soLuong * 1.67);
        diem.setTrangThai(false);
        diem.setQuaTrinh(soLuong * 1.67 * lsHeSoDiem.get(0).getHeSoPhanHoi()
                + Double.parseDouble(request.getParameter("diemQuaTrinh")) * lsHeSoDiem.get(0).getHeSoBaoCaoQuaTrinh());
        gvhdController.SaveDiem(diem);
        GetAllDiemSinhVien();
        return SUCCESS;
    }

    public String GetAllDiemSinhVien() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<SinhVienDiem> sinhVienDiems = new ArrayList<>();
        lstSinhVien = gvhdController.GetAllSinhVien();
        lstSinhVienThucTap = gvhdController.GetAllSinhVienThucTap((int) session.get("msgvhd"));
        sinhVienDiems = giangVienThucTapController.GetAllDiemSinhVien();

        for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
            for (int j = 0; j < lstSinhVien.size(); j++) {
                if (lstSinhVien.get(j).getMssv() == lstSinhVienThucTap.get(i).getMssv()) {
                    boolean check = false;
                    for (int k = 0; k < sinhVienDiems.size(); k++) {
                        if (sinhVienDiems.get(k).getMssv() == lstSinhVien.get(j).getMssv()) {
                            check = true;
                        }
                    }
                    if (check == false) {
                        SinhVienvaThucTap sinhVienvaThucTap = new SinhVienvaThucTap();
                        sinhVienvaThucTap.setHoTen(lstSinhVien.get(j).getHoTen());
                        sinhVienvaThucTap.setMssv(lstSinhVien.get(j).getMssv());
                        sinhVienvaThucTap.setKhoa(lstSinhVien.get(j).getKhoa());
                        sinhVienvaThucTap.setLop(lstSinhVien.get(j).getLop());
                        lstSinhVienvaThucTap.add(sinhVienvaThucTap);
                        continue;
                    }

                }

            }

        }
        session.put("DiemThi", "DiemThi");
        return SUCCESS;
    }

    public String GetCVSinhVien() {
        int x = Integer.parseInt(request.getParameter("mssv"));
        lstSinhVien = daiDienCongTyController.GetInfoSinhVien(x);
        lstKNLT = daiDienCongTyController.GetKNLTSinhVien(x);
        lstMucTieu = daiDienCongTyController.GetMucTieuSV(x);
        return SUCCESS;
    }

    public String DanhGiaChamCong() {
        String fileChamCong = null;
        String fileDanhGia = null;
        int mssv = Integer.parseInt(request.getParameter("mssv"));
        SinhVienFile sinhVienFileDG = new SinhVienFile();
        SinhVienFile sinhVienFileCC = new SinhVienFile();
        try {
            path = request.getSession().getServletContext().getRealPath("/").concat("file/sinhvien/");
            File fileToCreate = new File(path, this.myFileFileName);
            FileUtils.copyFile(this.myFile, fileToCreate);
            fileChamCong = "file/sinhvien/" + myFileFileName;
            File fileToCreateLOGO = new File(path, this.myFileDanhGiaFileName);
            FileUtils.copyFile(this.myFileDanhGia, fileToCreateLOGO);
            fileDanhGia = "file/sinhvien/" + myFileDanhGiaFileName;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        sinhVienFileDG.setLink(fileDanhGia);
        sinhVienFileDG.setLoaiFile(4);// chấm công 3- đánh giá 4
        sinhVienFileDG.setMssv(mssv);
        sinhVienFileDG.setNgayThang(sqlDate);
        sinhVienFileDG.setTenFile(myFileDanhGiaFileName);

        sinhVienFileCC.setLink(fileChamCong);
        sinhVienFileCC.setLoaiFile(3);// chấm công 3- đánh giá 4
        sinhVienFileCC.setMssv(mssv);
        sinhVienFileCC.setNgayThang(sqlDate);
        sinhVienFileCC.setTenFile(myFileFileName);

        gvhdController.UploadFileSinhVien(sinhVienFileCC);
        gvhdController.UploadFileSinhVien(sinhVienFileDG);
        session.put("ThanhCong", "ThanhCong");

        return SUCCESS;

    }

    public String Logout() {
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
