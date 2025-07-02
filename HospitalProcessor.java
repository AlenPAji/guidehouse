import java.io.*;
import java.util.*;

public class HospitalProcessor {
    public static void main(String[] args) {
        List<String[]> hospitals = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("hospital.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\|");
                if (parts.length >= 4) {
                    String[] hospitalData = new String[]{
                        parts[0], 
                        parts[1], 
                        parts[2], 
                        parts[3]  
                    };
                    hospitals.add(hospitalData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hospital Names:");
        for (String[] hospital : hospitals) {
            System.out.println(hospital[1]);
        }

        
        for (String[] hospital : hospitals) {
            if (hospital[1].equalsIgnoreCase("Medical College")) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("contact.txt"))) {
                    writer.write(hospital[3]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
