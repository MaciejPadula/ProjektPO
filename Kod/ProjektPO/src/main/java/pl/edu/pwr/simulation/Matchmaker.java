package pl.edu.pwr.simulation;

public class Matchmaker {
    public void match(Person person1, Person person2){
        person1.setPartner(person2);
        person2.setPartner(person1);
    }
}
