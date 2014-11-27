package geistesblitz.examples;

import java.util.List;

public class ExampleGreeter {
    private int noOfPeople;
    private List<ExamplePerson> people;

    public void peopleInRoom(int noOfPeople) {
        this.noOfPeople = noOfPeople;
        this.people = null;
    }

    public void peopleInRoom(List<ExamplePerson> people) {
        this.people = people;
        this.noOfPeople = people.size();
    }

    public String greet() {
        StringBuffer greeting = new StringBuffer();
        if (noOfPeople >1){
            greeting.append("Hello to all ");
            greeting.append(noOfPeople);
            greeting.append(" of you");
            if (people!=null){
                greeting.append(", ");
            }
        }
        if (people!=null){
            for (ExamplePerson person:people){
                greeting.append("hi ");
                greeting.append(person.getFirstname());
                greeting.append(", ");
            }
            greeting.delete(greeting.length()-2,greeting.length());
        }
        return greeting.toString();
    }
}
