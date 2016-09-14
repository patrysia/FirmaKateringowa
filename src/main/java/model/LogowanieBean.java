package model;

import dbmodel.HibernateUtil;
import dbmodel.Klient;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Patrycja on 10.09.2016.
 */
@ManagedBean
@SessionScoped
public class LogowanieBean {

    private String email;
    private String haslo;

    public String zaloguj() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Klient klient = (Klient) session.createCriteria(Klient.class).add(Restrictions.eq("email", email.toLowerCase())).uniqueResult();
        session.getTransaction().commit();

        FacesContext context = FacesContext.getCurrentInstance();

        if (klient == null) {
            context.addMessage(null, new FacesMessage("Brak uzytownika w bazie"));
            email = null;
            haslo = null;
            return null;
        }
        if (!klient.getHaslo().equals(haslo)) {
            context.addMessage(null, new FacesMessage("Zle haslo"));
            email = null;
            haslo = null;
            return null;
        }

        context.getExternalContext().getSessionMap().put("klient", klient);
        return "index?faces-redirect=true";
    }

    public String wyloguj(){
        System.out.println("ADADASD");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
