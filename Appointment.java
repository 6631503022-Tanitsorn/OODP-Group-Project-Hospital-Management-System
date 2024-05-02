class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String appointmentType;
  
    public Appointment(Patient patient, Doctor doctor, String appointmentType) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentType = appointmentType;   
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    /* Override, the ability of a subclass to provide a specific implementation of a method
    that is already defined in its superclass */
    @Override
    public String toString() {
        return "Appointment - Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Type: " + appointmentType;
    }
}
