package dbmodel;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Patrycja on 08.09.2016.
 */
public class Danie implements Serializable {

    private Integer id;
    private String nazwa;
    private Double cena;
    private Kategoria kategoria;
    private String zdjecie;
    private Set<Skladnik> skladniki;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }

    public Set<Skladnik> getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(Set<Skladnik> skladniki) {
        this.skladniki = skladniki;
    }
}
