package Test;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    private List<Person> personList;

    public PersonManager() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void deletePerson(Person person) {
        personList.remove(person);
    }

    public void updatePerson(Person oldPerson, Person newPerson) {
        int index = personList.indexOf(oldPerson);
        if (index != -1) {
            personList.set(index, newPerson);
        }
    }

    public List<Person> getPersonList() {
        return personList;
    }
}

