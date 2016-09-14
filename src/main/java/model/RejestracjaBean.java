package model;

import dbmodel.HibernateUtil;
import dbmodel.Klient;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Patrycja on 11.09.2016.
 */
public class RejestracjaBean {

    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;

    public String zarejestruj() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Klient klient = (Klient)session.createCriteria(Klient.class).add(Restrictions.eq("email", email.toLowerCase())).uniqueResult();
        session.getTransaction().commit();

        FacesContext context = FacesContext.getCurrentInstance();

        if (klient.getImie().isEmpty() || klient.getNazwisko().isEmpty() || klient.getEmail().isEmpty() || klient.getHaslo().isEmpty()) {
            context.addMessage(null,  new FacesMessage("Aby się zarejestrować, musisz uzupełnić wszystkie pola"));
            imie = null;
            nazwisko = null;
            email = null;
            haslo = null;
            return null;
        }

        //

        return "login?faces-redirect=true";
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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
