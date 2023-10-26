package View;

import Controller.DoctorHash;
import Model.Doctor;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hospital extends Menu<String> {

    public static Scanner sc = new Scanner(System.in);
    static String[] mc = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor.", "Exit"};
    protected DoctorHash managers;
   
    public Hospital() {
        super("MENU", mc);
       
    }

    public void execute(String n) {
        switch (n) {
            case "1" -> {
                try {
                    managers.addDoctor(managers.createDoctor());
                } catch (Exception ex) {
                    Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "2" -> {
                try {
                    managers.updateDoctor(managers.createDoctor());
                } catch (Exception ex) {
                    Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "3" -> {
                System.out.println("Input Name to delete");
                String input = sc.nextLine();
                try {
                    managers.deleteDoctor(input);
                } catch (Exception ex) {
                    Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "4" -> {
                System.out.println("Input code to search");
                String input = sc.nextLine();
                try {

                    HashMap<String, Doctor> hashMap = managers.searchDoctor(input);
                    for (HashMap.Entry<String, Doctor> entry : hashMap.entrySet()) {
                        Doctor value = entry.getValue();
                        System.out.println(value.toString());
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "5" ->
                System.exit(0);
             default -> System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    
}
