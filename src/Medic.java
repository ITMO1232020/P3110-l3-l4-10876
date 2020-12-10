public class Medic extends Person implements PatientPickUp, PatientCondition{

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

    public void status(Patient patient){
        if (patient.getHealth() == Health.HEALTHY){
            System.out.println(patient.getName() + " is not sick anymore. He can leave the " + Place.HOSPITAL + ".");
        }
        else System.out.println(patient.getName() + " is not cured. He should still rest at " + Place.HOSPITAL + ".");
    }

    public void report (Patient patient) {
        System.out.println(getName() + " made patient's report.");
        System.out.println("Patient " + patient.getName() + " has following illnesses:");
        for (String illness : patient.getIllnesses()){
            System.out.println("- " + illness + ";");
        }
        System.out.println("Patient's health status is: " + patient.getHealth() + "!");
    }
    public void compareMood(Patient patient1, Patient patient2){
        int moodDifference = patient1.getMood() - patient2.getMood();
        if (moodDifference == 0){
            System.out.println(patient1.getName() + " and " + patient2.getName() + " are in the same mood.");
        }
        else if (moodDifference < 0){
            moodDifference = Math.abs(moodDifference * 10);
            System.out.println(patient1.getName() + "'s mood is " + moodDifference + " times worse than " + patient2.getName() + "'s!");
        }
        else {
            moodDifference = moodDifference * 10;
            System.out.println(patient1.getName() + "'s mood is " + moodDifference + " times better than " + patient2.getName() + "'s!");
        }
    }

    public void pickUp (Patient patient, Place place){
        if (patient.getHasFallen()) {
            patient.setHasFallen(false);
            System.out.println(patient.getName() + " is picked up by " + getName()  + " and is carried to " + place + "!");
        }
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