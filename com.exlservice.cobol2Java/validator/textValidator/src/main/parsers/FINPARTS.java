package main.parsers;

import main.dto.EditResults;
import main.dto.PartSuppAddrPO;
import main.utils.CommonUtil;
import main.utils.VehicleUtil;

public class FINPARTS {

    public static void WS_FINPARTS(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {

        
        // Equivalent of PROCEDURE DIVISION USING PART-SUPP-ADDR-PO, WS-EDIT-RESULTS.
        // No need to pass parameters in Java, as we can directly access them
        
        // Equivalent of MOVE 'Y' TO WS-EDIT-STATUS
        editResults.setStatus("Y");
        
        // Equivalent of DISPLAY 'Validating Parts:' PART-NUMBER
        System.out.println("Validating Parts: " + partSuppAddrPO.getParts().getPartNumber());
        
        // Equivalent of PERFORM 000-EDITS
        edits(partSuppAddrPO, editResults);
        
        // Equivalent of GOBACK
        // No need to explicitly return control to MAIN in Java
        
    }
    
    private static void edits(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {
        // Equivalent of 000-EDITS.
        
        // Equivalent of IF PART-NUMBER = SPACES
        if (partSuppAddrPO.getParts().getPartNumber().isEmpty()) {
            // Equivalent of MOVE ' PART-NUMBER IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
            editResults.setErrorMessage("PART-NUMBER IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setStatus("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF PART-NAME = SPACES
        if (partSuppAddrPO.getParts().getPartName().isEmpty()) {
            // Equivalent of MOVE ' PART-NAME IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE

            editResults.setErrorMessage("PART-NAME IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setStatus("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF VEHICLE-MAKE = SPACES
        if (partSuppAddrPO.getParts().getVehicleMake().isEmpty()) {
            // Equivalent of MOVE ' VEHICLE-MAKE IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE

            editResults.setErrorMessage("VEHICLE-MAKE IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setStatus("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF VEHICLE-MODEL = SPACES
        if (partSuppAddrPO.getParts().getVehicleModel().isEmpty()) {
            // Equivalent of MOVE ' VEHICLE-MODEL IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
            editResults.setErrorMessage("VEHICLE-MODEL IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setStatus("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF VEHICLE-YEAR IS NOT NUMERIC OR VEHICLE-YEAR = 0
        if (!CommonUtil.isInteger(partSuppAddrPO.getParts().getVehicleYear()) || partSuppAddrPO.getParts().getVehicleYear().equals("0")) {
            // Equivalent of MOVE ' VEHICLE-YEAR IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
            editResults.setErrorMessage("VEHICLE-YEAR IS REQUIRED");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setStatus("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF NOT (CHRYSLER OR FORD OR GM OR VOLKSWAGON OR TOYOTA OR JAGUAR OR PEUGEOT OR BMW)
        if (!(VehicleUtil.VEHICLE_MAKE_LIST.contains(partSuppAddrPO.getParts().getVehicleMake()))) {
            // Equivalent of MOVE VEHICLE-MAKE TO WS-EDIT-FIELD
            editResults.setStatus(partSuppAddrPO.getParts().getVehicleMake());

            // Equivalent of MOVE ' VEHICLE-MAKE IS not valid.' TO WS-EDIT-ERROR-MESSAGE
            editResults.setErrorMessage("VEHICLE-MAKE IS not valid.");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setStatus("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF NOT VEHICLE-YEAR-OK
        if (!CommonUtil.isVehicleYearValid(partSuppAddrPO.getParts().getVehicleYear())) {
            // Equivalent of MOVE VEHICLE-YEAR TO WS-EDIT-FIELD
            editResults.setField(partSuppAddrPO.getParts().getVehicleYear());
            
            // Equivalent of MOVE ' VEHICLE-YEAR IS not valid.' TO WS-EDIT-ERROR-MESSAGE
            editResults.setErrorMessage("VEHICLE-YEAR IS not valid.");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setStatus("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Equivalent of IF NOT WEEKS-LEAD-TIME-OK
        if (!CommonUtil.isWeeksLeadTimeValid(partSuppAddrPO.getParts().getWeekLeadTime())) {
            // Equivalent of MOVE WEEKS-LEAD-TIME TO WS-EDIT-FIELD
            editResults.setField(partSuppAddrPO.getParts().getWeekLeadTime());
            
            // Equivalent of MOVE ' WEEKS-LEAD-TIME IS not valid.' TO WS-EDIT-ERROR-MESSAGE
            editResults.setErrorMessage("WEEKS-LEAD-TIME IS not valid.");
            
            // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
            editResults.setStatus("N");
            
            // Equivalent of EXIT PARAGRAPH
            return;
        }
        
        // Continue with the rest of the code...
    }

}