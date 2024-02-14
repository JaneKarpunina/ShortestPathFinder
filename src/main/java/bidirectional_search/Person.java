package bidirectional_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    Integer id;

    public Person(Integer id) {
       this.id = id;
    }

    List<Person> friends = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(friends, person.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, friends);
    }
}
