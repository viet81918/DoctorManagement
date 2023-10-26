
package Controller;

import Model.Doctor;
import View.Validation;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DoctorHash {
    public static Scanner sc = new Scanner(System.in);
      private Map<String, Doctor> doctorDatabase;
     
    public DoctorHash() {
        doctorDatabase = new HashMap<>();
    }
    public Doctor createDoctor(){
        System.out.print("Enter Doctor Code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();
                    System.out.print("Enter Availability: ");
                    int availability = Validation.checkInputInt();
                    Doctor doctor = new Doctor(code, name, specialization, availability);
                    return doctor;
    }
    
    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("Data does not exist");
        }

        String code = doctor.getCode();
        if (code == null) {
            throw new Exception("Code cannot be null");
        }

        if (doctorDatabase.containsKey(code)) {
            throw new Exception("Doctor code " + code + " is duplicate");
        }

        // Check for valid availability
        if (doctor.getAvailable() < 0) {
            throw new Exception("Availability must be greater than or equal to 0");
        }

        doctorDatabase.put(code, doctor);
        System.out.print("Add successfully!");
        return true;
    }

    public boolean updateDoctor(Doctor updatedDoctor) throws Exception {
        if (updatedDoctor == null) {
            throw new Exception("Data does not exist");
        }

        String code = updatedDoctor.getCode();
        if (code == null) {
            throw new Exception("Code cannot be null");
        }

        if (!doctorDatabase.containsKey(code)) {
            doctorDatabase.put(code, updatedDoctor);
            System.out.print("Add successfully!");
            throw new Exception("Doctor code " + code + " does not exist");
        }

        // Check for valid availability
        if (updatedDoctor.getAvailable() < 0) {
            throw new Exception("Availability must be greater than or equal to 0");
        }

        doctorDatabase.put(code, updatedDoctor);
        System.out.print("Update successfully!");
        return true;
    }

    public boolean deleteDoctor(String code) throws Exception {
        if (code == null) {
            throw new Exception("Code cannot be null");
        }

        if (!doctorDatabase.containsKey(code)) {
            throw new Exception("Doctor code " + code + " does not exist");
        }

        doctorDatabase.remove(code);
          System.out.print("Remove successfully!");
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        if (input == null) {
            throw new Exception("Search input cannot be null");
        }

        HashMap<String, Doctor> searchResults = new HashMap<>();
        for (Map.Entry<String, Doctor> entry : doctorDatabase.entrySet()) {
            Doctor doctor = entry.getValue();
            if (doctor.getName().toLowerCase().contains(input.toLowerCase())
             ) {
                searchResults.put(entry.getKey(), doctor);
            }
        }
        return searchResults;
        
    }
}


