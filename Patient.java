public class Patient implements Person {
    private String name;
    private int age;
    private String patientID;

    public Patient(String name, int age, String patientID) {
        this.name = name;
        this.age = age;
        this.patientID = patientID;
    }

    public String getPatientID() {
        return patientID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient: " + name + ", Age: " + age + ", ID: " + patientID;
    }
}