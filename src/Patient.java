import java.util.ArrayList;
import java.util.Objects;

public class Patient extends Person implements Running, Falling, Resting {
    private int mood;
    private boolean hasFallen = false;
    private Health health;
    private final ArrayList<String> illnesses = new ArrayList<String>();
    
    public Patient(String name, int mood, Health health) {
        setName(name);
        this.mood = mood;
        if(health == Health.SICK) {
            addIllness("Unknown illness");
        }
        else setHealth(Health.HEALTHY);
    }
    public Patient(String name, int mood, String illness) {
        setName(name);
        this.mood = mood;
        addIllness(illness);
    }

    public int getMood() {
        return mood;
    }

    public boolean getHasFallen () {
        return hasFallen;
    }

    public Health getHealth() {
        return health;
    }

    public ArrayList<String> getIllnesses (){
        return illnesses;
    }

    public void setMood(int mood) {
        if (0 < mood && mood <= 5) this.mood = mood;
    }

    public void setHasFallen (boolean hasFallen) {
        this.hasFallen = hasFallen;
    }

    public void setHealth(Health health) {
        if (health == Health.HEALTHY && illnesses.isEmpty()) this.health = health;
        else if (health == Health.SICK && illnesses.isEmpty()) this.health = health;
    }

    protected void addIllness (String illness){
        if (!illnesses.contains(illness)){
            illnesses.add(illness);
        }
        health = Health.SICK;
    }
    
    public String illnessesCheck () {
        return (getName() + " has following illneses: " + getIllnesses()) + ".";
    }
    
    public String cured (Medic medic, String illness){
        if(illnesses.contains(illness)) {
            illnesses.remove(illness);
            if(illnesses.isEmpty()) health = Health.HEALTHY;
            return (medic.getName() + " cured " + getName() + "'s " + illness + "!");
        }
        else return null;
    }

    @Override
    public String run (int steps, Place place) {
        return (getName() + " ran " + steps + " steps in " + place + "!");
    }

    @Override
    public String fell (){
        if (!hasFallen) {
            hasFallen = true;
            addIllness("leg pain");
            return (getName() + " fell and hurt his leg!");
        }
        else return null;
    }

    @Override
    public String rest (Place place, Time time) {
        if (place != Place.BED || time != Time.NIGHT || illnesses.isEmpty()) {
            return (getName() + " slept in " + place + " at " + time + ", and is not feeling better.");
        }
        else {
            int illnessIndex = (int) Math.floor(Math.random() * illnesses.size());
            illnesses.remove(illnessIndex);
            return (getName() + " woke up and is feeling better!");
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name=" + getName() +
                ", place=" + getPlace() +
                ", mood=" + mood +
                ", hasFallen=" + hasFallen +
                ", health=" + health +
                ", illnesses=" + illnesses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return mood == patient.mood &&
                hasFallen == patient.hasFallen &&
                health == patient.health &&
                Objects.equals(illnesses, patient.illnesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mood, hasFallen, health, illnesses);
    }
}