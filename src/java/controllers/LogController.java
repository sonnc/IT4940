/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.Logs;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sonnguyen
 */
public class LogController {

    Session session;
    Transaction transaction;

    public LogController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void Log(String user, String content) {
        Logs l = new Logs();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp timeDate = new Timestamp(utilDate.getTime());
        l.setUser(user);
        l.setDate(timeDate);
        l.setContent(content);
        try {
            transaction = session.beginTransaction();
            session.save(l);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
