/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author sonnguyen
 */
public class DdctController {

    Session session;
    Transaction transaction;

    public DdctController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean CapNhatCongTy(CongTy c) {
        try {
            transaction = session.beginTransaction();
            session.save(c);
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

    public boolean CapNhatDDCT(DaiDienCongTy d) {
        try {
            transaction = session.beginTransaction();
            session.save(d);
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

    public List GetDaiDienCongTy(String email) {
        List<DaiDienCongTy> lstDaiDienCongTy = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DaiDienCongTy WHERE Email =:email");
            q.setParameter("email", email);
            lstDaiDienCongTy = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstDaiDienCongTy;
    }

    public List GetMSCT(String email) {
        List<DaiDienCongTy> lstDaiDienCongTy = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM CongTy WHERE email =:email");
            q.setParameter("email", email);
            lstDaiDienCongTy = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstDaiDienCongTy;
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

    public boolean SaveTKNhanVien(Login l) {
        try {
            transaction = session.beginTransaction();
            session.save(l);
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

    public boolean SaveNhanVien(GiangVienHuongDan gvhd) {
        try {
            transaction = session.beginTransaction();
            session.save(gvhd);
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

    public List GelAllDeTai(int msct) {
        List<DeTai> lsDeTai = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai WHERE MaCongTy =:msct");
            q.setParameter("msct", msct);
            lsDeTai = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lsDeTai;
    }

    public boolean SaveDeTai(DeTai deTai) {
        try {
            transaction = session.beginTransaction();
            session.save(deTai);
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

    public boolean DeleteDetai(int id, int msct) {
        List<SinhVienThucTap> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE MaCongTy =:msct");
            q.setParameter("msct", msct);
            list = q.list();
            if (list.size() >= 1) {
                return false;
            }
            DeTai deTai = (DeTai) session.get(DeTai.class, id);
            session.delete(deTai);
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

    // kiểm tra xem đề tài đã có sinh viên nào đăng ký chưa
//    public boolean CheckDeTaiSV(int msct) {
//        List<SinhVienThucTap> list = new ArrayList<>();
//        try {
//            transaction = session.beginTransaction();
//            Query q = session.createQuery("FROM SinhVienThucTap WHERE MaCongTy =:msct");
//            q.setParameter("msct", msct);
//            list = q.list();
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
    public List GetAllSinhVienThucTapByID(int msct) {
        List<SinhVienThucTap> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE MaCongTy =:msct and TrangThai = true");
            q.setParameter("msct", msct);
            list = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List GetAllSinhVien() {
        List<SinhVien> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVien");
            list = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
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
}
