/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Login;
import entities.SinhVien;
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
public class LoginController {

    Session session;
    Transaction transaction;

    public LoginController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List<Login> Login(String email, String pass) {
        List<Login> lstLogin = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Login WHERE Email =:email and Password =:pass");
            query.setParameter("email", email);
            query.setParameter("pass", pass);
            lstLogin = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lstLogin;
    }

    public boolean CreateAccount(Login l) {
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

    public  List CheckAccount(String email) {
        List<Login> lstLogin = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Login WHERE Email =:email and Rule = 3");
            q.setParameter("email", email);
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

}
