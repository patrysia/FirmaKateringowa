package rest;

import com.google.gson.Gson;
import dbmodel.Kategoria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Patrycja on 11.09.2016.
 */
@Path("/catalog")
@Stateless
@RequestScoped
public class RestService {

    @GET
    @Path("/rest")
    public String get() {
        return "Jestem w RestService";
    }

    @GET
    @Path("/kategorie")
    @Produces("application/json")
    public String getKategorie() {
        Session session = dbmodel.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Kategoria> categoriesList;
        categoriesList = session.createCriteria(Kategoria.class).addOrder(Order.asc("idKat")).list();
        session.getTransaction().commit();

        Gson gson = new Gson();
        String json = gson.toJson(categoriesList);

        return json;
    }
}
