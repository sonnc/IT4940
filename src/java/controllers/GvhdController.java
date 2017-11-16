/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.GiangVienHuongDan;
import entities.SinhVien;
import entities.SinhVienDiem;
import entities.SinhVienFile;
import entities.SinhVienThucTap;
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
public class GvhdController {

    Session session;
    Transaction transaction;

    public GvhdController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List GetInfo(String email) {
        List<GiangVienHuongDan> lsGiangVienHuongDan = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM GiangVienHuongDan WHERE Email =:email");
            q.setParameter("email", email);
            lsGiangVienHuongDan = q.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lsGiangVienHuongDan;
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

    public List GetAllSinhVienThucTap(int ms) {
        List<SinhVienThucTap> lstSinhVien = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM SinhVienThucTap WHERE SoLanThucTap = true and HoatDong = true and NguoiHuongDan =:ms");
            q.setParameter("ms", ms);
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

    public boolean SaveDiem(SinhVienDiem diem) {
        try {
            transaction = session.beginTransaction();
            session.save(diem);
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
