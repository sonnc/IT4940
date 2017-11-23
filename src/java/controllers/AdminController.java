/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.CongTy;
import entities.DeTai;
import entities.GiangVien;
import entities.Login;
import entities.Logs;
import entities.SinhVien;
import entities.SinhVienDiem;
import entities.ThongBao;
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
public class AdminController {

    Session session;
    Transaction transaction;

    public AdminController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List GetAllTaiKhoan() {
        List<Login> lstLogin = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("From Login");
            lstLogin = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstLogin;
    }

    public boolean XoaTaikhoan(String email) {
        try {
            transaction = session.beginTransaction();
            Login login = (Login) session.get(Login.class, email);
            session.delete(login);
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

    public boolean ResetPass(String email) {
        try {
            transaction = session.beginTransaction();
            Login login = (Login) session.get(Login.class, email);
            login.setPassword(email);
            session.save(login);
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

    public List GetAllSinhVien() {
        List<SinhVien> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("From SinhVien");
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

    public boolean AddTaiKhoan(Login login) {
        try {
            transaction = session.beginTransaction();
            session.save(login);
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

    public boolean XoaSinhVien(int mssv) {
        try {
            transaction = session.beginTransaction();
            SinhVien sinhVien = (SinhVien) session.get(SinhVien.class, mssv);
            session.delete(sinhVien);
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

    public List GetAllDiem() {
        List<SinhVienDiem> lstSinhVienDiem = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienDiem");
            lstSinhVienDiem = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstSinhVienDiem;
    }

    public boolean XoaSinhVienDiem(int mssv) {
        try {
            transaction = session.beginTransaction();
            SinhVienDiem sinhVien = (SinhVienDiem) session.get(SinhVienDiem.class, mssv);
            session.delete(sinhVien);
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

    public List GetAllGiangVien() {
        List<GiangVien> lstGiangVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM GiangVien");
            lstGiangVien = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstGiangVien;
    }

    public boolean XoaGiangVien(int id) {
        try {
            transaction = session.beginTransaction();
            GiangVien giangVien = (GiangVien) session.get(GiangVien.class, id);
            session.delete(giangVien);
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

    public boolean XoaCongTy(int msct) {
        try {
            transaction = session.beginTransaction();
            CongTy congTy = (CongTy) session.get(CongTy.class, msct);
            session.delete(congTy);
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
        List<DeTai> lstDeTai = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM DeTai");
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

    public boolean XoaDeTai(int id) {
        try {
            transaction = session.beginTransaction();
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

    public List GetAllThongBao() {
        List<ThongBao> lsThongBao = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM ThongBao");
            lsThongBao = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lsThongBao;
    }

    public boolean XoaThongBao(int id) {
        try {
            transaction = session.beginTransaction();
            ThongBao thongBao = (ThongBao) session.get(ThongBao.class, id);
            session.delete(thongBao);
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

    public List GetAllLogs() {
        List<Logs> lstLogs = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Logs");
            lstLogs = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstLogs;
    }

}
