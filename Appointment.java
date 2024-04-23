class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String appointmentType;
    // Additional fields like appointment date, time, status can be added

    public Appointment(Patient patient, Doctor doctor, String appointmentType) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentType = appointmentType;
    }

    // Getters and setters for additional fields can be added as needed

    @Override
    public String toString() {
        return "Appointment - Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Type: " + appointmentType;
    }
}