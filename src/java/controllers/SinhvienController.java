/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.org.apache.bcel.internal.generic.D2F;
import entities.*;
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
public class SinhvienController {

    Session session;
    Transaction transaction;

    public SinhvienController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    // Phần lấy thông tin sinh viên
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

    public List<SinhVienDiem> GetDiemSinhVien(int mssv) {
        List<SinhVienDiem> lstDiem = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienDiem where Mssv =:mssv");
            q.setParameter("mssv", mssv);
            lstDiem = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstDiem;
    }

    public List<SinhVienKnvaLt> GetKNLTSinhVien(int mssv) {
        List<SinhVienKnvaLt> lstKNLT = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienKnvaLt where Mssv =:mssv");
            q.setParameter("mssv", mssv);
            lstKNLT = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstKNLT;
    }

    public List<SinhVienMucTieu> GetMucTieuSinhVien(int mssv) {
        List<SinhVienMucTieu> lstMucTieu = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienMucTieu WHERE Mssv =:mssv");
            q.setParameter("mssv", mssv);
            lstMucTieu = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstMucTieu;
    }

    public List<SinhVienThucTap> GetThucTapSinhVien(int mssv) {
        List<SinhVienThucTap> lstThucTap = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE Mssv =:mssv");
            q.setParameter("mssv", mssv);
            lstThucTap = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstThucTap;
    }

    // phần lưu thông tin sinh viên
    public boolean SaveInfoSinhVien(SinhVien sv, SinhVienKnvaLt svkl, SinhVienMucTieu svmt) {
        try {
            transaction = session.beginTransaction();
            session.save(sv);
            session.save(svkl);
            session.save(svmt);
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

    public boolean SaveDiemSinhVien(SinhVienDiem svd) {
        try {
            transaction = session.beginTransaction();
            session.save(svd);
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

    public boolean SaveMucTieuSinhVien(SinhVienMucTieu mtsv) {
        try {
            transaction = session.beginTransaction();
            session.save(mtsv);
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

    public boolean SaveKNvaLT(SinhVienKnvaLt knlt) {
        try {
            transaction = session.beginTransaction();
            session.save(knlt);
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

    public boolean SaveThucTapSinhVien(SinhVienThucTap svtt) {
        try {
            transaction = session.beginTransaction();
            session.save(svtt);
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

    // Phần cập nhật thông tin sinh viên
    public boolean UpdateSinhVien(SinhVien sv) {
        try {
            transaction = session.beginTransaction();
            session.update(sv);
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

    public boolean UpdateMucTieuSinhVien(SinhVienMucTieu svmt) {
        try {
            transaction = session.beginTransaction();
            session.update(svmt);
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

    public boolean UpdateSinhVienDiem(SinhVienDiem svd) {
        try {
            transaction = session.beginTransaction();
            session.update(svd);
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

    public boolean UpdateSinhVienKNLT(SinhVienKnvaLt knlt) {
        try {
            transaction = session.beginTransaction();
            session.update(knlt);
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

    public boolean UpdateSinhVienThucTap(SinhVienThucTap svtt) {
        try {
            transaction = session.beginTransaction();
            session.update(svtt);
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

    public List GetDeTaiSVTT(int id) {
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
        }
        return lstDeTai;
    }

    public List GetCongTySVTT(int msct) {
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

    public List GetAllCongTy() {
        List<CongTy> lstCongTy = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM CongTy");
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

    public List GetAllDeTai() {
        List<DeTai> lstDeTai = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai WHERE TrangThai = 1");
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

    public int GetMaGVHDfromDeTai(int id) {
        List<DeTai> lstDeTai = new ArrayList<>();
        int x = 0;
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai WHERE ID =:id");
            q.setParameter("id", id);
            lstDeTai = q.list();
            x = lstDeTai.get(0).getGvhd();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return x;
    }

    public int GetSoLuongDeTaiDKofSV(int mssv) {
        List<SinhVienThucTap> sinhVienThucTaps = new ArrayList<>();
        int x = 0;
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE Mssv =:mssv");
            q.setParameter("mssv", mssv);
            sinhVienThucTaps = q.list();
            x = sinhVienThucTaps.size();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return x;
    }

    public List GetFileSinhVien(int mssv) {
        List<SinhVienFile> sinhVienFiles = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienFile WHERE Mssv =:mssv");
            q.setParameter("mssv", mssv);
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
    public List GetDeTaiSinhVienTRUE(int mssv) {
        List<SinhVienFile> sinhVienFiles = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE Mssv =:mssv and TrangThai = 1");
            q.setParameter("mssv", mssv);
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

    public boolean UploadFileSinhVien(SinhVienFile file) {
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
    
   

}
