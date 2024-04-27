class Doctor implements Person {
    private String name;
    private int age;
    private String specialization;

    public Doctor(String name, int age, String specialization) {
        this.name = name;
        this.age = age;
        this.specialization = specialization;
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
        return "Doctor: " + name + ", Age: " + age + ", Specialization: " + specialization;
    }
}