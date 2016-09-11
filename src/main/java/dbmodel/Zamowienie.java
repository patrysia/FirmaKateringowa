package dbmodel;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Patrycja on 10.09.2016.
 */
public class Zamowienie implements Serializable {

    private int idZam;
    private Date dataUtworzenia;
    private String adresZam;
    private Date dataDostawy;
    private String status;
    private Klient klient;

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdZam() {
        return idZam;
    }

    public void setIdZam(int idZam) {
        this.idZam = idZam;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public String getAdresZam() {
        return adresZam;
    }

    public void setAdresZam(String adresZam) {
        this.adresZam = adresZam;
    }

    public Date getDataDostawy() {
        return dataDostawy;
    }

    public void setDataDostawy(Date dataDostawy) {
        this.dataDostawy = dataDostawy;
    }
}
