/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import controllers.*;
import entities.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonnguyen
 */
public class OtherAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private HttpServletRequest request;
    private Map<String, Object> session;
    private OtherController otherController;
    private CongTy congTy;
    private List<CongTy> lstCongTy;
    private List<ThongBao> lstThongBao;

    public List<ThongBao> getLstThongBao() {
        return lstThongBao;
    }

    public void setLstThongBao(List<ThongBao> lstThongBao) {
        this.lstThongBao = lstThongBao;
    }

    public List<CongTy> getLstCongTy() {
        return lstCongTy;
    }

    public void setLstCongTy(List<CongTy> lstCongTy) {
        this.lstCongTy = lstCongTy;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public CongTy getCongTy() {
        return congTy;
    }

    public void setCongTy(CongTy congTy) {
        this.congTy = congTy;
    }

    public OtherAction() {
        otherController = new OtherController();
    }

    public String GetAllHome() {
        lstCongTy = otherController.GetAllCongTy();
        lstThongBao = otherController.GetAllThongBao();
        session.put("lstCongTy", lstCongTy);
        session.put("SQLHome", "SQLHome");
        return SUCCESS;
    }
    
    

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
