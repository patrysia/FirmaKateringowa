package dbmodel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Patrycja on 08.09.2016.
 */
public class Kategoria implements Serializable {

    private Integer id = 0;
    private String nazwa = "";
    private Set<Danie> dania = new HashSet<>();

    public Set<Danie> getDania() {
        return dania;
    }

    public void setDania(Set<Danie> dania) {
        this.dania = dania;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
