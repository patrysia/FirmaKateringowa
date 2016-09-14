package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dbmodel.Kategoria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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

        Gson gson = new GsonBuilder().setExclusionStrategies(new PotrawaBezKategorii()).create();
        String json = gson.toJson(categoriesList);

        return json;
    }

    @POST
    @Path("/nowakategoria")
    @Consumes("application/json")
    public Response postKategoria(String json) {

        Kategoria kategoria = new Gson().fromJson(json, Kategoria.class);

        Session session = dbmodel.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(kategoria);
        session.getTransaction().commit();
//
        return Response.status(Response.Status.CREATED).build();
    }
}
