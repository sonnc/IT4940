/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import controllers.*;
import entities.*;
import entitiesmapping.CongTyDeTai;
import entitiesmapping.SinhVienDeTai;
import entitiesmapping.SinhVienDiemThi;
import entitiesmapping.SinhVienvaThucTap;
import entitiesmapping.XuatFileThongTinSinhVien;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author sonnguyen
 */
public class GvttAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private HttpServletRequest request;
    private Map<String, Object> session;
    private GvttController giangVienThucTapController;
    private GiangVien giangVien;
    private GiangVienChiTiet giangVienChiTiet;
    private String diemQuaTrinh;
    private String diemCuoiKy;
    private OtherController otherController;

    private List<GiangVien> lstGiangVien = new ArrayList<>();
    private List<GiangVienChiTiet> lstGiangVienChiTiet = new ArrayList<>();
    private List<DeTai> lstDeTai = new ArrayList<>();
    private List<CongTy> lstCongTy = new ArrayList<>();
    private List<CongTyDeTai> lstCTDT = new ArrayList<>();
    private List<DaiDienCongTy> lstDaiDienCongTy = new ArrayList<>();
    private List<GiangVienHuongDan> lstGiangVienHuongDan = new ArrayList<>();
    private List<SinhVien> lstSinhVien = new ArrayList<>();
    private List<SinhVienKnvaLt> lstKNLT = new ArrayList<>();
    private List<SinhVienMucTieu> lstMucTieu = new ArrayList<>();
    private List<SinhVienvaThucTap> lstSinhVienvaThucTap = new ArrayList<>();
    List<SinhVienDeTai> lstSinhVienDeTai = new ArrayList<>();
    List<SinhVienDiemThi> lstSinhVienDiem = new ArrayList<>();
    List<HeSoDiem> lstHeSoDiem = new ArrayList<>();
    private List<SinhVienFile> lstSinhVienFile = new ArrayList<>();
    private List<SinhVienFile> lstSinhVienFileBCCK = new ArrayList<>();
    private List<SinhVienFile> lstSinhVienFileBCQT = new ArrayList<>();
    private List<SinhVienFile> lstSinhVienFileCC = new ArrayList<>();
    private List<SinhVienFile> lstSinhVienFileDG = new ArrayList<>();
    private List<SinhVienFile> lstGiangVienFile = new ArrayList<>();
    private List<SinhVienFile> lstFileChiTiet = new ArrayList<>();
    private List<ThongBao> lstThongBaoLichTrinh = new ArrayList<>();
    private File myFile;
    private String myFileFileName;
    private String path;
    private String tenFile;

    public List<ThongBao> getLstThongBaoLichTrinh() {
        return lstThongBaoLichTrinh;
    }

    public List<SinhVienFile> getLstFileChiTiet() {
        return lstFileChiTiet;
    }

    public void setLstFileChiTiet(List<SinhVienFile> lstFileChiTiet) {
        this.lstFileChiTiet = lstFileChiTiet;
    }

    public void setLstThongBaoLichTrinh(List<ThongBao> lstThongBaoLichTrinh) {
        this.lstThongBaoLichTrinh = lstThongBaoLichTrinh;
    }

    public List<SinhVienFile> getLstGiangVienFile() {
        return lstGiangVienFile;
    }

    public void setLstGiangVienFile(List<SinhVienFile> lstGiangVienFile) {
        this.lstGiangVienFile = lstGiangVienFile;
    }

    public List<SinhVienFile> getLstSinhVienFileBCCK() {
        return lstSinhVienFileBCCK;
    }

    public void setLstSinhVienFileBCCK(List<SinhVienFile> lstSinhVienFileBCCK) {
        this.lstSinhVienFileBCCK = lstSinhVienFileBCCK;
    }

    public List<SinhVienFile> getLstSinhVienFileBCQT() {
        return lstSinhVienFileBCQT;
    }

    public void setLstSinhVienFileBCQT(List<SinhVienFile> lstSinhVienFileBCQT) {
        this.lstSinhVienFileBCQT = lstSinhVienFileBCQT;
    }

    public List<SinhVienFile> getLstSinhVienFileCC() {
        return lstSinhVienFileCC;
    }

    public void setLstSinhVienFileCC(List<SinhVienFile> lstSinhVienFileCC) {
        this.lstSinhVienFileCC = lstSinhVienFileCC;
    }

    public List<SinhVienFile> getLstSinhVienFileDG() {
        return lstSinhVienFileDG;
    }

    public void setLstSinhVienFileDG(List<SinhVienFile> lstSinhVienFileDG) {
        this.lstSinhVienFileDG = lstSinhVienFileDG;
    }

    public List<SinhVienFile> getLstSinhVienFile() {
        return lstSinhVienFile;
    }

    public void setLstSinhVienFile(List<SinhVienFile> lstSinhVienFile) {
        this.lstSinhVienFile = lstSinhVienFile;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
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

    public String getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(String diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public String getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(String diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public List<HeSoDiem> getLstHeSoDiem() {
        return lstHeSoDiem;
    }

    public void setLstHeSoDiem(List<HeSoDiem> lstHeSoDiem) {
        this.lstHeSoDiem = lstHeSoDiem;
    }

    public List<SinhVienDiemThi> getLstSinhVienDiem() {
        return lstSinhVienDiem;
    }

    public void setLstSinhVienDiem(List<SinhVienDiemThi> lstSinhVienDiem) {
        this.lstSinhVienDiem = lstSinhVienDiem;
    }

    public List<SinhVienDeTai> getLstSinhVienDeTai() {
        return lstSinhVienDeTai;
    }

    public void setLstSinhVienDeTai(List<SinhVienDeTai> lstSinhVienDeTai) {
        this.lstSinhVienDeTai = lstSinhVienDeTai;
    }

    public List<SinhVienvaThucTap> getLstSinhVienvaThucTap() {
        return lstSinhVienvaThucTap;
    }

    public void setLstSinhVienvaThucTap(List<SinhVienvaThucTap> lstSinhVienvaThucTap) {
        this.lstSinhVienvaThucTap = lstSinhVienvaThucTap;
    }

    public List<SinhVien> getLstSinhVien() {
        return lstSinhVien;
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

    public void setLstSinhVien(List<SinhVien> lstSinhVien) {
        this.lstSinhVien = lstSinhVien;
    }

    public List<DaiDienCongTy> getLstDaiDienCongTy() {
        return lstDaiDienCongTy;
    }

    public void setLstDaiDienCongTy(List<DaiDienCongTy> lstDaiDienCongTy) {
        this.lstDaiDienCongTy = lstDaiDienCongTy;
    }

    public List<GiangVienHuongDan> getLstGiangVienHuongDan() {
        return lstGiangVienHuongDan;
    }

    public void setLstGiangVienHuongDan(List<GiangVienHuongDan> lstGiangVienHuongDan) {
        this.lstGiangVienHuongDan = lstGiangVienHuongDan;
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

    public List<CongTyDeTai> getLstCTDT() {
        return lstCTDT;
    }

    public void setLstCTDT(List<CongTyDeTai> lstCTDT) {
        this.lstCTDT = lstCTDT;
    }

    public List<GiangVien> getLstGiangVien() {
        return lstGiangVien;
    }

    public void setLstGiangVien(List<GiangVien> lstGiangVien) {
        this.lstGiangVien = lstGiangVien;
    }

    public List<GiangVienChiTiet> getLstGiangVienChiTiet() {
        return lstGiangVienChiTiet;
    }

    public void setLstGiangVienChiTiet(List<GiangVienChiTiet> lstGiangVienChiTiet) {
        this.lstGiangVienChiTiet = lstGiangVienChiTiet;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public GiangVienChiTiet getGiangVienChiTiet() {
        return giangVienChiTiet;
    }

    public void setGiangVienChiTiet(GiangVienChiTiet giangVienChiTiet) {
        this.giangVienChiTiet = giangVienChiTiet;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public GvttAction() {
        giangVienThucTapController = new GvttController();
        otherController = new OtherController();
    }

    public String GetInfoGiangVien() {
        lstGiangVien = giangVienThucTapController.GetInfoGiangVien((String) session.get("email"));
        return SUCCESS;
    }

    public String SaveInfo() {
        giangVien.setEmail((String) session.get("email"));

        if (giangVienThucTapController.SaveInfoGiangVien(giangVien)) {
            lstGiangVien = giangVienThucTapController.GetInfoGiangVien((String) session.get("email"));
            if (lstGiangVien.size() == 1) {
                if (giangVienThucTapController.SaveInfoGiangVienChiTiet(giangVienChiTiet)) {
                    session.put("lstGiangVienThucTap", lstGiangVien);
                    return SUCCESS;
                }
            }
        }
        return ERROR;

    }

    public String GetAllDeTai() {
        lstDeTai = giangVienThucTapController.GetAllDeTai();
        lstCongTy = giangVienThucTapController.GetAllCongTy();
        for (int i = 0; i < lstCongTy.size(); i++) {
            for (int j = 0; j < lstDeTai.size(); j++) {
                if (lstCongTy.get(i).getMsct() == lstDeTai.get(j).getMaCongTy()) {
                    CongTyDeTai congTyDeTai = new CongTyDeTai();
                    congTyDeTai.setTenCongTy(lstCongTy.get(i).getTenCongTy());
                    congTyDeTai.setAvatar(lstCongTy.get(i).getAvatar());
                    congTyDeTai.setMsct(lstCongTy.get(i).getMsct());
                    congTyDeTai.setId(lstDeTai.get(j).getId()); // mã đề tài
                    congTyDeTai.setTenDeTai(lstDeTai.get(j).getTenDeTai());
                    congTyDeTai.setNoiDung(lstDeTai.get(j).getNoiDung());
                    congTyDeTai.setYeuCau(lstDeTai.get(j).getYeuCau());
                    congTyDeTai.setSoLuong(lstDeTai.get(j).getSoLuong());
                    lstCTDT.add(congTyDeTai);
                }

            }
        }
        session.put("DeTai", "DeTai");
        return SUCCESS;
    }

    public String GetChiTietDeTai() {
        int maDeTai = Integer.parseInt(request.getParameter("maDeTai"));
        lstDeTai = giangVienThucTapController.GetDeTaibyID(maDeTai);
        lstCongTy = giangVienThucTapController.GetCongTyByID(lstDeTai.get(0).getMaCongTy());
        CongTyDeTai congTyDeTai = new CongTyDeTai();
        congTyDeTai.setTenCongTy(lstCongTy.get(0).getTenCongTy());
        congTyDeTai.setAvatar(lstCongTy.get(0).getAvatar());
        congTyDeTai.setMsct(lstCongTy.get(0).getMsct());
        congTyDeTai.setDiaChi(lstCongTy.get(0).getDiaChi());
        congTyDeTai.setEmail(lstCongTy.get(0).getEmail());
        congTyDeTai.setWebsite(lstCongTy.get(0).getWebsite());
        congTyDeTai.setDienThoai(lstCongTy.get(0).getDienThoai());
        congTyDeTai.setId(lstDeTai.get(0).getId()); // mã đề tài
        congTyDeTai.setTenDeTai(lstDeTai.get(0).getTenDeTai());
        congTyDeTai.setNoiDung(lstDeTai.get(0).getNoiDung());
        congTyDeTai.setYeuCau(lstDeTai.get(0).getYeuCau());
        congTyDeTai.setSoLuong(lstDeTai.get(0).getSoLuong());
        lstCTDT.add(congTyDeTai);
        session.put("ChiTietDeTai", "ChiTietDeTai");
        return SUCCESS;
    }

    public String DongYDeTai() {
        int maDeTai = Integer.parseInt(request.getParameter("maDeTai"));
        if (giangVienThucTapController.DongYDeTai(maDeTai)) {
            session.put("DuyetDeTaiThanhCong", maDeTai);
        } else {
            session.put("DuyetDeTaiThatBai", maDeTai);
        }
        GetAllDeTai();
        return SUCCESS;
    }

    public String TuChoiDeTai() {
        int maDeTai = Integer.parseInt(request.getParameter("maDeTai"));
        if (giangVienThucTapController.TuChoiDeTai(maDeTai)) {
            session.put("DuyetDeTaiThanhCong", maDeTai);
        } else {
            session.put("DuyetDeTaiThatBai", maDeTai);
        }
        GetAllDeTai();
        return SUCCESS;
    }

    public String GettAllDeTaiTuChoi() {
        lstDeTai = giangVienThucTapController.GetAllDeTaiTuChoi();
        lstCongTy = giangVienThucTapController.GetAllCongTy();
        for (int i = 0; i < lstCongTy.size(); i++) {
            for (int j = 0; j < lstDeTai.size(); j++) {
                if (lstCongTy.get(i).getMsct() == lstDeTai.get(j).getMaCongTy()) {
                    CongTyDeTai congTyDeTai = new CongTyDeTai();
                    congTyDeTai.setTenCongTy(lstCongTy.get(i).getTenCongTy());
                    congTyDeTai.setAvatar(lstCongTy.get(i).getAvatar());
                    congTyDeTai.setMsct(lstCongTy.get(i).getMsct());
                    congTyDeTai.setId(lstDeTai.get(j).getId()); // mã đề tài
                    congTyDeTai.setTenDeTai(lstDeTai.get(j).getTenDeTai());
                    congTyDeTai.setNoiDung(lstDeTai.get(j).getNoiDung());
                    congTyDeTai.setYeuCau(lstDeTai.get(j).getYeuCau());
                    congTyDeTai.setSoLuong(lstDeTai.get(j).getSoLuong());
                    lstCTDT.add(congTyDeTai);
                }

            }
        }
        session.put("DongYTuChoi", "DongYTuChoi");
        session.put("DeTai", "DeTai");
        return SUCCESS;
    }

    public String GettAllDeTaiDongY() {
        lstDeTai = giangVienThucTapController.GetAllDeTaiDongY();
        lstCongTy = giangVienThucTapController.GetAllCongTy();
        for (int i = 0; i < lstCongTy.size(); i++) {
            for (int j = 0; j < lstDeTai.size(); j++) {
                if (lstCongTy.get(i).getMsct() == lstDeTai.get(j).getMaCongTy()) {
                    CongTyDeTai congTyDeTai = new CongTyDeTai();
                    congTyDeTai.setTenCongTy(lstCongTy.get(i).getTenCongTy());
                    congTyDeTai.setAvatar(lstCongTy.get(i).getAvatar());
                    congTyDeTai.setMsct(lstCongTy.get(i).getMsct());
                    congTyDeTai.setId(lstDeTai.get(j).getId()); // mã đề tài
                    congTyDeTai.setTenDeTai(lstDeTai.get(j).getTenDeTai());
                    congTyDeTai.setNoiDung(lstDeTai.get(j).getNoiDung());
                    congTyDeTai.setYeuCau(lstDeTai.get(j).getYeuCau());
                    congTyDeTai.setSoLuong(lstDeTai.get(j).getSoLuong());
                    lstCTDT.add(congTyDeTai);
                }

            }
        }
        session.put("DongYTuChoi", "DongYTuChoi");
        session.put("DeTai", "DeTai");
        return SUCCESS;
    }

    public String GetAllCongTy() {
        lstCongTy = giangVienThucTapController.GetAllCongTy();
        session.put("DSCongTy", "DSCongTy");
        return SUCCESS;
    }

    public String GetChiTietCongTy() {
        int ms = Integer.parseInt(request.getParameter("maCongTy"));
        lstCongTy = giangVienThucTapController.GetChiTietCongTy(ms);
        lstDeTai = giangVienThucTapController.GetDeTai(ms);
        lstDaiDienCongTy = giangVienThucTapController.GetDaiDienCongTy(ms);
        lstGiangVienHuongDan = giangVienThucTapController.GetAllGVHDofACongTy(ms);
        session.put("CTCongTy", "CTCongTy");
        return SUCCESS;
    }

    public String GetAllSinhVien() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<SinhVienThucTap> lstCheckSinhVienThucTap = new ArrayList<>();
        SinhVienvaThucTap sinhVienvaThucTap = new SinhVienvaThucTap();
        lstSinhVien = giangVienThucTapController.GetAllSinhVien();
        lstSinhVienThucTap = giangVienThucTapController.GetAllSinhVienThucTap();
        lstCheckSinhVienThucTap = giangVienThucTapController.CheckSoLanThucTap();
        for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
            for (int j = 0; j < lstSinhVien.size(); j++) {
                if (lstSinhVienThucTap.get(i).getMssv() == lstSinhVien.get(j).getMssv()) {
                    sinhVienvaThucTap.setMssv(lstSinhVien.get(j).getMssv());
                    sinhVienvaThucTap.setDiaChi(lstSinhVien.get(j).getDiaChi());
                    sinhVienvaThucTap.setDienThoai(lstSinhVien.get(j).getDienThoai());
                    sinhVienvaThucTap.setEmail(lstSinhVien.get(j).getEmail());
                    sinhVienvaThucTap.setHoTen(lstSinhVien.get(j).getHoTen());
                    sinhVienvaThucTap.setLop(lstSinhVien.get(j).getLop());
                    sinhVienvaThucTap.setKhoa(lstSinhVien.get(j).getKhoa());
                    sinhVienvaThucTap.setThoiGianBatDau(lstSinhVienThucTap.get(i).getThoiGianBatDau());
                    sinhVienvaThucTap.setThoiGianKetThuc(lstSinhVienThucTap.get(i).getThoiGianKetThuc());
                    int x = 0;
                    for (int k = 0; k < lstCheckSinhVienThucTap.size(); k++) {
                        if (lstCheckSinhVienThucTap.get(k).getSoLanThucTap() == true) {
                            x++;
                        }
                    }
                    sinhVienvaThucTap.setSoLanThucTap(x);
                    lstSinhVienvaThucTap.add(sinhVienvaThucTap);
                    break;
                }
            }
        }
        session.put("DanhSachSinhVien", "DanhSachSinhVien");
        return SUCCESS;
    }

    public String GetCVSinhVien() {
        int x = Integer.parseInt(request.getParameter("mssv"));
        lstSinhVien = giangVienThucTapController.GetInfoSinhVien(x);
        lstKNLT = giangVienThucTapController.GetKNLTSinhVien(x);
        lstMucTieu = giangVienThucTapController.GetMucTieuSV(x);
        return SUCCESS;
    }

    public String GetAllDeTaiSinhVien() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTapCHECK = new ArrayList<>();
        List<SinhVienDeTai> lstSinhVienDeTaiDongY = new ArrayList<>();
        List<CongTy> lstCongTy = new ArrayList<>();
        List<DeTai> lstDeTai = new ArrayList<>();
        lstSinhVien = giangVienThucTapController.GetAllSinhVien();
        lstSinhVienThucTap = giangVienThucTapController.GetAllSinhVienThucTapDuyetDT();
        lstCongTy = giangVienThucTapController.GetAllCongTy();
        lstDeTai = giangVienThucTapController.GetAllDeTaiCHECK();

        for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
            if (lstSinhVienThucTap.get(i).getTrangThai() == 1) {
                SinhVienDeTai svtt = new SinhVienDeTai();
                svtt.setMssv(lstSinhVienThucTap.get(i).getMssv());
                lstSinhVienDeTaiDongY.add(svtt);
            }

        }
        for (int i = 0; i < lstSinhVienDeTaiDongY.size(); i++) {
            for (int j = 0; j < lstSinhVienThucTap.size(); j++) {
                if (lstSinhVienDeTaiDongY.get(i).getMssv() == lstSinhVienThucTap.get(j).getMssv()) {
                    SinhVienThucTap sinhVienThucTap = new SinhVienThucTap();
                    lstSinhVienThucTap.set(j, sinhVienThucTap);
                }
            }

        }
        for (int i = 0; i < lstSinhVien.size(); i++) {
            for (int j = 0; j < lstSinhVienThucTap.size(); j++) {
                if (lstSinhVien.get(i).getMssv() == lstSinhVienThucTap.get(j).getMssv()) {
                    SinhVienDeTai sinhVienDeTai = new SinhVienDeTai();
                    sinhVienDeTai.setChiSoSoKhop(lstSinhVienThucTap.get(j).getSoKhop());
                    sinhVienDeTai.setHoTen(lstSinhVien.get(i).getHoTen());
                    sinhVienDeTai.setKhoa(lstSinhVien.get(i).getKhoa());
                    sinhVienDeTai.setLop(lstSinhVien.get(i).getLop());
                    sinhVienDeTai.setMaCongTy(lstSinhVienThucTap.get(j).getMaCongTy());
                    sinhVienDeTai.setMssv(lstSinhVien.get(i).getMssv());
                    sinhVienDeTai.setMaDeTai(lstSinhVienThucTap.get(j).getMaDeTai());
                    sinhVienDeTai.setId(lstSinhVienThucTap.get(j).getId());
                    for (int k = 0; k < lstCongTy.size(); k++) {
                        if (lstCongTy.get(k).getMsct() == lstSinhVienThucTap.get(j).getMaCongTy()) {
                            sinhVienDeTai.setTenCongTy(lstCongTy.get(k).getTenCongTy());
                            continue;
                        }
                    }
                    for (int k = 0; k < lstDeTai.size(); k++) {
                        if (lstDeTai.get(k).getId() == lstSinhVienThucTap.get(j).getMaDeTai()) {
                            sinhVienDeTai.setTenDeTai(lstDeTai.get(k).getTenDeTai());
                            continue;
                        }

                    }
                    lstSinhVienDeTai.add(sinhVienDeTai);
                    continue;
                }
            }

        }
        session.put("DuyetDeTaiSinhVien", "DuyetDeTaiSinhVien");
        return SUCCESS;
    }

    public String DuyetDeTaiSV() {
        // cập nhật trạng thái và sô lần thực tập
        int mssv = Integer.parseInt(request.getParameter("mssv"));
        int maDeTai = Integer.parseInt(request.getParameter("maDeTai"));
        int id = Integer.parseInt(request.getParameter("id"));
        String duyet = request.getParameter("duyet");
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        if (duyet.equals("true")) {
            lstSinhVienThucTap = giangVienThucTapController.GetSVTTbyMSSV(mssv);
            for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
                SinhVienThucTap sinhVienThucTap = new SinhVienThucTap();
                sinhVienThucTap = giangVienThucTapController.GetSVTTbyMSSVbyID(lstSinhVienThucTap.get(i).getId());

                if (lstSinhVienThucTap.get(i).getId() == id) {
                    sinhVienThucTap.setTrangThai(1);
                    sinhVienThucTap.setSoLanThucTap(true);
                } else {
                    sinhVienThucTap.setTrangThai(2);
                    sinhVienThucTap.setSoLanThucTap(false);
                }
                giangVienThucTapController.DongYDeTaiSinhVien(sinhVienThucTap);

            }
        } else {
            SinhVienThucTap sinhVienThucTap = new SinhVienThucTap();
            sinhVienThucTap = giangVienThucTapController.GetSVTTbyMSSVbyID(id);
            sinhVienThucTap.setTrangThai(2);
            sinhVienThucTap.setSoLanThucTap(false);
            giangVienThucTapController.DongYDeTaiSinhVien(sinhVienThucTap);
        }
//        if (lstSinhVienThucTap.size() > 0) {
//            for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
//                SinhVienThucTap sinhVienThucTap = new SinhVienThucTap();
//                sinhVienThucTap.setHoatDong(lstSinhVienThucTap.get(i).getHoatDong());
//                sinhVienThucTap.setId(lstSinhVienThucTap.get(i).getId());
//                sinhVienThucTap.setMaCongTy(lstSinhVienThucTap.get(i).getMaCongTy());
//                sinhVienThucTap.setMaDeTai(lstSinhVienThucTap.get(i).getMaDeTai());
//                sinhVienThucTap.setNguoiHuongDan(lstSinhVienThucTap.get(i).getNguoiHuongDan());
//                sinhVienThucTap.setMssv(lstSinhVienThucTap.get(i).getMssv());
//                sinhVienThucTap.setSoKhop(lstSinhVienThucTap.get(i).getSoKhop());
//                sinhVienThucTap.setThoiGianBatDau(lstSinhVienThucTap.get(i).getThoiGianBatDau());
//                sinhVienThucTap.setThoiGianKetThuc(lstSinhVienThucTap.get(i).getThoiGianKetThuc());
//                if (lstSinhVienThucTap.get(i).getMaDeTai() == maDeTai) {
//                    sinhVienThucTap.setTrangThai(1);
//                    sinhVienThucTap.setSoLanThucTap(true);
//                } else {
//                    sinhVienThucTap.setTrangThai(2);
//                    sinhVienThucTap.setSoLanThucTap(false);
//                }
//                if (giangVienThucTapController.DongYDeTaiSinhVien(sinhVienThucTap) == false) {
//                    return ERROR;
//                }
//            }
//
//        }
        GetAllDeTaiSinhVien();
        return SUCCESS;
    }

    public String GetAllDeTaiSinhVienThanhCong() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTapCHECK = new ArrayList<>();
        List<SinhVienDeTai> lstSinhVienDeTaiDongY = new ArrayList<>();
        List<CongTy> lstCongTy = new ArrayList<>();
        List<DeTai> lstDeTai = new ArrayList<>();
        lstSinhVien = giangVienThucTapController.GetAllSinhVien();
        lstSinhVienThucTap = giangVienThucTapController.DanhSachDetaiSinhVienThanhCong();
        lstCongTy = giangVienThucTapController.GetAllCongTy();
        lstDeTai = giangVienThucTapController.GetAllDeTaiCHECK();
        for (int i = 0; i < lstSinhVien.size(); i++) {
            for (int j = 0; j < lstSinhVienThucTap.size(); j++) {
                if (lstSinhVien.get(i).getMssv() == lstSinhVienThucTap.get(j).getMssv()) {
                    SinhVienDeTai sinhVienDeTai = new SinhVienDeTai();
                    sinhVienDeTai.setChiSoSoKhop(lstSinhVienThucTap.get(j).getSoKhop());
                    sinhVienDeTai.setHoTen(lstSinhVien.get(i).getHoTen());
                    sinhVienDeTai.setKhoa(lstSinhVien.get(i).getKhoa());
                    sinhVienDeTai.setLop(lstSinhVien.get(i).getLop());
                    sinhVienDeTai.setMaCongTy(lstSinhVienThucTap.get(j).getMaCongTy());
                    sinhVienDeTai.setMssv(lstSinhVien.get(i).getMssv());
                    sinhVienDeTai.setMaDeTai(lstSinhVienThucTap.get(j).getMaDeTai());
                    sinhVienDeTai.setId(lstSinhVienThucTap.get(j).getId());
                    for (int k = 0; k < lstCongTy.size(); k++) {
                        if (lstCongTy.get(k).getMsct() == lstSinhVienThucTap.get(j).getMaCongTy()) {
                            sinhVienDeTai.setTenCongTy(lstCongTy.get(k).getTenCongTy());
                            continue;
                        }
                    }
                    for (int k = 0; k < lstDeTai.size(); k++) {
                        if (lstDeTai.get(k).getId() == lstSinhVienThucTap.get(j).getMaDeTai()) {
                            sinhVienDeTai.setTenDeTai(lstDeTai.get(k).getTenDeTai());
                            continue;
                        }

                    }
                    lstSinhVienDeTai.add(sinhVienDeTai);
                    continue;
                }
            }

        }
        session.put("DuyetDeTaiSinhVien", "DuyetDeTaiSinhVien");
        return SUCCESS;

    }

    public String GetSinhVienFile() {
        List<SinhVien> lsSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<SinhVienFile> lstSinhVienFile = new ArrayList<>();

        return SUCCESS;
    }

    public String ChamDiemSinhVien() {
        List<SinhVien> lsSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<TinNhanEmail> lstTinNhanEmail = new ArrayList<>();
        List<SinhVienDiem> sinhVienDiems = new ArrayList<>();
        lsSinhVien = giangVienThucTapController.GetAllSinhVien();
        lstSinhVienThucTap = giangVienThucTapController.GetHoatDongTrangThaiSoLanThucTap();
        sinhVienDiems = giangVienThucTapController.GetAllDiemSinhVien();
        lstTinNhanEmail = giangVienThucTapController.GetAllEmailPhanHoi();
        int soLuong = 0;
        boolean chay = true;
        if (lstTinNhanEmail.size() == 0) {
            chay = false;
        }
        for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
            for (int j = 0; j < lsSinhVien.size(); j++) {
                for (int k = 0; k < sinhVienDiems.size(); k++) {
                    if (lstSinhVienThucTap.get(i).getMssv() == lsSinhVien.get(j).getMssv()
                            && lsSinhVien.get(j).getMssv() == sinhVienDiems.get(k).getMssv()) {
                        SinhVienDiemThi sinhVienDiemThi = new SinhVienDiemThi();
                        sinhVienDiemThi.setMssv(lsSinhVien.get(j).getMssv());
                        sinhVienDiemThi.setLop(lsSinhVien.get(j).getLop());
                        sinhVienDiemThi.setHoTen(lsSinhVien.get(j).getHoTen());
                        sinhVienDiemThi.setDiemQuaTrinhCT(sinhVienDiems.get(k).getQuaTrinh());
                        sinhVienDiemThi.setDiemCuoiKyCT(sinhVienDiems.get(k).getCuoiKy());

                        if (chay) {
                            for (int l = 0; l < lstTinNhanEmail.size(); l++) {
                                if (lstTinNhanEmail.get(l).getMssv() == lsSinhVien.get(j).getMssv()) {
                                    soLuong++;
                                }

                            }
                        }

                        sinhVienDiemThi.setSoLuongPhanHoi(soLuong);
                        lstSinhVienDiem.add(sinhVienDiemThi);
                        soLuong = 0;
                        continue;
                    }

                }

            }

        }

        lstHeSoDiem = giangVienThucTapController.GetHeSoDiem();
        if (lstHeSoDiem.size() == 0) {
            HeSoDiem diem = new HeSoDiem();
            diem.setHeSoBaoCaoQuaTrinh(0);
            diem.setHeSoCuoiKy(0);
            diem.setHeSoPhanHoi(0);
            diem.setHeSoQuaTrinh(0);
            lstHeSoDiem.add(diem);
            session.put("heSoDiem", "null");
        }
        session.put("GVTTSinhVienThucTapDiemThi", "GVTTSinhVienThucTapDiemThi");
        return SUCCESS;
    }

    public String GetAllDiemSinhVien() {
        List<SinhVien> lsSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<TinNhanEmail> lstTinNhanEmail = new ArrayList<>();
        List<SinhVienDiem> sinhVienDiems = new ArrayList<>();
        lsSinhVien = giangVienThucTapController.GetAllSinhVien();
        lstSinhVienThucTap = giangVienThucTapController.GetHoatDongTrangThaiSoLanThucTap();
        sinhVienDiems = giangVienThucTapController.GetAllDiemSinhVienOK();
        lstTinNhanEmail = giangVienThucTapController.GetAllEmailPhanHoi();

        for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
            for (int j = 0; j < lsSinhVien.size(); j++) {
                for (int k = 0; k < sinhVienDiems.size(); k++) {
                    if (lstSinhVienThucTap.get(i).getMssv() == lsSinhVien.get(j).getMssv()
                            && lsSinhVien.get(j).getMssv() == sinhVienDiems.get(k).getMssv()) {
                        SinhVienDiemThi sinhVienDiemThi = new SinhVienDiemThi();
                        sinhVienDiemThi.setMssv(lsSinhVien.get(j).getMssv());
                        sinhVienDiemThi.setLop(lsSinhVien.get(j).getLop());
                        sinhVienDiemThi.setHoTen(lsSinhVien.get(j).getHoTen());
                        sinhVienDiemThi.setDiemQuaTrinh(sinhVienDiems.get(k).getQuaTrinh());
                        sinhVienDiemThi.setDiemCuoiKy(sinhVienDiems.get(k).getCuoiKy());
                        sinhVienDiemThi.setDiemPhanHoi(sinhVienDiems.get(k).getDiemPhanHoi());
                        sinhVienDiemThi.setDiemBaoCaoQuaTrinh(sinhVienDiems.get(k).getDiemBaoCaoQuaTrinh());
                        lstSinhVienDiem.add(sinhVienDiemThi);
                        continue;
                    }

                }

            }

        }
        session.put("GVTTGetAllDiemThi", "GVTTGetAllDiemThi");
        return SUCCESS;
    }

    public String UpdateDiemThi() {
        String trangthai = (String) request.getParameter("trangThai");
        List<TinNhanEmail> lstTinNhanEmail = new ArrayList<>();
        List<HeSoDiem> lsHeSoDiem = new ArrayList<>();
        if (trangthai.equals("OK")) {
            SinhVienDiem diem = new SinhVienDiem();
            diem.setMssv(Integer.parseInt(request.getParameter("mssv")));
            giangVienThucTapController.updateDiemThi(diem, true);
        } else {
            lstTinNhanEmail = giangVienThucTapController.SoLuongPhanHoi(Integer.parseInt(request.getParameter("mssv")));
            lsHeSoDiem = giangVienThucTapController.GetHeSoDiem();
            int soLuong = lstTinNhanEmail.size();
            SinhVienDiem diem = new SinhVienDiem();
            diem.setMssv(Integer.parseInt(request.getParameter("mssv")));
            diem.setDiemBaoCaoQuaTrinh(Double.parseDouble(request.getParameter("diemQuaTrinh")));
            diem.setCuoiKy(Double.parseDouble(request.getParameter("diemCuoiKy")));
            diem.setDiemPhanHoi(soLuong * 1.67);
            diem.setQuaTrinh(soLuong * 1.67 * lsHeSoDiem.get(0).getHeSoPhanHoi()
                    + Double.parseDouble(request.getParameter("diemQuaTrinh")) * lsHeSoDiem.get(0).getHeSoBaoCaoQuaTrinh());
            giangVienThucTapController.updateDiemThi(diem, false);
        }
        return SUCCESS;
    }

    public String UploadFileSinhVien() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String link = null;
        SinhVienFile sinhVienFile = new SinhVienFile();
        try {
            path = request.getSession().getServletContext().getRealPath("/").concat("file/filegiangvien/");
            File fileToCreate = new File(path, this.myFileFileName);
            FileUtils.copyFile(this.myFile, fileToCreate);
            link = "file/filegiangvien/" + myFileFileName;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        sinhVienFile.setMssv(9999);
        sinhVienFile.setLoaiFile(7);
        sinhVienFile.setTenFile(tenFile);
        sinhVienFile.setLink(link);
        sinhVienFile.setNgayThang(sqlDate);
        if (giangVienThucTapController.UploadFile(sinhVienFile)) {
            GetAllFile();
            return SUCCESS;
        }
        return ERROR;
    }

    public String GetAllFile() {
        lstSinhVienFileBCCK = giangVienThucTapController.GetFileSinhVienBCCK();
        lstSinhVienFileBCQT = giangVienThucTapController.GetFileSinhVienBCQT();
        lstSinhVienFileCC = giangVienThucTapController.GetFileSinhVienCC();
        lstSinhVienFileDG = giangVienThucTapController.GetFileSinhVienDG();
        lstGiangVienFile = giangVienThucTapController.GetFileGiangVien();
        lstFileChiTiet = giangVienThucTapController.GetFileExcel();
        session.put("getAllFileGVTT", "getAllFileGVTT");
        return SUCCESS;
    }

    public String GetAllLichTrinh() {
        lstThongBaoLichTrinh = otherController.GetAllThongBao();
        session.put("GetAllLichTrinh", "GetAllLichTrinh");
        return SUCCESS;
    }

    public String DangLichTrinh() {
        ThongBao thongBao = new ThongBao();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        thongBao.setNguoiDang((String) session.get("email"));
        thongBao.setNoiDung(request.getParameter("noiDung"));
        thongBao.setTieuDe(request.getParameter("tieuDe"));
        thongBao.setThoiGian(sqlDate);
        giangVienThucTapController.SaveThongBaoLichTrinh(thongBao);
        return SUCCESS;
    }

    public String XuatFileExcel() {
        List<SinhVienvaThucTap> lstSinhVienvaThucTap = new ArrayList<>();
        List<SinhVien> lstSinhVien = new ArrayList<>();
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<SinhVienThucTap> lstCheckSinhVienThucTap = new ArrayList<>();
        List<DeTai> lstDeTai = new ArrayList<>();
        List<CongTy> lstCongTy = new ArrayList<>();
        List<SinhVienDiem> lstSinhVienDiem = new ArrayList<>();
        List<SinhVienFile> lstSinhVienFile = new ArrayList<>();
        List<XuatFileThongTinSinhVien> lstFile = new ArrayList<>();

        lstSinhVien = giangVienThucTapController.GetAllSinhVien();
        lstSinhVienThucTap = giangVienThucTapController.GetAllSinhVienThucTap();
        lstCheckSinhVienThucTap = giangVienThucTapController.CheckSoLanThucTap();
        lstDeTai = giangVienThucTapController.GetAllDeTaiDongY();
        lstCongTy = giangVienThucTapController.GetAllCongTy();
        lstSinhVienFile = giangVienThucTapController.GetAllFileSinhVien();
        lstSinhVienDiem = giangVienThucTapController.GetAllDiemSinhVienOK();
        for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
            for (int j = 0; j < lstSinhVien.size(); j++) {
                if (lstSinhVienThucTap.get(i).getMssv() == lstSinhVien.get(j).getMssv()) {
                    SinhVienvaThucTap sinhVienvaThucTap = new SinhVienvaThucTap();
                    sinhVienvaThucTap.setMssv(lstSinhVien.get(j).getMssv());
                    sinhVienvaThucTap.setDiaChi(lstSinhVien.get(j).getDiaChi());
                    sinhVienvaThucTap.setDienThoai(lstSinhVien.get(j).getDienThoai());
                    sinhVienvaThucTap.setEmail(lstSinhVien.get(j).getEmail());
                    sinhVienvaThucTap.setHoTen(lstSinhVien.get(j).getHoTen());
                    sinhVienvaThucTap.setLop(lstSinhVien.get(j).getLop());
                    sinhVienvaThucTap.setKhoa(lstSinhVien.get(j).getKhoa());
                    sinhVienvaThucTap.setVienKhoa(lstSinhVien.get(j).getVienKhoa());
                    sinhVienvaThucTap.setNgaySinh(lstSinhVien.get(j).getNgaySinh());
                    sinhVienvaThucTap.setLapTop(lstSinhVien.get(j).getLapTop());
                    sinhVienvaThucTap.setTrangThai(true);
                    sinhVienvaThucTap.setMaCongTy(lstSinhVienThucTap.get(i).getMaCongTy());
                    sinhVienvaThucTap.setMaDeTai(lstSinhVienThucTap.get(i).getMaDeTai());
                    sinhVienvaThucTap.setSoKhop(lstSinhVienThucTap.get(i).getSoKhop());
                    sinhVienvaThucTap.setThoiGianBatDau(lstSinhVienThucTap.get(i).getThoiGianBatDau());
                    sinhVienvaThucTap.setThoiGianKetThuc(lstSinhVienThucTap.get(i).getThoiGianKetThuc());
                    int x = 0;
                    for (int k = 0; k < lstCheckSinhVienThucTap.size(); k++) {
                        if (lstCheckSinhVienThucTap.get(k).getSoLanThucTap() == true) {
                            x++;
                        }
                    }
                    sinhVienvaThucTap.setSoLanThucTap(x);
                    lstSinhVienvaThucTap.add(sinhVienvaThucTap);
                    break;
                }
            }
        }

        for (int i = 0; i < lstSinhVienvaThucTap.size(); i++) {
            XuatFileThongTinSinhVien xuatFile = new XuatFileThongTinSinhVien();
            xuatFile.setMssv(lstSinhVienvaThucTap.get(i).getMssv());
            xuatFile.setDiaChi(lstSinhVienvaThucTap.get(i).getDiaChi());
            xuatFile.setDienThoai(lstSinhVienvaThucTap.get(i).getDienThoai());
            xuatFile.setEmail(lstSinhVienvaThucTap.get(i).getEmail());
            xuatFile.setHoTen(lstSinhVienvaThucTap.get(i).getHoTen());
            xuatFile.setLop(lstSinhVienvaThucTap.get(i).getLop());
            xuatFile.setKhoa(lstSinhVienvaThucTap.get(i).getKhoa());
            xuatFile.setVienKhoa(lstSinhVienvaThucTap.get(i).getVienKhoa());
            xuatFile.setThoiGianBatDau(lstSinhVienvaThucTap.get(i).getThoiGianBatDau());
            xuatFile.setThoiGianKetThuc(lstSinhVienvaThucTap.get(i).getThoiGianKetThuc());
            xuatFile.setLapTop(lstSinhVienvaThucTap.get(i).getLapTop());
            xuatFile.setNgaySinh(lstSinhVienvaThucTap.get(i).getNgaySinh());
            xuatFile.setDiaChi(lstSinhVienvaThucTap.get(i).getDiaChi());
            xuatFile.setSoKhop(lstSinhVienvaThucTap.get(i).getSoKhop());
            xuatFile.setSoLanThucTap(lstSinhVienvaThucTap.get(i).getSoLanThucTap());
            for (int j = 0; j < lstCongTy.size(); j++) {
                if (lstSinhVienvaThucTap.get(i).getMaCongTy() == lstCongTy.get(j).getMsct()) {
                    xuatFile.setTenCongTy(lstCongTy.get(j).getTenCongTy());
                    break;
                }
            }
            for (int k = 0; k < lstDeTai.size(); k++) {
                if (lstSinhVienvaThucTap.get(i).getMaDeTai() == lstDeTai.get(k).getId()) {
                    xuatFile.setTenDeTai(lstDeTai.get(k).getTenDeTai());
                    break;
                }
            }
            for (int l = 0; l < lstSinhVienDiem.size(); l++) {
                if (lstSinhVienDiem.get(l).getMssv() == lstSinhVienvaThucTap.get(i).getMssv()) {
                    if (lstSinhVienDiem.get(l).getDiemPhanHoi() == null) {
                        xuatFile.setDiemPhanHoi(0);
                    } else {
                        xuatFile.setDiemPhanHoi(lstSinhVienDiem.get(l).getDiemPhanHoi());
                    }
                    if (lstSinhVienDiem.get(l).getDiemBaoCaoQuaTrinh() == null) {
                        xuatFile.setDiemBaoCaoQT(0);
                    } else {
                        xuatFile.setDiemBaoCaoQT(lstSinhVienDiem.get(l).getDiemBaoCaoQuaTrinh());
                    }
                    if (lstSinhVienDiem.get(l).getQuaTrinh() == null) {
                        xuatFile.setDiemQT(0);
                    } else {
                        xuatFile.setDiemQT(lstSinhVienDiem.get(l).getDiemPhanHoi());
                    }
                    if (lstSinhVienDiem.get(l).getCuoiKy() == null) {
                        xuatFile.setDiemCuoiKy(0);
                    } else {
                        xuatFile.setDiemCuoiKy(lstSinhVienDiem.get(l).getCuoiKy());
                    }
                    break;
                }

            }
            boolean checkBCCK = false;
            boolean checkBCQT = false;
            boolean checkCC = false;
            boolean checkDG = false;
            for (int n = 0; n < lstSinhVienFile.size(); n++) {
                if (lstSinhVienFile.get(n).getMssv() == lstSinhVienvaThucTap.get(i).getMssv() && lstSinhVienFile.get(n).getLoaiFile() == 1) {
                    xuatFile.setBaoCaoCuoiKy("Có");
                    checkBCCK = true;
                }
                if (lstSinhVienFile.get(n).getMssv() == lstSinhVienvaThucTap.get(i).getMssv() && lstSinhVienFile.get(n).getLoaiFile() == 2) {
                    xuatFile.setBaoCaoQuaTrinh("Có");
                    checkBCQT = true;
                }
                if (lstSinhVienFile.get(n).getMssv() == lstSinhVienvaThucTap.get(i).getMssv() && lstSinhVienFile.get(n).getLoaiFile() == 3) {
                    xuatFile.setChamCong("Có");
                    checkCC = true;
                }
                if (lstSinhVienFile.get(n).getMssv() == lstSinhVienvaThucTap.get(i).getMssv() && lstSinhVienFile.get(n).getLoaiFile() == 4) {
                    xuatFile.setDanhGia("Có");
                    checkDG = true;
                }
            }
            if (checkBCCK = false) {
                xuatFile.setBaoCaoCuoiKy("Không");
            }
            if (checkBCQT = false) {
                xuatFile.setBaoCaoQuaTrinh("Không");
            }
            if (checkCC = false) {
                xuatFile.setChamCong("Không");
            }
            if (checkDG = false) {
                xuatFile.setDanhGia("Không");
            }
            lstFile.add(xuatFile);
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sinh Viên Thực Tập");
        HashMap<String, Object[]> data = new HashMap<>();
        data.put("1", new Object[]{"MSSV", "Họ tên", "Lớp", "Khoa/Viện", "Email", "Điện thoại", "Ngày Sinh", "Địa chỉ", "Laptop",
            "Thực Tập", "Số lần thực tập", "So khớp", "Tên công ty",
            "Tên đề tài", "BCQT", "BCCK", "Chấm Công", "Đánh Giá", "Điểm phản hồi", "Điểm BCQT", "Điểm QT", "Điểm CK"});
//        data.put("2", new Object[]{1, 17030001, "Trương Tùng Dương", "20/10/1990"});
        for (int i = 0; i < lstFile.size(); i++) {
            data.put("" + (i + 2) + "", new Object[]{"" + lstFile.get(i).getMssv() + "", "" + lstFile.get(i).getHoTen() + "",
                "" + lstFile.get(i).getLop() + "", "" + lstFile.get(i).getVienKhoa() + "", "" + lstFile.get(i).getEmail() + "",
                "" + lstFile.get(i).getDienThoai() + "", "" + lstFile.get(i).getNgaySinh() + "", "" + lstFile.get(i).getDiaChi() + "",
                "" + lstFile.get(i).getLapTop() + "", "" + lstFile.get(i).getTrangThai() + "", "" + lstFile.get(i).getSoLanThucTap() + "",
                "" + lstFile.get(i).getSoKhop() + "", "" + lstFile.get(i).getTenCongTy() + "",
                "" + lstFile.get(i).getTenDeTai() + "", "" + lstFile.get(i).getBaoCaoQuaTrinh() + "", "" + lstFile.get(i).getBaoCaoCuoiKy() + "",
                "" + lstFile.get(i).getChamCong() + "", "" + lstFile.get(i).getDanhGia() + "", "" + lstFile.get(i).getDiemPhanHoi() + "",
                "" + lstFile.get(i).getDiemBaoCaoQT() + "", "" + lstFile.get(i).getDiemQT() + "", "" + lstFile.get(i).getDiemCuoiKy() + ""});
            continue;
        }
        int rownum = 0;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            for (Object obj : entry.getValue()) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else {
                    if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }
        }
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            path = request.getSession().getServletContext().getRealPath("/").concat("file/filegiangvien/");
            String file = "SinhVien-" + sqlDate + ".xlsx";
            FileOutputStream out = new FileOutputStream(new File(path + file));
            workbook.write(out);
            out.close();
            SinhVienFile sinhVienFile = new SinhVienFile();
            sinhVienFile.setMssv(9999);
            sinhVienFile.setLoaiFile(8);
            sinhVienFile.setTenFile(file);
            sinhVienFile.setLink("file/filegiangvien/" + file + "");
            sinhVienFile.setNgayThang(sqlDate);
            if (giangVienThucTapController.UploadFile(sinhVienFile)) {
                GetAllFile();
            }
            System.out.println(path+file);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
