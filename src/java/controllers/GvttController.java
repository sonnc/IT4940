/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.CongTy;
import entities.DaiDienCongTy;
import entities.DeTai;
import entities.GiangVien;
import entities.GiangVienChiTiet;
import entities.HeSoDiem;
import entities.SinhVien;
import entities.SinhVienDiem;
import entities.SinhVienFile;
import entities.SinhVienKnvaLt;
import entities.SinhVienMucTieu;
import entities.SinhVienThucTap;
import entities.ThongBao;
import entities.TinNhanEmail;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sonnguyen
 */
public class GvttController {

    Session session;
    Transaction transaction;

    public GvttController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List GetInfoGiangVien(String email) {
        List<GiangVien> lsGiangVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM GiangVien WHERE Email =:email");
            q.setParameter("email", email);
            lsGiangVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lsGiangVien;

    }

    public boolean SaveInfoGiangVien(GiangVien giangVien) {
        try {
            transaction = session.beginTransaction();
            session.save(giangVien);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean SaveInfoGiangVienChiTiet(GiangVienChiTiet giangVien) {
        try {
            transaction = session.beginTransaction();
            session.save(giangVien);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List GetAllDeTai() {
        List<DeTai> lst = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai WHERE TrangThai = 0");
            lst = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lst;
    }

    public List GetAllDeTaiCHECK() {
        List<DeTai> lst = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai");
            lst = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lst;
    }

    public List GetAllDeTaiDongY() {
        List<DeTai> lst = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai WHERE TrangThai = 1");
            lst = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lst;
    }

    public List GetAllDeTaiTuChoi() {
        List<DeTai> lst = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai WHERE TrangThai = 2");
            lst = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lst;
    }

    public List GetAllCongTy() {
        List<DeTai> lst = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM CongTy");
            lst = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lst;
    }

    public List GetDeTaibyID(int id) {
        List<DeTai> lstDeTai = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai WHERE ID =:id");
            q.setParameter("id", id);
            lstDeTai = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstDeTai;
    }

    public List GetCongTyByID(int msct) {
        List<CongTy> lstCongTy = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM CongTy WHERE Msct =:msct");
            q.setParameter("msct", msct);
            lstCongTy = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lstCongTy;
    }

    public boolean DongYDeTai(int id) {

        try {
            transaction = session.beginTransaction();
            DeTai deTai = (DeTai) session.get(DeTai.class, id);
            deTai.setTrangThai(1);
            session.update(deTai);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    public boolean TuChoiDeTai(int id) {

        try {
            transaction = session.beginTransaction();
            DeTai deTai = (DeTai) session.get(DeTai.class, id);
            deTai.setTrangThai(2);
            session.update(deTai);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    public List GetChiTietCongTy(int msct) {
        List<CongTy> lstCongTy = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM CongTy WHERE Msct =:msct");
            q.setParameter("msct", msct);
            lstCongTy = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstCongTy;
    }

    public List GetDeTai(int msct) {
        List<CongTy> lstCongTy = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai WHERE MaCongTy =:msct");
            q.setParameter("msct", msct);
            lstCongTy = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstCongTy;
    }

    public List GetDaiDienCongTy(int msct) {
        List<DaiDienCongTy> lsDaiDienCongTy = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DaiDienCongTy WHERE MaCongTy =:msct");
            q.setParameter("msct", msct);
            lsDaiDienCongTy = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lsDaiDienCongTy;
    }

    public List GetAllGVHDofACongTy(int msct) {
        List<DaiDienCongTy> lsDaiDienCongTy = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM GiangVienHuongDan WHERE Msct =:msct");
            q.setParameter("msct", msct);
            lsDaiDienCongTy = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lsDaiDienCongTy;
    }

    public List GetAllSinhVien() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVien");
            lstSinhVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lstSinhVien;
    }

    public List GetAllSinhVienThucTap() {
        List<SinhVienThucTap> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE SoLanThucTap = true and HoatDong = true");
            lstSinhVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lstSinhVien;
    }

    public List GetAllSinhVienThucTapDuyetDT() {
        List<SinhVienThucTap> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE HoatDong = true and TrangThai =0");
            lstSinhVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lstSinhVien;
    }

    public List CheckSoLanThucTap() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE SoLanThucTap = true");
            lstSinhVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lstSinhVien;
    }

    public List<SinhVien> GetInfoSinhVien(int mssv) {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVien where Mssv =:mssv");
            q.setParameter("mssv", mssv);
            lstSinhVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVien;
    }

    public List GetKNLTSinhVien(int mssv) {
        List<SinhVienKnvaLt> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienKnvaLt where Mssv =:mssv");
            q.setParameter("mssv", mssv);
            lstSinhVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVien;
    }

    public List<SinhVienMucTieu> GetMucTieuSV(int mssv) {
        List<SinhVienMucTieu> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienMucTieu where Mssv =:mssv");
            q.setParameter("mssv", mssv);
            lstSinhVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVien;
    }

    public List GetSVTTbyMSSV(int mssv) {
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE Mssv =:mssv and HoatDong = TRUE");
            q.setParameter("mssv", mssv);
            lstSinhVienThucTap = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVienThucTap;
    }

    public SinhVienThucTap GetSVTTbyMSSVbyID(int id) {
        SinhVienThucTap sinhVienThucTap = null;
        try {
            transaction = session.beginTransaction();
            sinhVienThucTap = (SinhVienThucTap) session.get(SinhVienThucTap.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sinhVienThucTap;
    }

    public List GetSVTTbyMSSVTC(int id) {
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        SinhVienThucTap sinhVienThucTap = new SinhVienThucTap();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap ID =id");
            q.setParameter("mssv", id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVienThucTap;
    }

    public boolean DongYDeTaiSinhVien(SinhVienThucTap sinhVienThucTap) {

        try {
            transaction = session.beginTransaction();
            session.update(sinhVienThucTap);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return true;
    }

    public List DanhSachDetaiSinhVienThanhCong() {
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE HoatDong= TRUE and TrangThai=1");
            lstSinhVienThucTap = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVienThucTap;
    }

    public List GetHoatDongTrangThaiSoLanThucTap() {
        List<SinhVienThucTap> lstSinhVienThucTap = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE HoatDong= TRUE and TrangThai=1 and SoLanThucTap =TRUE");
            lstSinhVienThucTap = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVienThucTap;
    }

    public List SoLuongPhanHoi(int mssv) {
        List<TinNhanEmail> lsTinNhanEmail = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM TinNhanEmail WHERE LoaiEmail = FALSE and  Mssv =:mssv");
            q.setParameter("mssv", mssv);
            lsTinNhanEmail = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lsTinNhanEmail;
    }

    public List GetAllEmailPhanHoi() {
        List<TinNhanEmail> lsTinNhanEmail = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM TinNhanEmail WHERE LoaiEmail = FALSE ");
            lsTinNhanEmail = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lsTinNhanEmail;
    }

    public List GetAllFileSinhVien() {
        List<SinhVienFile> lstSinhVienFile = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienFile");
            lstSinhVienFile = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVienFile;
    }

    public List GetAllDiemSinhVien() {
        List<SinhVienDiem> lstSinhVienDiems = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienDiem WHERE TrangThai = FALSE");
            lstSinhVienDiems = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVienDiems;
    }

    public List GetAllDiemSinhVienOK() {
        List<SinhVienDiem> lstSinhVienDiems = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienDiem WHERE TrangThai = TRUE");
            lstSinhVienDiems = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVienDiems;
    }

    public List GetHeSoDiem() {
        List<HeSoDiem> lstHeSoDiem = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM HeSoDiem");
            lstHeSoDiem = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstHeSoDiem;
    }

    public boolean updateDiemThi(SinhVienDiem diem, boolean trangThai) {
        try {
            transaction = session.beginTransaction();
            SinhVienDiem sinhVienDiem = (SinhVienDiem) session.get(SinhVienDiem.class, diem.getMssv());
            if (trangThai) {
                sinhVienDiem.setTrangThai(trangThai);
            } else {
                sinhVienDiem.setCuoiKy(diem.getCuoiKy());
                sinhVienDiem.setDiemBaoCaoQuaTrinh(diem.getDiemBaoCaoQuaTrinh());
                sinhVienDiem.setDiemPhanHoi(diem.getDiemPhanHoi());
                sinhVienDiem.setQuaTrinh(diem.getQuaTrinh());
                sinhVienDiem.setTrangThai(true);
            }
            session.save(sinhVienDiem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean UploadFile(SinhVienFile file) {
        try {
            transaction = session.beginTransaction();
            session.save(file);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List GetFileSinhVienBCQT() {
        List<SinhVienFile> sinhVienFiles = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienFile WHERE LoaiFile =2");
            sinhVienFiles = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sinhVienFiles;
    }

    public List GetFileSinhVienBCCK() {
        List<SinhVienFile> sinhVienFiles = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienFile WHERE LoaiFile =1");
            sinhVienFiles = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sinhVienFiles;
    }

    public List GetFileSinhVienCC() {
        List<SinhVienFile> sinhVienFiles = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienFile WHERE LoaiFile =3");
            sinhVienFiles = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sinhVienFiles;
    }

    public List GetFileSinhVienDG() {
        List<SinhVienFile> sinhVienFiles = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienFile WHERE LoaiFile =4");
            sinhVienFiles = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sinhVienFiles;
    }

    public List GetFileGiangVien() {
        List<SinhVienFile> sinhVienFiles = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienFile WHERE LoaiFile =7");
            sinhVienFiles = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sinhVienFiles;
    }
    public List GetFileExcel() {
        List<SinhVienFile> sinhVienFiles = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienFile WHERE LoaiFile =8");
            sinhVienFiles = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sinhVienFiles;
    }

    public boolean SaveThongBaoLichTrinh(ThongBao thongBao) {
        try {
            transaction = session.beginTransaction();
            session.save(thongBao);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
