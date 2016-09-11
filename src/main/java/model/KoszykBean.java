package model;

import dbmodel.Danie;
import dbmodel.Klient;
import dbmodel.Zamowienie;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrycja on 10.09.2016.
 */
@ManagedBean
@SessionScoped
public class KoszykBean {

    private List<Danie> listaDan = new ArrayList<>();
    private Zamowienie zamowienie;


    @PostConstruct
    public void init() {
        zamowienie = new Zamowienie();
    }

    /**
     *
     * @param danie
     */
    public String dodajDoKoszyka(Danie danie) {
        System.err.println("Dodaje do koszyka: " + danie.getNazwa());
        this.listaDan.add(danie);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pomyślnie dodano do koszyka", danie.getNazwa());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;

    }

    /**
     *
     * @param danie
     */
    public void usunZkoszyka(Danie danie) {
        this.listaDan.remove(danie);
    }

    /**
     *
     * @return
     */
    public String zlozZamowienie() {
        Klient klient = (Klient) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("klient");
        zamowienie.setKlient(klient);
        listaDan.clear();

        return "zamowienieZlozone";
    }

    public List<Danie> getListaDan() {
        return listaDan;
    }

    public void setListaDan(List<Danie> listaDan) {
        this.listaDan = listaDan;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
}
