public interface PatientCondition {
    String compareMood(Patient patient1, Patient patient2);
    String status(Patient patient);
}