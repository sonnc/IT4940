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
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author sonnguyen
 */
public class SinhvienAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Object> session;
    private SinhvienController sinhvienController;
    private SinhVien sinhVien;
    private SinhVienMucTieu sinhVienMucTieu;
    private SinhVienKnvaLt sinhVienKnvaLt;
    private File myFile;
    private String myFileFileName;
    private String path;
    private String loaiFile;
    private String tenFile;
    private List<SinhVienDiem> lstSinhVienDiem = new ArrayList<>();
    private List<SinhVienThucTap> lstSinhVienTT = new ArrayList<>();
    private List<DeTai> lstDeTaiSV = new ArrayList<>();
    private List<CongTy> lstCongTySV = new ArrayList<>();
    private List<DeTai> lstDeTai = new ArrayList<>();
    private List<CongTy> lstCongTy = new ArrayList<>();
    private List<DaiDienCongTy> lstDaiDienCongTy = new ArrayList<>();
    private List<GiangVienHuongDan> lstGiangVienHuongDan = new ArrayList<>();
    private List<CongTyDeTai> lstCTDT = new ArrayList<>();
    private List<CongTyDeTai> lstDanhSachDeTaiDK = new ArrayList<>();
    private List<SinhVien> lstSinhVien = new ArrayList<>();
    private List<SinhVienFile> lstSinhVienFile = new ArrayList<>();
    private SinhVienFile sinhVienFile = new SinhVienFile();
    private List<SinhVienKnvaLt> lstKNLT = new ArrayList<>();
    private List<SinhVienMucTieu> lstMucTieu = new ArrayList<>();
    private GvttController giangVienThucTapController;

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

    public List<CongTyDeTai> getLstDanhSachDeTaiDK() {
        return lstDanhSachDeTaiDK;
    }

    public void setLstDanhSachDeTaiDK(List<CongTyDeTai> lstDanhSachDeTaiDK) {
        this.lstDanhSachDeTaiDK = lstDanhSachDeTaiDK;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public String getLoaiFile() {
        return loaiFile;
    }

    public void setLoaiFile(String loaiFile) {
        this.loaiFile = loaiFile;
    }

    public SinhVienFile getSinhVienFile() {
        return sinhVienFile;
    }

    public void setSinhVienFile(SinhVienFile sinhVienFile) {
        this.sinhVienFile = sinhVienFile;
    }

    public List<SinhVienFile> getLstSinhVienFile() {
        return lstSinhVienFile;
    }

    public void setLstSinhVienFile(List<SinhVienFile> lstSinhVienFile) {
        this.lstSinhVienFile = lstSinhVienFile;
    }

    public List<SinhVien> getLstSinhVien() {
        return lstSinhVien;
    }

    public void setLstSinhVien(List<SinhVien> lstSinhVien) {
        this.lstSinhVien = lstSinhVien;
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

    public List<CongTyDeTai> getLstCTDT() {
        return lstCTDT;
    }

    public void setLstCTDT(List<CongTyDeTai> lstCTDT) {
        this.lstCTDT = lstCTDT;
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

    public List<DeTai> getLstDeTaiSV() {
        return lstDeTaiSV;
    }

    public void setLstDeTaiSV(List<DeTai> lstDeTaiSV) {
        this.lstDeTaiSV = lstDeTaiSV;
    }

    public List<CongTy> getLstCongTySV() {
        return lstCongTySV;
    }

    public void setLstCongTySV(List<CongTy> lstCongTySV) {
        this.lstCongTySV = lstCongTySV;
    }

    public List<SinhVienThucTap> getLstSinhVienTT() {
        return lstSinhVienTT;
    }

    public void setLstSinhVienTT(List<SinhVienThucTap> lstSinhVienTT) {
        this.lstSinhVienTT = lstSinhVienTT;
    }

    public List<SinhVienDiem> getLstSinhVienDiem() {
        return lstSinhVienDiem;
    }

    public void setLstSinhVienDiem(List<SinhVienDiem> lstSinhVienDiem) {
        this.lstSinhVienDiem = lstSinhVienDiem;
    }

    public SinhVienKnvaLt getSinhVienKnvaLt() {
        return sinhVienKnvaLt;
    }

    public void setSinhVienKnvaLt(SinhVienKnvaLt sinhVienKnvaLt) {
        this.sinhVienKnvaLt = sinhVienKnvaLt;
    }

    public SinhVienMucTieu getSinhVienMucTieu() {
        return sinhVienMucTieu;
    }

    public void setSinhVienMucTieu(SinhVienMucTieu sinhVienMucTieu) {
        this.sinhVienMucTieu = sinhVienMucTieu;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public SinhvienAction() {
        sinhvienController = new SinhvienController();
        giangVienThucTapController = new GvttController();
    }

//    public void validate() {
//        if (sinhVien.getHoTen() == null) {
//            addFieldError("sinhVien.hoTen", "Họ tên không được để trống !");
//        }
//        if (sinhVien.getLapTop() != true || sinhVien.getLapTop() != false) {
//            addFieldError("sinhVien.lapTop", "Giá trị phải là: CÓ / KHÔNG !");
//        }
//        if (sinhVien.getDiaChi() == null) {
//            addFieldError("sinhVien.diaChi", "Địa chỉ không được để trống !");
//        }
//
//        if (sinhVien.getDienThoai() >= 0) {
//            String dt = String.valueOf(sinhVien.getDienThoai());
//            if (dt.length() < 9) {
//                addFieldError("sinhVien.dienThoai", "Điện thoại không được nhỏ hơn 9 số !");
//            }
//            if (dt.length() > 13) {
//                addFieldError("sinhVien.dienThoai", "Điện thoại không được lớn hơn 13 số !");
//            }
//        }
//        if (sinhVien.getLop() == null) {
//            addFieldError("sinhVien.lop", "Lớp học không được để trống !");
//        }
//        if (sinhVien.getNgaySinh() == null) {
//            addFieldError("sinhVien.ngaySinh", "Ngày sinh không được để trống !");
//        }
//        if (sinhVien.getNgaySinh() != null) {
//            String date = request.getParameter("ngaySinh");
//            for (int i = 0; i < date.length(); i++) {
//                if (Character.isAlphabetic(0)
//                        || Character.isAlphabetic(1)
//                        || Character.isAlphabetic(3)
//                        || Character.isAlphabetic(4)
//                        || Character.isAlphabetic(6)
//                        || Character.isAlphabetic(7)
//                        || Character.isAlphabetic(8)
//                        || Character.isAlphabetic(9)) {
//                    addFieldError("sinhVien.ngaySinh", "Ngày tháng năm không thể là chữ ký tự");
//                }
//            }
//            int d = Integer.parseInt(date.substring(0, 2));
//            int m = Integer.parseInt(date.substring(3, 5));
//            int y = Integer.parseInt(date.substring(6, 9));
//            Date d1 = new Date();
//            int checkYear = d1.getYear() - y;
//            if (d < 1 || d > 31 || m < 1 || m > 12 || checkYear < 18) {
//                if (y % m == 0) {
//                    if (d > 29) {
//
//                    }
//                } else {
//                }
//            } else {
//                addFieldError("sinhVien.ngaySinh", "Ngày tháng năm không hợp lệ.");
//            }
//        }
//
//        if (sinhVien.getDiaChi() == null) {
//            addFieldError("sinhVien.diaChi", "Địa chỉ không được để trống !");
//        }
//
//    }
    public String GetInfoSinhVien() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        try {
            lstSinhVien = sinhvienController.GetInfoSinhVien((int) session.get("mssv"));
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public String SaveInfoSinhVien() {
        try {
            String date = request.getParameter("ngaySinh");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date dateString = sdf.parse(date);
            java.sql.Date ngaySinh = new java.sql.Date(dateString.getTime());
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
            sinhVien.setAvatar(avatar);
            sinhVien.setNgaySinh(ngaySinh);
            sinhVien.setMssv((int) session.get("mssv"));
            sinhVien.setEmail((String) session.get("email"));
            sinhVienKnvaLt.setMssv((int) session.get("mssv"));
            sinhVienMucTieu.setMssv((int) session.get("mssv"));
            if (sinhvienController.SaveInfoSinhVien(sinhVien, sinhVienKnvaLt, sinhVienMucTieu)) {
                lstSinhVien = sinhvienController.GetInfoSinhVien((int) session.get("mssv"));
                session.put("lstSinhvien", lstSinhVien);
                response.sendRedirect("home.jsp");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public String GetDiemThi() {
        session.put("CheckDiem", "CheckDiem");
        try {
            lstSinhVienDiem = sinhvienController.GetDiemSinhVien((int) session.get("mssv"));
            if (lstSinhVienDiem.size() == 0) {
                session.put("sinhVienDiem", "no");
            } else if (lstSinhVienDiem.size() == 1) {
                if (lstSinhVienDiem.get(0).getTrangThai() == false) {
                    session.put("sinhVienDiem", "yesFalse");
                } else {
                    if ((lstSinhVienDiem.get(0).getQuaTrinh() * 0.3 + lstSinhVienDiem.get(0).getCuoiKy() * 0.7) < 4
                            || lstSinhVienDiem.get(0).getQuaTrinh() < 3
                            || lstSinhVienDiem.get(0).getCuoiKy() < 3) {
                        session.put("ThucTapFalse", "ThucTapFalse");
                    }
                    session.put("sinhVienDiem", "yesTrue");
                }
                lstSinhVienTT = sinhvienController.GetThucTapSinhVien((int) session.get("mssv"));
                lstDeTaiSV = sinhvienController.GetDeTaiSVTT(lstSinhVienTT.get(0).getMaDeTai());
                lstCongTySV = sinhvienController.GetCongTySVTT(lstSinhVienTT.get(0).getMaCongTy());
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public String GetAllCongTy() {
        lstCongTySV = sinhvienController.GetAllCongTy();
        session.put("DSCongTy", "DSCongTy");
        return SUCCESS;
    }

    public String GetChiTietCongTy() {
        int ms = Integer.parseInt(request.getParameter("maCongTy"));
        lstCongTy = sinhvienController.GetChiTietCongTy(ms);
        lstDeTai = sinhvienController.GetDeTai(ms);
        lstDaiDienCongTy = sinhvienController.GetDaiDienCongTy(ms);
        lstGiangVienHuongDan = sinhvienController.GetAllGVHDofACongTy(ms);
        session.put("CTCongTy", "CTCongTy");
        return SUCCESS;
    }

    public String GetAllDeTai() {
        lstDeTai = sinhvienController.GetAllDeTai();
        lstCongTy = sinhvienController.GetAllCongTy();
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
        lstSinhVienTT = sinhvienController.GetThucTapSinhVien((int) session.get("mssv"));
        if (lstSinhVienTT.size() == 0) {
            session.put("SoDeTaiDK", "no");
        } else {
            int a = 0;
            for (int i = 0; i < lstSinhVienTT.size(); i++) {
                if (lstSinhVienTT.get(i).getTrangThai() == 1) {
                    session.put("DeTaiSUCCESS", "DeTaiSUCCESS");
                    break;
                }

            }
            for (int i = 0; i < lstSinhVienTT.size(); i++) {
                if (lstSinhVienTT.get(i).getHoatDong() == true) {
                    a++;
                }
            }

            session.put("SoDeTaiDK", a);
        }
        session.put("DeTai", "DeTai");
        return SUCCESS;
    }

    public String GetChiTietDeTai() {
        int maDeTai = Integer.parseInt(request.getParameter("maDeTai"));
        lstDeTai = sinhvienController.GetDeTaibyID(maDeTai);
        lstCongTy = sinhvienController.GetCongTySVTT(lstDeTai.get(0).getMaCongTy());
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

    public String DangKyDeTai() {
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        List<SinhVienKnvaLt> lstSinhVienKnvaLt = new ArrayList<>();
        List<SoKhop> lstKhopDT = new ArrayList<>();
        List<SoKhop> lstKhopSV = new ArrayList<>();
        int mdt = Integer.parseInt(request.getParameter("maDeTai"));
        lstDeTai = sinhvienController.GetDeTaibyID(mdt);
        lstSinhVienKnvaLt = sinhvienController.GetKNLTSinhVien((int) session.get("mssv"));
        // sokhop
        double phanTram = 0;
        String yeuCauDeTai = lstDeTai.get(0).getYeuCau();
        String yeuCauSinhVien = lstSinhVienKnvaLt.get(0).getLapTrinh();
        // cắt bỏ khoảng trống
        yeuCauDeTai = yeuCauDeTai.replaceAll(" ", "");
        yeuCauSinhVien = yeuCauSinhVien.replaceAll(" ", "");
        // cắt chuỗi
        int start1 = 0;
        int start2 = 0;
        ArrayList<SoKhop> arrSoKhopDT = new ArrayList<>();
        ArrayList<SoKhop> arrSoKhopSV = new ArrayList<>();
        SoKhop soKhop = null;
        int count = 0;
        for (int i = 0; i < yeuCauDeTai.length(); i++) {

            if (yeuCauDeTai.charAt(i) == '[') {
                start1 = i + 1;
                soKhop = new SoKhop();
            }
            if (yeuCauDeTai.charAt(i) == '-') {
                String x = yeuCauDeTai.substring(start1, i);
                soKhop.setLaptrinh(x);
                start2 = i + 1;
            }
            if (yeuCauDeTai.charAt(i) == ']') {
                String x = yeuCauDeTai.substring(start2, i);
                double giaTri = 0;
                if (x.equalsIgnoreCase("TT")) {
                    giaTri = 100;
                } else if (x.equalsIgnoreCase("RT")) {
                    giaTri = 75;
                } else if (x.equalsIgnoreCase("KT")) {
                    giaTri = 50;
                } else if (x.equalsIgnoreCase("DT")) {
                    giaTri = 25;
                } else if (x.equalsIgnoreCase("KB")) {
                    giaTri = 0;
                }
                soKhop.setDanhGia(giaTri);
                arrSoKhopDT.add(soKhop);
            }

        }
        for (int i = 0; i < yeuCauSinhVien.length(); i++) {

            if (yeuCauSinhVien.charAt(i) == '[') {
                start1 = i + 1;
                soKhop = new SoKhop();
            }
            if (yeuCauSinhVien.charAt(i) == '-') {
                String x = yeuCauSinhVien.substring(start1, i);
                soKhop.setLaptrinh(x);
                start2 = i + 1;
            }
            if (yeuCauSinhVien.charAt(i) == ']') {
                String x = yeuCauSinhVien.substring(start2, i);
                double giaTri = 0;
                if (x.equalsIgnoreCase("TT")) {
                    giaTri = 100;
                } else if (x.equalsIgnoreCase("RT")) {
                    giaTri = 75;
                } else if (x.equalsIgnoreCase("KT")) {
                    giaTri = 50;
                } else if (x.equalsIgnoreCase("DT")) {
                    giaTri = 25;
                } else if (x.equalsIgnoreCase("KB")) {
                    giaTri = 0;
                }
                soKhop.setDanhGia(giaTri);
                arrSoKhopSV.add(soKhop);
            }
        }

        double tySoSoKhop = 0;
        for (int i = 0; i < arrSoKhopDT.size(); i++) {
            for (int j = 0; j < arrSoKhopSV.size(); j++) {
                if (arrSoKhopDT.get(i).getLaptrinh().equalsIgnoreCase(arrSoKhopSV.get(j).getLaptrinh())) {
                    tySoSoKhop = tySoSoKhop + arrSoKhopSV.get(j).getDanhGia() / arrSoKhopDT.get(i).getDanhGia();
                }

            }
        }
        if (arrSoKhopDT.size() == 0) {
            phanTram = 0;
        } else {
            phanTram = 100 * (tySoSoKhop / arrSoKhopDT.size());
        }
        lstSinhVienThucTap = sinhvienController.GetThucTapSinhVien((int) session.get("mssv"));
        int dem = 0;
        for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
            if (lstSinhVienThucTap.get(i).getHoatDong() == true) {
                dem++;
            }
        }
        if (dem < 3) {
            if (lstSinhVienThucTap.size() == 0) {
                int maGVDH = sinhvienController.GetMaGVHDfromDeTai(mdt);
                SinhVienThucTap sinhVienThucTap = new SinhVienThucTap();
                sinhVienThucTap.setMssv((int) session.get("mssv"));
                sinhVienThucTap.setMaDeTai(mdt);
                sinhVienThucTap.setNguoiHuongDan(maGVDH);
                sinhVienThucTap.setMaCongTy(lstDeTai.get(0).getMaCongTy());
                if (phanTram >= 85) {
                    sinhVienThucTap.setTrangThai(1);
                    sinhVienThucTap.setSoLanThucTap(true);
                } else {
                    sinhVienThucTap.setTrangThai(0);
                    sinhVienThucTap.setSoLanThucTap(false);
                }
                sinhVienThucTap.setSoKhop(phanTram);
                sinhVienThucTap.setHoatDong(true);
                // thời gian bắt đầu 
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());

                sinhVienThucTap.setThoiGianBatDau(sqlDate1);

                Calendar now = Calendar.getInstance();
                now.add(Calendar.DATE, 90);
                Date date = now.getTime();
                java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());

                sinhVienThucTap.setThoiGianKetThuc(sqlDate2);

                if (sinhvienController.SaveThucTapSinhVien(sinhVienThucTap)) {
                    GetAllDeTai();
                    session.put("DeTai", "DeTai");
                    return SUCCESS;
                }
            } else {
                boolean check = false;
                for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
                    if (lstSinhVienThucTap.get(i).getMaDeTai() == mdt && lstSinhVienThucTap.get(i).getHoatDong() == true) {
                        check = true;
                    }
                }
                if (check) {
                    GetAllDeTai();
                    session.put("TrungDeTai", "trungdetaidk");
                    session.put("DeTai", "DeTai");
                    return SUCCESS;
                } else {
                    boolean checkDTSV = false;
                    for (int i = 0; i < lstSinhVienThucTap.size(); i++) {
                        if (lstSinhVienThucTap.get(i).getTrangThai() == 1) {
                            checkDTSV = true;
                            break;
                        }
                    }
                    if (checkDTSV) {
                        GetAllDeTai();
                        session.put("DeTaiSUCCESS", "DeTaiSUCCESS");
                        session.put("DeTai", "DeTai");
                        return SUCCESS;
                    } else {
                        int maGVDH = sinhvienController.GetMaGVHDfromDeTai(mdt);
                        SinhVienThucTap sinhVienThucTap = new SinhVienThucTap();
                        sinhVienThucTap.setMssv((int) session.get("mssv"));
                        sinhVienThucTap.setMaDeTai(mdt);
                        sinhVienThucTap.setNguoiHuongDan(maGVDH);
                        sinhVienThucTap.setMaCongTy(lstDeTai.get(0).getMaCongTy());
                        if (phanTram >= 80) {
                            sinhVienThucTap.setTrangThai(1);
                            sinhVienThucTap.setSoLanThucTap(true);
                        } else {
                            sinhVienThucTap.setTrangThai(0);
                            sinhVienThucTap.setSoLanThucTap(false);
                        }
                        sinhVienThucTap.setSoKhop(phanTram);
                        sinhVienThucTap.setHoatDong(true);

                        // thời gian bắt đầu 
                        java.util.Date utilDate = new java.util.Date();
                        java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());

                        sinhVienThucTap.setThoiGianBatDau(sqlDate1);

                        Calendar now = Calendar.getInstance();
                        now.add(Calendar.DATE, 90);
                        Date date = now.getTime();
                        java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());

                        sinhVienThucTap.setThoiGianKetThuc(sqlDate2);
                        if (sinhvienController.SaveThucTapSinhVien(sinhVienThucTap)) {
                            GetAllDeTai();
                            session.put("DeTai", "DeTai");
                            return SUCCESS;
                        }
                    }

                }
            }
        } else {
            GetAllDeTai();
            session.put("QuaSoLuongDKDT", "4");
            session.put("DeTai", "DeTai");
            return SUCCESS;
        }
        return ERROR;
    }

    public String GetSoLuongDeTaiDKofSV() {
        int x = sinhvienController.GetSoLuongDeTaiDKofSV((int) session.get("mssv"));
        return SUCCESS;
        // tạo một trang hiển thị danh sách đề tài đăng ký của sinhv viên
    }

    public String GetFileSinhVien() {
        lstSinhVienFile = sinhvienController.GetFileSinhVien((int) session.get("mssv"));
        if (lstSinhVienFile.size() == 0) {
            session.put("FileSinhVienNULL", "FileSinhVien");
        }
        session.put("FileSinhVien", "FileSinhVien");
        return SUCCESS;
    }

    public String UploadFileSinhVien() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String link = null;
        SinhVienFile sinhVienFile = new SinhVienFile();
        int tp = Integer.parseInt(request.getParameter("loaiFile"));
        try {
            path = request.getSession().getServletContext().getRealPath("/").concat("file/sinhvien/");
            File fileToCreate = new File(path, this.myFileFileName);
            FileUtils.copyFile(this.myFile, fileToCreate);
            link = "file/sinhvien/" + myFileFileName;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        sinhVienFile.setMssv((int) session.get("mssv"));
        sinhVienFile.setLoaiFile(tp);
        sinhVienFile.setTenFile(tenFile);
        sinhVienFile.setLink(link);
        sinhVienFile.setNgayThang(sqlDate);
        if (sinhvienController.UploadFileSinhVien(sinhVienFile)) {
            GetFileSinhVien();
            return SUCCESS;
        }
        return ERROR;
    }

    public String GetAllDeTaiSVDK() {
        int mssv = (int) session.get("mssv");
        List<SinhVienThucTap> lstSinhVienThucTaps = new ArrayList<>();
        lstSinhVienThucTaps = sinhvienController.DanhSachDeTaiSVDK(mssv);
        lstDeTai = sinhvienController.GetAllDeTai();
        lstCongTy = sinhvienController.GetAllCongTy();
        for (int i = 0; i < lstCongTy.size(); i++) {
            for (int j = 0; j < lstDeTai.size(); j++) {
                for (int k = 0; k < lstSinhVienThucTaps.size(); k++) {
                    if (lstCongTy.get(i).getMsct() == lstDeTai.get(j).getMaCongTy() && lstDeTai.get(i).getId() == lstSinhVienThucTaps.get(k).getMaDeTai()) {
                        CongTyDeTai congTyDeTai = new CongTyDeTai();
                        congTyDeTai.setTenCongTy(lstCongTy.get(i).getTenCongTy());
                        congTyDeTai.setAvatar(lstCongTy.get(i).getAvatar());
                        congTyDeTai.setMsct(lstCongTy.get(i).getMsct());
                        congTyDeTai.setId(lstDeTai.get(j).getId()); // mã đề tài
                        congTyDeTai.setTenDeTai(lstDeTai.get(j).getTenDeTai());
                        congTyDeTai.setNoiDung(lstDeTai.get(j).getNoiDung());
                        congTyDeTai.setYeuCau(lstDeTai.get(j).getYeuCau());
                        congTyDeTai.setSoLuong(lstDeTai.get(j).getSoLuong());
                        lstDanhSachDeTaiDK.add(congTyDeTai);
                    }
                }

            }
        }

        session.put("DeTai", "DeTai");
        return SUCCESS;
    }

    public String GetCVSinhVienSV() {
        int x = (int) session.get("mssv");
        lstSinhVien = giangVienThucTapController.GetInfoSinhVien(x);
        lstKNLT = giangVienThucTapController.GetKNLTSinhVien(x);
        lstMucTieu = giangVienThucTapController.GetMucTieuSV(x);
        session.put("GetCVSinhVienSV", "GetCVSinhVienSV");
        return SUCCESS;
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
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        this.response = hsr;
    }
}
