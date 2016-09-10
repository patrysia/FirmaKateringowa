package model;

import dbmodel.Danie;
import dbmodel.Kategoria;
import dbmodel.Skladnik;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrycja on 23.08.2016.
 */
@ManagedBean (name = "menuBean")
@RequestScoped
public class MenuBean {

    List<Kategoria> categoriesList = new ArrayList<>();
    List<Danie> dishesList = new ArrayList<>();
    List<Skladnik> ingredientsList = new ArrayList<>();
    List<Danie> dishesCategory =  new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Hibernate");

        Session session = dbmodel.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        categoriesList = session.createCriteria(Kategoria.class).addOrder(Order.asc("idKat")).list();
        dishesList = session.createCriteria(Danie.class).list();
        ingredientsList = session.createCriteria(Skladnik.class).list();

        session.getTransaction().commit();
        System.out.println("Done");
    }

    public MenuBean() {

    }

    public String findDishesByCategory(Integer id_kat) {
        dishesCategory.clear();
        for (Danie d: this.dishesList) {
            System.err.println(id_kat);
            if (d.getKategoria().getIdKat() == id_kat) {

                dishesCategory.add(d);
            }
        }
        return "dish";
    }

    public List<Danie> getDishesCategory() {
        return dishesCategory;
    }

    public void setDishesCategory(List<Danie> dishesCategory) {
        this.dishesCategory = dishesCategory;
    }

    public List<dbmodel.Kategoria> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<dbmodel.Kategoria> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public List<Danie> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Danie> dishesList) {
        this.dishesList = dishesList;
    }

    public List<Skladnik> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Skladnik> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }
}
