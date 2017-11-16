/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author sonnguyen
 */
public class HeSoDiem {
      private int id;
     private double heSoPhanHoi;
     private double heSoBaoCaoQuaTrinh;
     private double heSoQuaTrinh;
     private double heSoCuoiKy;

    public HeSoDiem() {
    }

    public HeSoDiem(int id, double heSoPhanHoi, double heSoBaoCaoQuaTrinh, double heSoQuaTrinh, double heSoCuoiKy) {
        this.id = id;
        this.heSoPhanHoi = heSoPhanHoi;
        this.heSoBaoCaoQuaTrinh = heSoBaoCaoQuaTrinh;
        this.heSoQuaTrinh = heSoQuaTrinh;
        this.heSoCuoiKy = heSoCuoiKy;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeSoPhanHoi() {
        return heSoPhanHoi;
    }

    public void setHeSoPhanHoi(double heSoPhanHoi) {
        this.heSoPhanHoi = heSoPhanHoi;
    }

    public double getHeSoBaoCaoQuaTrinh() {
        return heSoBaoCaoQuaTrinh;
    }

    public void setHeSoBaoCaoQuaTrinh(double heSoBaoCaoQuaTrinh) {
        this.heSoBaoCaoQuaTrinh = heSoBaoCaoQuaTrinh;
    }

    public double getHeSoQuaTrinh() {
        return heSoQuaTrinh;
    }

    public void setHeSoQuaTrinh(double heSoQuaTrinh) {
        this.heSoQuaTrinh = heSoQuaTrinh;
    }

    public double getHeSoCuoiKy() {
        return heSoCuoiKy;
    }

    public void setHeSoCuoiKy(double heSoCuoiKy) {
        this.heSoCuoiKy = heSoCuoiKy;
    }
     
     
     
}
