import java.io.*;

interface SerializableEntity {
    void writeToFile(String filename) throws IOException;
    void readFromFile(String filename) throws IOException, ClassNotFoundException;
}

// Exception class for handling errors in hospital management system
class HospitalManagementException extends Exception {
    public HospitalManagementException(String message) {
        super(message);
    }
}