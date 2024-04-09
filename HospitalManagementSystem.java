import java.io.*;
import java.util.*;


public class HospitalManagementSystem {
    // Method to display main menu
    public static void displayMenu() {
        System.out.println("Hospital Management System");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patient");
        System.out.println("3. Check Patient");
        System.out.println("4. View Doctor");
        System.out.println("5. Check Doctor");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();
        List<Doctor> doctors = new ArrayList<>();

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add Patient
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    Patient patient = new Patient(patientName, patientId);
                    patients.add(patient);
                    try {
                        patient.writeToFile("patients.txt");
                    } catch (IOException e) {
                        System.err.println("Error writing patient details to file: " + e.getMessage());
                    }
                    System.out.println("Patient added successfully!");
                    break;
                case 2:
                    // View Patient
                    if (patients.isEmpty()) {
                        System.out.println("No patients available!");
                    } else {
                        System.out.println("Enter patient ID to view details: ");
                        int patientIdToView = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        boolean foundPatient = false;
                        for (Patient p : patients) {
                            if (p.getId() == patientIdToView) {
                                p.viewPatient();
                                foundPatient = true;
                                break;
                            }
                        }
                        if (!foundPatient) {
                            System.out.println("Patient not found!");
                        }
                    }
                    break;
                case 3:
                    // Check Patient
                    // This is a placeholder method. You can add more functionality as per your requirement.
                    System.out.println("Checking patient...");
                    break;
                case 4:
                    // View Doctor
                    if (doctors.isEmpty()) {
                        System.out.println("No doctors available!");
                    } else {
                        System.out.println("Enter doctor ID to view details: ");
                        int doctorIdToView = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        boolean foundDoctor = false;
                        for (Doctor d : doctors) {
                            if (d.getId() == doctorIdToView) {
                                d.viewDoctor();
                                foundDoctor = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
