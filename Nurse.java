class Nurse extends HospitalStaff {
    private int experienceYears;

    public Nurse(String name, int id, int experienceYears) {
        super(name, id);
        this.experienceYears = experienceYears;
    }

    // Getter and setter for experienceYears
    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    // Polymorphism: Override toString method to print nurse details
    @Override
    public String toString() {
        return "Nurse{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", experienceYears=" + experienceYears +
                '}';
    }

    // Method to view nurse details
    public void viewNurse() {
        System.out.println("Nurse Details:");
        System.out.println(this);
    }
}