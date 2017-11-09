package controllers;

import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sonnguyen
 */
public class OtherController {

    Session session;
    Transaction transsaction;

    public OtherController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List GetAllCongTy() {
        List<CongTy> lstCongTy = new ArrayList<>();
        try {
            transsaction = session.beginTransaction();
            Query q = session.createQuery("FROM CongTy");
            lstCongTy = q.list();
            transsaction.commit();
        } catch (Exception e) {
            if (transsaction != null) {
                transsaction.rollback();
            }
        }
        return lstCongTy;
    }

    public List GetAllThongBao() {
        List<ThongBao> lstThongBao = new ArrayList<>();
        try {
            transsaction = session.beginTransaction();
            Query q = session.createQuery("FROM ThongBao");
            lstThongBao = q.list();
            transsaction.commit();
        } catch (Exception e) {
            if (transsaction != null) {
                transsaction.rollback();
            }
        }
        return lstThongBao;
    }
    
//    public List GetAllFile(){
//    
//    }

}
