package pl.edu.pwr.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.edu.pwr.simulation.agents.Person;

import java.util.ArrayList;
import java.util.List;

public class GenotypeObjectToJsonStringConverter {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String getJsonString(List<Person> personList){
        List<GenotypeJsonObject> genotypeJsonObjectList = new ArrayList<>();
        for (Person person: personList) {
            genotypeJsonObjectList.add(new GenotypeJsonObject(person));
        }
        return gson.toJson(genotypeJsonObjectList);
    }
}
