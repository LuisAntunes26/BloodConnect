package pt.ipbeja.twdm.pdm2.bloodconnect.Data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static SharedPreferences sharedPreferences;
    private static String BLOOD_TYPE = "bloodType";

    private SharedPreferencesManager(){}

    private static SharedPreferences getSharedPreferences(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("sessionPreferences",Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void saveBloodType(Context context, String bloodType){
        getSharedPreferences(context).edit().putString(BLOOD_TYPE, bloodType).apply();
    }

    public static String getBloodType(Context context){
        return getSharedPreferences(context).getString(BLOOD_TYPE, null);
    }

    public static void getFireBaseId(Context context){

    }
}
