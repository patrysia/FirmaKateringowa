package model;

import dbmodel.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrycja on 23.08.2016.
 */
@ManagedBean (name = "menuBean")
@SessionScoped
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

    /**
     *
     * @param id_kat
     * @return
     */
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

    /**
     *
     * @return
     */
    /**
    public List<Danie> findBestDishes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ProjectionList projectionList = Projections.projectionList().add(Projections.groupProperty("")).add(Projections.alias(Projections.rowCount(), ""));
        Criteria criteria = session.createCriteria(Zamowienie.class).setProjection(projectionList);
        List<Danie[]> dania = criteria.addOrder(Order.desc("ilosc")).list();
        HibernateUtil.shutdown();


        List<Danie> bestDishes = new ArrayList<>();
        for(Object[] result : dania) {
            bestDishes.add((Danie) result[0]);
        }

        return bestDishes;
    }
    */

    /**
     *
     * @param kategoria
     */
    public void removeCategory(Kategoria kategoria) {
        for (Kategoria k: this.categoriesList
             ) {
            if (k.getIdKat() == kategoria.getIdKat()) {
                this.categoriesList.remove(k);
            }
        }
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
