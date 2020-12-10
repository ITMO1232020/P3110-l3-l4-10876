import java.util.Objects;

abstract public class Person {
    private String name;
    private Place place = Place.HOSPITAL;

    public String getName() {
        return name;
    }

    public Place getPlace() {
        return place;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                place == person.place;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place);
    }
}
