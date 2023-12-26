package edu.yuryan.spring.dao;

import edu.yuryan.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int  peopleCount;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++peopleCount, "John"));
        people.add(new Person(++peopleCount, "Bobby"));
        people.add(new Person(++peopleCount, "Mike"));
        people.add(new Person(++peopleCount, "Suzy"));
    }

    public List<Person> index() {
        return  people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person toBeUpdated = show(id);
        toBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
