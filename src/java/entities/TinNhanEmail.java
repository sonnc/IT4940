package entities;
// Generated Oct 27, 2017 9:43:57 PM by Hibernate Tools 4.3.1



/**
 * TinNhanEmail generated by hbm2java
 */
public class TinNhanEmail  implements java.io.Serializable {


     private int id;
     private String nguoiGui;
     private String nguoiNhan;
     private String tieuDe;
     private String noiDung;
     private String thoiGian;

    public TinNhanEmail() {
    }

	
    public TinNhanEmail(int id) {
        this.id = id;
    }
    public TinNhanEmail(int id, String nguoiGui, String nguoiNhan, String tieuDe, String noiDung, String thoiGian) {
       this.id = id;
       this.nguoiGui = nguoiGui;
       this.nguoiNhan = nguoiNhan;
       this.tieuDe = tieuDe;
       this.noiDung = noiDung;
       this.thoiGian = thoiGian;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNguoiGui() {
        return this.nguoiGui;
    }
    
    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }
    public String getNguoiNhan() {
        return this.nguoiNhan;
    }
    
    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }
    public String getTieuDe() {
        return this.tieuDe;
    }
    
    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public String getNoiDung() {
        return this.noiDung;
    }
    
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public String getThoiGian() {
        return this.thoiGian;
    }
    
    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }




}


