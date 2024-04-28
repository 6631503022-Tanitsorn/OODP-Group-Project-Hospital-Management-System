import java.time.LocalDate;
import java.io.Serializable;

class Appointment implements Serializable {
    private Patient patient;
    private Doctor doctor;
    private String appointmentType;
    private LocalDate appointmentDate;
   

    public Appointment(Patient patient, Doctor doctor, String appointmentType, LocalDate appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
    }

    /* Override, the ability of a subclass to provide a specific implementation of a method
    that is already defined in its superclass */
    @Override
    public String toString() {
        return "Appointment - Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Type: " + appointmentType + ", Date: " + appointmentDate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
}