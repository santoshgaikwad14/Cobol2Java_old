package main;

import main.dto.EditResults;
import main.dto.PartSuppAddrPO;

public class FINPARTS {

    public static void WS_FINPARTS(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {

        
        // Equivalent of PROCEDURE DIVISION USING PART-SUPP-ADDR-PO, WS-EDIT-RESULTS.
        // No need to pass parameters in Java, as we can directly access them
        
        // Equivalent of MOVE 'Y' TO WS-EDIT-STATUS
        editResults.setWS_EDIT_STATUS("Y");
        
        // Equivalent of DISPLAY 'Validating Parts:' PART-NUMBER
        System.out.println("Validating Parts: " + partSuppAddrPO.getParts().getPART_NUMBER());
        
        // Equivalent of PERFORM 000-EDITS
        edits(partSuppAddrPO, editResults);
        
        // Equivalent of GOBACK
        // No need to explicitly return control to MAIN in Java
        
    }
    
    private static void edits(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {
        // Equivalent of 000-EDITS.
        
        // Equivalent of IF PART-NUMBER = SPACES
        if (partSuppAddrPO.getParts().getPART_NUMBER().isEmpty()) {
            // Equivalent of MOVE ' PART-NUMBER IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
            editResults.setWS_EDIT_ERROR_MESSAGE("PART-NUMBER IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF PART-NAME = SPACES
        if (partSuppAddrPO.getParts().getPART_NAME().isEmpty()) {
            // Equivalent of MOVE ' PART-NAME IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE

            editResults.setWS_EDIT_ERROR_MESSAGE("PART-NAME IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF VEHICLE-MAKE = SPACES
        if (partSuppAddrPO.getParts().getVEHICLE_MAKE().isEmpty()) {
            // Equivalent of MOVE ' VEHICLE-MAKE IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE

            editResults.setWS_EDIT_ERROR_MESSAGE("VEHICLE-MAKE IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF VEHICLE-MODEL = SPACES
        if (partSuppAddrPO.getParts().getVEHICLE_MODEL().isEmpty()) {
            // Equivalent of MOVE ' VEHICLE-MODEL IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
            editResults.setWS_EDIT_ERROR_MESSAGE("VEHICLE-MODEL IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF VEHICLE-YEAR IS NOT NUMERIC OR VEHICLE-YEAR = 0
        if (!isNumeric(partSuppAddrPO.getParts().getVEHICLE_YEAR()) || partSuppAddrPO.getParts().getVEHICLE_YEAR().equals("0")) {
            // Equivalent of MOVE ' VEHICLE-YEAR IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
            editResults.setWS_EDIT_ERROR_MESSAGE("VEHICLE-YEAR IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF NOT (CHRYSLER OR FORD OR GM OR VOLKSWAGON OR TOYOTA OR JAGUAR OR PEUGEOT OR BMW)
        if (!(partSuppAddrPO.getParts().VEHICLE_MAKE_LIST.contains(partSuppAddrPO.getParts().getVEHICLE_MAKE()))) {
            // Equivalent of MOVE VEHICLE-MAKE TO WS-EDIT-FIELD
            editResults.setWS_EDIT_FIELD(partSuppAddrPO.getParts().getVEHICLE_MAKE());

            // Equivalent of MOVE ' VEHICLE-MAKE IS not valid.' TO WS-EDIT-ERROR-MESSAGE
            editResults.setWS_EDIT_ERROR_MESSAGE("VEHICLE-MAKE IS not valid.");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF NOT VEHICLE-YEAR-OK
        if (!isVehicleYearValid(partSuppAddrPO.getParts().getVEHICLE_YEAR())) {
            // Equivalent of MOVE VEHICLE-YEAR TO WS-EDIT-FIELD
            editResults.setWS_EDIT_FIELD(partSuppAddrPO.getParts().getVEHICLE_YEAR());
            
            // Equivalent of MOVE ' VEHICLE-YEAR IS not valid.' TO WS-EDIT-ERROR-MESSAGE
            editResults.setWS_EDIT_ERROR_MESSAGE("VEHICLE-YEAR IS not valid.");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF NOT WEEKS-LEAD-TIME-OK
        if (!isWeeksLeadTimeValid(partSuppAddrPO.getParts().getWEEKS_LEAD_TIME())) {
            // Equivalent of MOVE WEEKS-LEAD-TIME TO WS-EDIT-FIELD
            editResults.setWS_EDIT_FIELD(partSuppAddrPO.getParts().getWEEKS_LEAD_TIME());
            
            // Equivalent of MOVE ' WEEKS-LEAD-TIME IS not valid.' TO WS-EDIT-ERROR-MESSAGE
            editResults.setWS_EDIT_ERROR_MESSAGE("WEEKS-LEAD-TIME IS not valid.");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Continue with the rest of the code...
    }
    
    private static boolean isNumeric(String str) {
        // Check if a string is numeric
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static boolean isVehicleYearValid(String year) {
        // Check if a vehicle year is valid
//        System.out.println(year);
        int yearInt = Integer.parseInt(year);
        if (yearInt >=1900 && yearInt<=2019){
            return true;
        }
        else{
            return false;
        }
//        return yearInt >= 1900 && yearInt <= 2019;
    }
    
    private static boolean isWeeksLeadTimeValid(String weeks) {
        // Check if weeks lead time is valid
        int weeksInt = Integer.parseInt(weeks);
        return weeksInt >= 1 && weeksInt <= 4;
    }

}