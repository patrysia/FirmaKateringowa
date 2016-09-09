package model;

import dbmodel.Danie;
import dbmodel.Kategoria;
import dbmodel.Skladnik;
import org.hibernate.Session;


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

    List<String> breakfastList = new ArrayList<>();
    List<String> starterList = new ArrayList<>();
    List<String> soupList = new ArrayList<>();
    List<String> mainDishList = new ArrayList<>();
    List<String> dessertList = new ArrayList<>();
    List<List> drinkList = new ArrayList<>();
    List<String> coldDrinkList = new ArrayList<>();
    List<String> hotDrinkList = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Hibernate");

        Session session = dbmodel.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Kategoria sniadanie = new Kategoria();
        sniadanie.setIdKat(1);
        sniadanie.setNazwa("Sniadanie");
        session.save(sniadanie);

        Danie danie1 = new Danie();
        danie1.setIdDan(1);
        danie1.setNazwa("Jajecznica z pomidorami");
        danie1.setCena(5.5);
        danie1.setKategoria(sniadanie);
        danie1.setZdjecie("zdj");
        session.save(danie1);

        Skladnik skladnik1 = new Skladnik();
        skladnik1.setIdSkl(1);
        skladnik1.setNazwa("sol");
        skladnik1.setIlosc(10);
        skladnik1.setDanie(danie1);

        danie1.getSkladniki().add(skladnik1);
        sniadanie.getDania().add(danie1);
        session.save(skladnik1);

        //categoriesList = session.createCriteria(Kategoria.class).list();


        session.getTransaction().commit();
        System.out.println("Done");
    }

    public MenuBean() {



        this.setCategoriesList();
        this.setBreakfastList();
        this.setStarterList();
        this.setSoupList();
        this.setMainDishList();
        this.setDessertList();
        this.setColdDrinkList();
        this.setHotDrinkList();
        this.setDrinkList();
    }

    public List<dbmodel.Kategoria> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<dbmodel.Kategoria> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public List<String> getColdDrinkList() {
        return coldDrinkList;
    }

    public List<String> getHotDrinkList() {
        return hotDrinkList;
    }

    public List<String> getBreakfastList() {
        return breakfastList;
    }

    public List<String> getStarterList() {
        return starterList;
    }

    public List<String> getSoupList() {
        return soupList;
    }

    public List<String> getMainDishList() {
        return mainDishList;
    }

    public List<String> getDessertList() {
        return dessertList;
    }

    public List<List> getDrinkList() {
        return drinkList;
    }

    public void setCategoriesList() {
//        this.categoriesList.add("Śniadania");
//        this.categoriesList.add("Przystawki");
//        this.categoriesList.add("Zupy");
//        this.categoriesList.add("Dania główne");
//        this.categoriesList.add("Desery");
//        this.categoriesList.add("Napoje");
    }

    public void setBreakfastList() {
        this.breakfastList.add("Jajecznica z pomidorami");
        this.breakfastList.add("Jajka sadzone na szpinaku");
        this.breakfastList.add("Jogurt z granolą i miodem");
        this.breakfastList.add("Naleśniki z brzoskwiniami i sosem czekoladowym");
        this.breakfastList.add("Szaszłyki z parówką");
        this.breakfastList.add("Twarożek z łososiem i szczypiorkiem");
    }

    public void setStarterList() {
        this.starterList.add("Melon w szynce parmeńskiej");
        this.starterList.add("Pieczony burak z kozim serem");
        this.starterList.add("Pieczywo czosnkowe z serem");
        this.starterList.add("Sałatka Cezar z kurczakiem");
        this.starterList.add("Sałatka Cezar z krewetkami");
    }

    public void setSoupList() {
        this.soupList.add("Barszcz czerwony");
        this.soupList.add("Pikantny krem z marchwii");
        this.soupList.add("Zupa ogórkowa");
        this.soupList.add("Rosół");
        this.soupList.add("Zupa pomidorowa");
        this.soupList.add("Zupa krem z selera");
        this.soupList.add("Żurek");
    }

    public void setMainDishList() {
        this.mainDishList.add("Gołąbki warzywne");
        this.mainDishList.add("Kotlet schabowy, frytki, surówka");
        this.mainDishList.add("Kotlety mielone z buraczkami");
        this.mainDishList.add("Łosoś pieczony z makaronem i warzywami");
        this.mainDishList.add("Pierogi ruskie");
        this.mainDishList.add("Pierś z kurczaka z mozarellą");
        this.mainDishList.add("Pyzy z mięsem");
        this.mainDishList.add("Ryż z ciecierzycą i rodzynkami");
    }

    public void setDessertList() {
        this.dessertList.add("Jabłko pieczone z miodem");
        this.dessertList.add("Lody z owocami");
        this.dessertList.add("Sernik");
        this.dessertList.add("Szarlotka");
        this.dessertList.add("Tiramisu");
    }

    public void setColdDrinkList() {
        this.coldDrinkList.add("Woda niegazowana");
        this.coldDrinkList.add("Woda gazowana");
        this.coldDrinkList.add("Sok pomarańczowy");
        this.coldDrinkList.add("Kompot wiśniowy");
        this.coldDrinkList.add("Coca-cola");
    }

    public void setHotDrinkList() {
        this.hotDrinkList.add("Espresso");
        this.hotDrinkList.add("Latte");
        this.hotDrinkList.add("Cappuccino");
        this.hotDrinkList.add("Herbata czarna");
        this.hotDrinkList.add("Zielona herbata");
        this.hotDrinkList.add("Czekolada na gorąco");
    }

    public void setDrinkList() {
        this.drinkList.add(this.coldDrinkList);
        this.drinkList.add(this.hotDrinkList);
    }
}
