package entities;
// Generated Oct 27, 2017 9:43:57 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * SinhVien generated by hbm2java
 */
public class SinhVien  implements java.io.Serializable {


     private int mssv;
     private String hoTen;
     private String lop;
     private int khoa;
     private String vienKhoa;
     private String email;
     private int dienThoai;
     private String avatar;
     private Date ngaySinh;
     private String diaChi;
     private boolean lapTop;

    public SinhVien() {
    }

	
    public SinhVien(int mssv, String hoTen, String lop, int khoa, String vienKhoa, String email, int dienThoai, Date ngaySinh, String diaChi, boolean lapTop) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.lop = lop;
        this.khoa = khoa;
        this.vienKhoa = vienKhoa;
        this.email = email;
        this.dienThoai = dienThoai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.lapTop = lapTop;
    }
    public SinhVien(int mssv, String hoTen, String lop, int khoa, String vienKhoa, String email, int dienThoai, String avatar, Date ngaySinh, String diaChi, boolean lapTop) {
       this.mssv = mssv;
       this.hoTen = hoTen;
       this.lop = lop;
       this.khoa = khoa;
       this.vienKhoa = vienKhoa;
       this.email = email;
       this.dienThoai = dienThoai;
       this.avatar = avatar;
       this.ngaySinh = ngaySinh;
       this.diaChi = diaChi;
       this.lapTop = lapTop;
    }
   
    public int getMssv() {
        return this.mssv;
    }
    
    public void setMssv(int mssv) {
        this.mssv = mssv;
    }
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getLop() {
        return this.lop;
    }
    
    public void setLop(String lop) {
        this.lop = lop;
    }
    public int getKhoa() {
        return this.khoa;
    }
    
    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }
    public String getVienKhoa() {
        return this.vienKhoa;
    }
    
    public void setVienKhoa(String vienKhoa) {
        this.vienKhoa = vienKhoa;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public int getDienThoai() {
        return this.dienThoai;
    }
    
    public void setDienThoai(int dienThoai) {
        this.dienThoai = dienThoai;
    }
    public String getAvatar() {
        return this.avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Date getNgaySinh() {
        return this.ngaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public boolean getLapTop() {
        return this.lapTop;
    }
    
    public void setLapTop(boolean lapTop) {
        this.lapTop = lapTop;
    }




}


