package rest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import dbmodel.Danie;
import dbmodel.Kategoria;
import dbmodel.Skladnik;

/**
 * Created by Patrycja on 11.09.2016.
 */
public class PotrawaBezKategorii implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if(fieldAttributes.getDeclaringClass() == Danie.class && fieldAttributes.getName().equalsIgnoreCase("kategoria")){
            return true;
        }

        if(fieldAttributes.getDeclaringClass() == Skladnik.class && fieldAttributes.getName().equalsIgnoreCase("danie")){
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
