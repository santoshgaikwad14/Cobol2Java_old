package main.dto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AbendRec{
    public static void main(String[] args) {
        String ABEND_REC = "ABEND PARA: ";
        String PARA_NAME;
        String ABEND_REASON;
        String EXPECTED_VAL;
        String ACTUAL_VAL;
        String VALUE_3;
        String ONE_VAL;
        String ZERO_VAL;

        try (BufferedReader br = new BufferedReader(new FileReader("abend.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                PARA_NAME = line.substring(12, 32);
                ABEND_REASON = line.substring(32, 72);
                EXPECTED_VAL = line.substring(72, 78);
                ACTUAL_VAL = line.substring(86, 92);
                VALUE_3 = line.substring(100, 106);
                ONE_VAL = line.substring(114, 115);
                ZERO_VAL = line.substring(124, 125);

                // Process the ABEND record
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}