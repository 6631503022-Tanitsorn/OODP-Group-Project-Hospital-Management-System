class Doctor extends HospitalStaff {
    private String specialization;

    public Doctor(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    // Getter and setter for specialization
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Polymorphism: Override toString method to print doctor details
    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", specialization='" + specialization + '\'' +
                '}';
    }

    // Method to view doctor details
    public void viewDoctor() {
        System.out.println("Doctor Details:");
        System.out.println(this);
    }
}