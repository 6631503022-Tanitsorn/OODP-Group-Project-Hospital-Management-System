import java.io.*;

class Patient implements SerializableEntity {
    private String name;
    private int id;

    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Serialization methods
    @Override
    public void writeToFile(String filename) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(this);
        }
    }

    @Override
    public void readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Patient patient = (Patient) inputStream.readObject();
            this.name = patient.getName();
            this.id = patient.getId();
        }
    }

    // Method to view patient details
    public void viewPatient() {
        System.out.println("Patient Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}