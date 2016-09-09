package dbmodel;

import java.io.Serializable;

/**
 * Created by Patrycja on 08.09.2016.
 */
public class Skladnik implements Serializable {

    private int idSkl;
    private String nazwa;
    private int ilosc;
    private Danie danie;

    public Skladnik() {
        this.idSkl = 0;
        this.nazwa = "";
        this.ilosc = 0;
        this.danie = new Danie();
    }

    public Danie getDanie() {
        return danie;
    }

    public void setDanie(Danie danie) {
        this.danie = danie;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIdSkl() {
        return idSkl;
    }

    public void setIdSkl(int id) {
        this.idSkl = id;
    }
}
