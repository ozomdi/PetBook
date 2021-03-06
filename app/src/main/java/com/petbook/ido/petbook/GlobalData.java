package com.petbook.ido.petbook;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Switch;

import com.petbook.ido.petbook.BL.Pet;
import com.petbook.ido.petbook.BL.SearchData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ido on 8/12/2016.
 */
public class GlobalData {

    public static Map<Integer,String> mpAreas = new HashMap<Integer, String>();
    public static Map<Integer,String> mpTypes = new HashMap<Integer, String>();
    private static GlobalData gldInstance;
    public static List<Pet> lstChosenPets = new ArrayList<Pet>();
    public static SearchData sdCurrSearch;
    private static String fromWhere;

    public GlobalData(){
        this.setAnimalTypes();
    }

    public static GlobalData getInstance(){
        if(gldInstance == null){
            gldInstance = new GlobalData();
        }

        return gldInstance;
    }

    public void setSearchData(int nGender,
                              int nType,
                              String strCond,
                              int nAreaID,
                              int nMinAge,
                              int nMaxAge)
    {
        sdCurrSearch = new SearchData(nGender,
                                      nType,
                                      strCond,
                                      nAreaID,
                                      nMinAge,
                                      nMaxAge);
    }

    public SearchData getSdCurrSearch()
    {
        return sdCurrSearch;
    }



    public void setAreasIfNotSet()
    {
        if(mpAreas.size() == 0)
        {
            mpAreas.put(Enums.LOCATIONS.NORTH.ordinal(), "צפון");
            mpAreas.put(Enums.LOCATIONS.HADERA_NORTH_AMAKIM.ordinal(), "חדרה זכרון ועמקים");
            mpAreas.put(Enums.LOCATIONS.HASHARON.ordinal(), "השרון");
            mpAreas.put(Enums.LOCATIONS.MERKAZ.ordinal(), "מרכז");
            mpAreas.put(Enums.LOCATIONS.JERUSALEM.ordinal(), "ירושלים");
            mpAreas.put(Enums.LOCATIONS.YEHUDA_AND_SHOMRON.ordinal(), "יהודה ושומרון");
            mpAreas.put(Enums.LOCATIONS.SHFELA_AND_MISHOR_HOF_SOUTH.ordinal(), "שפלה ומישור חוף דרומי");
            mpAreas.put(Enums.LOCATIONS.SOUTH.ordinal(), "דרום");
        }
    }

    private void setAnimalTypes()
    {
        if(mpTypes.size() == 0)
        {
            mpTypes.put(Enums.Type.DOG.ordinal(), "כלב");
            mpTypes.put(Enums.Type.CAT.ordinal(), "חתול");
            mpTypes.put(Enums.Type.TURTLE.ordinal(), "צב");
            mpTypes.put(Enums.Type.DONKEY.ordinal(), "חמור");
            mpTypes.put(Enums.Type.PEACOC.ordinal(), "טווס");
            mpTypes.put(Enums.Type.HORSE.ordinal(), "סוס");
            mpTypes.put(Enums.Type.HAMUS.ordinal(), "חמוס");
            mpTypes.put(Enums.Type.TURKEY.ordinal(), "תרנגול");
        }
    }

    public int getAreaID(String strName)
    {
        for ( Integer nKey : mpAreas.keySet() ) {
            if (mpAreas.get(nKey).equals(strName))
            {
                return nKey.intValue();
            }
        }

        return 0;
    }

    public String getAreaString(int nKey)
    {
        setAreasIfNotSet();
        return mpAreas.get(nKey);
    }

    public String getGender(int nEnum)
    {
        int nEnumNum = Enums.Gender.MALE.ordinal();
        switch(nEnum)
        {
            case(0): return "זכר";
            case(1): return "נקבה";
        }

        return "לא ידוע";
    }

    public void setWhereSearch()
    {
        fromWhere = "search";
    }

    public void setWhereSelection()
    {
        fromWhere = "select";
    }

    public String getFromWhere()
    {
        return fromWhere;
    }

    public int getTypeID(String strName)
    {
        for ( Integer nKey : mpTypes.keySet() ) {
            if (mpTypes.get(nKey).equals(strName))
            {
                return nKey.intValue();
            }
        }

        return 0;
    }

    public String getTypeName(int nKey)
    {
        return mpTypes.get(nKey);
    }

    public void setLstChosenPets(List<Pet> lstPet){
        lstChosenPets = lstPet;
    }

    public List<Pet> getLstChosenPets()
    {
        return lstChosenPets;
    }

    public Drawable getImageByAnimalName(Resources src, int nType)
    {
        Drawable d = null;
        switch (nType) {
            case (0): { d = src.getDrawable(R.drawable.dog); break;}
            case (1):{ d = src.getDrawable(R.drawable.cat); break;}
            case (2):{ d = src.getDrawable(R.drawable.turtle); break;}
            case (3):{ d = src.getDrawable(R.drawable.donkey); break;}
            case (4):{ d = src.getDrawable(R.drawable.peacock); break;}
            case (5):{ d = src.getDrawable(R.drawable.turkey); break;}
            case (6):{ d = src.getDrawable(R.drawable.horse); break;}
            case (7):{ d = src.getDrawable(R.drawable.humus); break;}
            default: { d = src.getDrawable(R.drawable.shadow); break; }
        }
        return  d;
    }
}