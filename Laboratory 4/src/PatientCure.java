public interface PatientCure {
    String cure(Patient patient, String illness) throws IllnessEqualsNullException;
}
