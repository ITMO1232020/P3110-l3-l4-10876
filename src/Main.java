public class Main {

    public static void main(String[] args) {

        Medic medunitsa = new Medic("Medunitsa");
        Medic medicalStaff = new Medic();
        Patient pulka = new Patient("Pulka",2,"leg pain");
        Patient vorchun = new Patient("Vorchun", 4, Health.SICK);
        Patient pilulkin = new Patient("Pilulkin", 4, Health.SICK);

        System.out.println(pulka.illnessesCheck());
        System.out.println(medunitsa.compareMood(pulka, vorchun));
        System.out.println(medunitsa.compareMood(pulka, pilulkin));

        System.out.println(pulka.rest(Place.BED, Time.NIGHT));
        System.out.println(pulka.run(10, Place.WARD));
        System.out.println(pulka.fell());
        pulka.addIllness("swelling");

        System.out.println(medicalStaff.pickUp(pulka, Place.BED));
        pulka.addIllness("temperature");

        System.out.println(medunitsa.cure(pulka, "swelling"));
        System.out.println(pulka.illnessesCheck());
        System.out.println(medunitsa.status(pulka));

    }
}