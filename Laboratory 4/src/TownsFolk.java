public class TownsFolk extends Person {

    TownsFolk(String name){
        setName(name);
        setPlace(Place.TOWN);
    }

    public String greet (Patient patient){
        return (patient.getName() + " is greeted at hospital's main door by " + getName());
    }

    public String areHappy (Patient patient){
        return (patient.getName() + " is leaving " + Place.HOSPITAL + " and " + getName() + " are happy.");
    }

    public String interrupt (Patient patient){
        return (patient.getName() + " wanted to say something, but was interrupted by " + getName() + ".");
    }

    @Override
    public String toString() {
        return "TownsFolk{"+
                 "name=" + getName() +
                 ", place=" + getPlace()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
