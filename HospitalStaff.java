import java.io.*;

class HospitalStaff implements SerializableEntity {
    protected String name;
    protected int id;

    public HospitalStaff(String name, int id) {
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
            HospitalStaff staff = (HospitalStaff) inputStream.readObject();
            this.name = staff.getName();
            this.id = staff.getId();
        }
    }
}
