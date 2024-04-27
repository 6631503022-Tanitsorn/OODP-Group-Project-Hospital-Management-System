public class Patient implements Person {
    private String name;
    private int age;
    private String patientID;

    public Patient(String name, int age, String patientID) {
        this.name = name;
        this.age = age;
        this.patientID = patientID;
    }

    //assume that each patient has a unique ID :-)
    public String getPatientID() {
        return patientID;
    }

    /* Note: Override, the ability of a subclass to provide a specific implementation of a method
    that is already defined in its superclass */
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