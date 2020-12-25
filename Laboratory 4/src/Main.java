public class Main {

    public static void main(String[] args) {

        Medic medunitsa = new Medic("Medunitsa");
        Medic medicalStaff = new Medic();
        Patient pulka = new Patient("Pulka",2,"leg pain");
        Patient vorchun = new Patient("Vorchun", 4, Health.SICK);
        Patient pilulkin = new Patient("Pilulkin", 4, Health.HEALTHY);

        System.out.println(vorchun.escape(Place.HOSPITAL));
        System.out.println(pilulkin.escape(Place.HOSPITAL));
        System.out.println(medicalStaff.allAttentionOnPatient(pulka));

        System.out.println(pulka.gainTrait("spoilt"));
        System.out.println(pulka.demands("soup from sweets and porridge from marmalade"));
        System.out.println(pulka.demands("applesauce"));
        System.out.println(medicalStaff.bring(pulka, "applesauce"));
        System.out.println(pulka.pretendDidntWant("applesauce", "pear kvass"));
        System.out.println(medicalStaff.bring(pulka, "pear kvass"));
        System.out.println(pulka.pretendThingStinks("pear kvass", "onions"));

        Nanny nannies = new Nanny("Nannies");
        Nanny nanny1 = new Nanny("Nanny 1");
        Nanny nanny2 = new Nanny("Nanny 2");
        Nanny nanny3 = new Nanny("Nanny 3");

        System.out.println(nannies.tiredOffPatient(pulka, "never had such a patient"));
        System.out.println(nannies.wantsPatientsRecovery(pulka));
        System.out.println(nanny1.sendTo(pulka, "to look for his dog", Time.MORNING));
        System.out.println(nanny1.returnTo(Place.HOSPITAL));
        System.out.println(nanny1.callingDog(pulka));
        System.out.println(nanny2.sendTo(pulka, "to report what are other kids doing", Time.MORNING, Time.LUNCHTIME, Time.EVENING));
        System.out.println(nanny3.forcedTo(pulka, "to read him fairytale", Time.MORNING, Time.NIGHT));
        System.out.println(nanny3.chasedAway(pulka, "doesn't know good fairytale"));
        System.out.println(pulka.demands("new nurse to read him fairytale"));
        ChaseAway chaseAway = new ChaseAway(){
            @Override
            public String chasedAway(Patient patient, String cause) {
                return ("When " + someone.name + " came into room. " + patient.getName() + " chased him away, because " + cause + ".");
            }
            class Someone {
                final String name;
                Someone(String name){
                    this.name = name;
                }
            }
            final Someone someone = new Someone("Someone");
        };
        System.out.println(chaseAway.chasedAway(pulka, "nurse's storytelling was interrupted"));

        System.out.println(medunitsa.compareMood(pulka, vorchun));
        System.out.println(medunitsa.compareMood(pulka, pilulkin));

        System.out.println(pulka.rest(Place.BED, Time.NIGHT));
        System.out.println(pulka.run(10, Place.WARD));
        try {
            System.out.println(pulka.fell());
        } catch (WrongBooleanValueException e) {
            System.out.println(e.getMessage());
        }
        pulka.addIllness("swelling");

        System.out.println(medicalStaff.pickUp(pulka, Place.BED));
        pulka.addIllness("temperature");
        try {
            System.out.println(medunitsa.cure(pulka, "swelling"));
        }catch (IllnessEqualsNullException e){
            System.out.println(e.getMessage());
        }
        System.out.println(pulka.illnessesCheck());
        System.out.println(medunitsa.status(pulka));

        pulka.removeIllness("temperature");
        try {
            System.out.println(pulka.learnedToWalk());
        } catch (WrongBooleanValueException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(pulka.allowedToWalk(1));
        pulka.removeIllness("leg pain");
        System.out.println(pulka.refuseToReturn(Place.ROOM));
        System.out.println(medicalStaff.forceTo(pulka, Place.BED));

        TownsFolk kids = new TownsFolk("Kids");
        TownsFolk everyone = new TownsFolk("Everyone");
        TownsFolk neznaika = new TownsFolk("Neznaika");

        System.out.println(medicalStaff.status(pulka));
        System.out.println(kids.areHappy(pulka));
        System.out.println(everyone.greet(pulka));
        System.out.println(neznaika.interrupt(pulka));

    }
}