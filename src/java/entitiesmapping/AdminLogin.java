/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesmapping;

/**
 *
 * @author sonnguyen
 */
public class AdminLogin {
    private int stt;
    private String email;
    private String loaiTaiKhoan;

    public AdminLogin() {
       
    }
    public AdminLogin(int stt, String email, String loaiTaiKhoan) {
        this.stt = stt;
        this.email = email;
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }
    
    
    
}
