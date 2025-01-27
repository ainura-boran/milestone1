package application;

import controllers.PatientController;
import models.Patient;

import java.time.LocalDate;
import java.util.Scanner;

public class PatientApplication {
    private final PatientController controller;
    private final Scanner scanner = new Scanner(System.in);

    public PatientApplication(PatientController controller) {
        this.controller = controller;
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Patient Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Get Patient by ID");
            System.out.println("3. List All Patients");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> getPatientById();
                case 3 -> listAllPatients();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addPatient() {
        System.out.println("\n--- Add Patient ---");

        System.out.print("Enter IIN: ");
        String iin = scanner.nextLine();

        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter Gender (Male/Female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter Nationality: ");
        String nationality = scanner.nextLine();

        System.out.print("Enter Citizenship: ");
        String citizenship = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Blood Group (e.g., A+, O-): ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter Rhesus Factor (+ or -): ");
        String rhesusFactor = scanner.nextLine();

        Patient patient = new Patient(0, iin, fullName, dateOfBirth, gender, nationality, citizenship, address, bloodGroup, rhesusFactor);

        boolean success = controller.addPatient(patient);
        System.out.println(success ? "Patient added successfully!" : "Failed to add patient.");
    }

    private void getPatientById() {
        System.out.println("\n--- Get Patient by ID ---");
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String response = controller.getPatientById(id);
        System.out.println(response);
    }

    private void listAllPatients() {
        System.out.println("\n--- List of Patients ---");
        controller.getAllPatients().forEach(System.out::println);
    }
}
