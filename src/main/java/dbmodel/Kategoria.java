package dbmodel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Patrycja on 08.09.2016.
 */
public class Kategoria implements Serializable {

    private Integer idKat;
    private String nazwa;
    private Set<Danie> dania;

    public Kategoria() {
        this.idKat = 0;
        this.nazwa = "";
        this.dania = new HashSet<>();
    }

    public Integer getIdKat() {
        return idKat;
    }

    public void setIdKat(Integer idKat) {
        this.idKat = idKat;
    }

    public Set<Danie> getDania() {
        return dania;
    }

    public void setDania(Set<Danie> dania) {
        this.dania = dania;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
