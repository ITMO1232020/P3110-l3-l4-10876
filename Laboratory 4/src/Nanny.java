public class Nanny extends Medic implements ChaseAway{

    public Nanny (String name){
        setName(name);
    }

    public String tiredOffPatient (Patient patient, String cause){
        return (getName() + " are tired of " + patient.getName() + " because " + cause + ".");
    }

    public String wantsPatientsRecovery(Patient patient){
        return (getName() + " want " + patient.getName() + " to recover as fast as possible.");
    }

    public String sendTo (Patient patient, String task, Time time){
        return (patient.getName() + " send " + getName() + " " + task + " in the " + time + ".");
    }

    public String sendTo (Patient patient, String task, Time time1, Time time2, Time time3){
        return (patient.getName() + " send " + getName() + " " + task + " in the " + time1 + ", " + time2 + " and " + time3 + ".");
    }

    public String returnTo (Place place){
        return (getName() + " returned to " + place + ".");
    }

    public String callingDog (Patient patient){
        return (getName() + " is calling " + patient.getName() + "'s dog.");
    }

    public String forcedTo (Patient patient, String task, Time time1, Time time2){
        return (patient.getName() + " forced " + getName() + " " + task + " from " + time1 + " till " + time2 + ".");
    }

    @Override
    public String chasedAway (Patient patient, String cause){
        return (patient.getName() + " chased away " + getName() + " because she " + cause + "." );
    }

    @Override
    public String toString() {
        return "Nanny{" +
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
