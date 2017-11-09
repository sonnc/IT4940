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
public class SoKhop {
    private String laptrinh;
    private double danhGia;

    public SoKhop() {
    }

    public SoKhop(String laptrinh, double danhGia) {
        this.laptrinh = laptrinh;
        this.danhGia = danhGia;
    }

    public String getLaptrinh() {
        return laptrinh;
    }

    public void setLaptrinh(String laptrinh) {
        this.laptrinh = laptrinh;
    }

    public double getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(double danhGia) {
        this.danhGia = danhGia;
    }
    
    
}
