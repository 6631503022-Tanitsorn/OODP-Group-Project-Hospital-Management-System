import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class HospitalManagementSystem {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        loadDataFromFile(); // Load data from file
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHospital Management System Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Make Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addDoctor(scanner);
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    makeAppointment(scanner);
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    saveDataToFile(); // Save data to file
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 7.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice! Please enter a valid number from 1 to 7.");
            scanner.nextLine(); // Consume newline to clear the invalid input

        }
        }

    }

    private static void addPatient(Scanner scanner) {
        System.out.println("\nEnter patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Patient ID: ");
        String patientID = scanner.nextLine();

        Patient patient = new Patient(name, age, patientID);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    private static void viewPatients() {
        System.out.println("\nPatients in the system:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void addDoctor(Scanner scanner) {
        System.out.println("\nEnter doctor details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(name, age, specialization);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void viewDoctors() {
        System.out.println("\nDoctors in the system:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void makeAppointment(Scanner scanner) {
        System.out.println("\nMake Appointment:");
        System.out.println("Select Patient:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
        }
        System.out.print("Enter patient number: ");
        int patientIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Patient patient = patients.get(patientIndex - 1);

        System.out.println("Select Doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i));
        }
        System.out.print("Enter doctor number: ");
        int doctorIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Doctor doctor = doctors.get(doctorIndex - 1);

        System.out.print("Enter appointment type: ");
        String appointmentType = scanner.nextLine();

        Appointment appointment = new Appointment(patient, doctor, appointmentType);
        appointments.add(appointment);
        System.out.println("Appointment made successfully!");
    }

    private static void viewAppointments() {
        System.out.println("\nAppointments in the system:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static void loadDataFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.bin"))) {
            patients = (ArrayList<Patient>) inputStream.readObject();
            doctors = (ArrayList<Doctor>) inputStream.readObject();
            appointments = (ArrayList<Appointment>) inputStream.readObject();
            System.out.println("Data loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            outputStream.writeObject(patients);
            outputStream.writeObject(doctors);
            outputStream.writeObject(appointments);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }
}