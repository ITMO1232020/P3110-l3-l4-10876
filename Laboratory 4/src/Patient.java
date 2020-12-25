import java.util.ArrayList;
import java.util.Objects;

public class Patient extends Person implements Running, Falling, Resting {
    private int mood;
    private boolean hasFallen = false;
    private Health health;
    private final ArrayList<String> illnesses = new ArrayList<String>();
    private boolean isSpoilt = false;
    private boolean canWalk = true;

    private class Wishes{
        public String wishes (String wish){
            if (isSpoilt) {
                return (getName() + " has an unfulfilled wish (" + wish + "). " + getName() + " demands it!");
            } else return null;
        }
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
    }

    public void setHasFallen (boolean hasFallen) {
        this.hasFallen = hasFallen;
    }

    public void setHealth(Health health) {
        if (health == Health.HEALTHY && illnesses.isEmpty()) this.health = health;
        else if (health == Health.SICK && illnesses.isEmpty()) this.health = health;
    }

    public void addIllness (String illness){
        if (!illnesses.contains(illness)){
            illnesses.add(illness);
        }
        health = Health.SICK;
    }

    public boolean removeIllness (String illness){
        if(illnesses.contains(illness)) {
            illnesses.remove(illness);
            if (illnesses.isEmpty()) health = Health.HEALTHY;
            return true;
        }
        else return false;
    }

    public String illnessesCheck () {
        return (getName() + " has following illnesses: " + getIllnesses()) + ".";
    }

    @Override
    public String run (int steps, Place place) {
        return (getName() + " ran " + steps + " steps in " + place + "!");
    }

    @Override
    public String fell () throws WrongBooleanValueException {
        if(hasFallen) {
            throw new WrongBooleanValueException("Error. Patient is already on the ground!");
        }
        hasFallen = true;
        canWalk = false;
        addIllness("leg pain");
        return (getName() + " fell and hurt his leg! " + getName() + " can't walk!");
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

    public String escape (Place place) {
        if (this.getPlace() == place){
            return (getName() + " escaped " + place + "!");
        }
        else return null;
    }

    public String gainTrait (String trait){
        if (!isSpoilt) {
            isSpoilt=true;
            return (getName() + " became " + trait + ".");
        }
        else return null;
    }

    public String demands (String demand){
        Wishes wish = new Wishes();
        return wish.wishes(demand);
    }

    public String pretendDidntWant (String thing1, String thing2){
        return (getName() + " pretends that wasn't asking for " + thing1 + " but " + thing2 + ".");
    }
    public String pretendThingStinks (String thing1, String thing2){
        return (getName() + " pretends that " + thing1 + " stinks like " + thing2 + ".");
    }

    public String learnedToWalk() throws WrongBooleanValueException {
        if (canWalk) throw new WrongBooleanValueException("Error. Patient already knows how to walk!");
        canWalk = true;
        return (getName() + " is slowly moving, by leaning on the walls and on his crutch. He can walk again!");
    }

    public String allowedToWalk(double hours){
        return (getName() + " is allowed to walk for " + hours + " hours accompanied by nanny." );
    }

    public String refuseToReturn (Place place) {
        return (getName() + " refuses to go to " + place + ".");
    }

    @Override
    public String toString() {
        return "Patient{" +
                "mood=" + mood +
                ", hasFallen=" + hasFallen +
                ", health=" + health +
                ", illnesses=" + illnesses +
                ", isSpoilt=" + isSpoilt +
                ", canWalk=" + canWalk +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return mood == patient.mood &&
                hasFallen == patient.hasFallen &&
                isSpoilt == patient.isSpoilt &&
                canWalk == patient.canWalk &&
                health == patient.health &&
                illnesses.equals(patient.illnesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mood, hasFallen, health, illnesses, isSpoilt, canWalk);
    }
}