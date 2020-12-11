import java.util.ArrayList;
import java.util.Objects;

public class Patient extends Person implements Running, Falling, Resting {
    private int mood;
    private boolean hasFallen = false;
    private Health health;
    private final ArrayList<String> illnesses = new ArrayList<String>();

    public Patient () {
        setName("Unidentified Patient");
    }

    public Patient(String name){
        setName(name);
    }

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
        else
            System.out.println("Mood valued not applied. Please choose number in 1 to 5 span. Each number representing mood value accordingly.");
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

    public void cured (Medic medic, String illness){
        if(illnesses.contains(illness)) {
            illnesses.remove(illness);
            if(illnesses.isEmpty()) health = Health.HEALTHY;
            System.out.println(medic.getName() + " cured " + getName() + "'s " + illness + "!");
        }
    }

    @Override
    public void run (int steps, Place place) {
        System.out.println(getName() + " ran " + steps + " steps in " + place + "!");
    }

    @Override
    public void fell (){
        if (!hasFallen) {
            hasFallen = true;
            System.out.println(getName() + " fell and hurt his leg!");
            addIllness("leg pain");
        }
    }
    
    @Override
    public void rest (Place place, Time time) {
        System.out.println(getName() + " slept in " + place + " at " + time + ".");
        if (place == Place.BED && time == Time.NIGHT && !illnesses.isEmpty()){
            int illnessIndex = (int) Math.floor(Math.random() * illnesses.size());
            System.out.println(getName() + " woke up and lost following illness: " + illnesses.get(illnessIndex) + "!");
            illnesses.remove(illnessIndex);
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
        if (!(o instanceof Patient)) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return mood == patient.mood &&
                hasFallen == patient.hasFallen &&
                health == patient.health &&
                illnesses.equals(patient.illnesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mood, hasFallen, health, illnesses);
    }
}