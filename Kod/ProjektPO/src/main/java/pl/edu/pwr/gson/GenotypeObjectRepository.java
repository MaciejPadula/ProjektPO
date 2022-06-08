package pl.edu.pwr.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.edu.pwr.simulation.Person;

import java.util.ArrayList;
import java.util.List;

public class GenotypeObjectRepository {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private List<GenotypeJsonObject> repository = new ArrayList<>();
    public void loadRepository(List<Person> personList){
        for (Person person: personList
             ) {
            repository.add(new GenotypeJsonObject(person));
        }
    }
    public String getJsonString(){
        return gson.toJson(this.repository);
    }
}
