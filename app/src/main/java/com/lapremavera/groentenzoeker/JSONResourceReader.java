package com.lapremavera.groentenzoeker;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lapremavera.Groente;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONResourceReader {

    private String jsonString;
    private static final String LOGTAG = JSONResourceReader.class.getSimpleName();

    List<Groente> groenteLijst;



    public  JSONResourceReader(Resources resources, int id) {
        InputStream resourceReader = resources.openRawResource(id);
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e);
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e);
            }
        }
        jsonString = writer.toString();

    }
    public List<Groente> constructUsingGson(){
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Groente>>(){}.getType();
        List<Groente> groenteLijst = gson.fromJson(jsonString,listType );

        for (int i=0; i < groenteLijst.size(); i++){
            Groente groente =groenteLijst.get(i);
            groente.setId(i+1);
            if (groente.getUrlAfbeelding().trim() != ""){
                groente.setUrlAfbeelding("http:" +groente.getUrlAfbeelding());
            }
            else {
                groente.setUrlAfbeelding("");
            }

        }
        return groenteLijst;
    }

}
