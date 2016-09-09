package dbmodel;

import java.io.Serializable;

/**
 * Created by Patrycja on 08.09.2016.
 */
public class Skladnik implements Serializable {

    private int id;
    private String nazwa;
    private int ilosc;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
