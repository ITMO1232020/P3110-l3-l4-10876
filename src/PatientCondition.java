public interface PatientCondition {
    void report(Patient patient);
    void compareMood(Patient patient1, Patient patient2);
    void status(Patient patient);
}