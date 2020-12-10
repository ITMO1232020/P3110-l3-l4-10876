public class Main {

    public static void main(String[] args) {

        Medic Medunitsa = new Medic("Medunitsa");
        Medic MedicalStaff = new Medic();
        Patient Pulka = new Patient("Pulka",2,"Leg pain");
        Patient Vorchun = new Patient("Vorchun", 4, Health.SICK);
        Patient Pilulkin = new Patient("Pilulkin", 4, Health.SICK);
        Vorchun.setHealth(Health.HEALTHY);
        Medunitsa.report(Pulka);
        Medunitsa.compareMood(Pulka, Vorchun);
        Medunitsa.compareMood(Pulka, Pilulkin);

        Pulka.rest(Place.BED, Time.NIGHT);
        Pulka.rest(Place.BED, Time.DAY);
        Pulka.run(10, Place.WARD);
        Pulka.fell();
        Pulka.addIllness("swelling");

        MedicalStaff.pickUp(Pulka, Place.BED);
        Pulka.addIllness("temperature");

        Medunitsa.report(Pulka);
        Pulka.cured(Medunitsa, "swelling");
        Medunitsa.status(Pulka);

    }
}