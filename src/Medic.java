public class Medic extends Person implements PatientPickUp, PatientCondition, PatientCure{

    Medic() {
        setName("Medical Staff");
    }

    Medic(String name) {
        setName(name);
    }

    Medic(String name, Place place) {
        setName(name);
        setPlace(place);
    }

    @Override
    public String cure(Patient patient, String illness){
        if (patient.removeIllness(illness)) return (patient.getName() + "'s " + illness + " is cured thanks to " + getName() + ".");
        else return "Patient given cure for wrong illness. His condition remains the same.";
    }

    @Override
    public String status(Patient patient){
        if (patient.getHealth() == Health.HEALTHY){
            return (patient.getName() + " is not sick anymore. He can leave the " + Place.HOSPITAL + ".");
        }
        else return (patient.getName() + " is not cured. He should still rest at " + Place.HOSPITAL + ".");
    }

    @Override
    public String compareMood(Patient patient1, Patient patient2){
        int moodDifference = patient1.getMood() - patient2.getMood();
        if (moodDifference == 0){
            return (patient1.getName() + " and " + patient2.getName() + " are in the same mood.");
        }
        else if (moodDifference < 0){
            moodDifference = Math.abs(moodDifference * 10);
            return (patient1.getName() + "'s mood is " + moodDifference + " times worse than " + patient2.getName() + "'s!");
        }
        else {
            moodDifference = moodDifference * 10;
            return (patient1.getName() + "'s mood is " + moodDifference + " times better than " + patient2.getName() + "'s!");
        }
    }

    @Override
    public String pickUp (Patient patient, Place place) {
        if (patient.getHasFallen()) {
            patient.setHasFallen(false);
            return (patient.getName() + " is picked up by " + getName() + " and is carried to " + place + "!");
        }
        else return null;
    }

    @Override
    public String toString() {
        return "Medic{" +
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