package com.exlservice.cobol2java.parsers;

import com.exlservice.cobol2java.dto.EditResults;
import com.exlservice.cobol2java.dto.PartSuppAddrPO;

import static com.exlservice.cobol2java.constants.Constants.*;
import static com.exlservice.cobol2java.util.ValidationUtil.isEmpty;
import static com.exlservice.cobol2java.util.ValidationUtil.checkVehicleYear;
import static com.exlservice.cobol2java.util.ValidationUtil.checkVehicleMake;
import static com.exlservice.cobol2java.util.ValidationUtil.isVehicleYearValid;
import static com.exlservice.cobol2java.util.ValidationUtil.isWeeksLeadTimeValid;

public class FinParts {

    public static void wsFinParts(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {
        EditResults editResult = edits(partSuppAddrPO, editResults);

        if (!editResult.isSuccessful()) {
            System.out.println(PARTS_EDIT_FAILED + editResult.getErrorMessage());
            System.out.println(INVALID_VALUE + editResult.getField());
            editResults.setStatus(WS_EDIT_STATUS_N);
        } else {
            editResults.setStatus(EDIT_RESULT_STATUS_Y);
            editResults.setField(EDIT_RESULT_EMPTY_FILED);
            System.out.println(PARTS_EDIT_PASSED);
        }
    }

    private static EditResults edits(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {
        // Equivalent of 000-EDITS.
        
        // Equivalent of IF PART-NUMBER = SPACES
        if (isEmpty(PART_NUMBER,partSuppAddrPO.getParts().getPartNumber(),editResults)) {
            return editResults;
        }

        // Equivalent of IF PART-NAME = SPACES
        if (isEmpty(PART_NAME,partSuppAddrPO.getParts().getPartName(),editResults)) {
            return editResults;
        }
        
        // Equivalent of IF VEHICLE-MAKE = SPACES
        if (isEmpty(VEHICLE_MAKE, partSuppAddrPO.getParts().getVehicleMake(),editResults)) {
            return editResults;
        }
        
        // Equivalent of IF VEHICLE-MODEL = SPACES
        if (isEmpty(VEHICLE_MODEL,partSuppAddrPO.getParts().getVehicleModel(),editResults)) {
            return editResults;
        }
        
        // Equivalent of IF VEHICLE-YEAR IS NOT NUMERIC OR VEHICLE-YEAR = 0
        if (checkVehicleYear(VEHICLE_YEAR,partSuppAddrPO.getParts().getVehicleYear(),editResults)) {
            return editResults;
        }
        
        // Equivalent of IF NOT (CHRYSLER OR FORD OR GM OR VOLKSWAGON OR TOYOTA OR JAGUAR OR PEUGEOT OR BMW)
        if (checkVehicleMake(VEHICLE_MAKE,partSuppAddrPO.getParts().getVehicleMake(),editResults)) {
            return editResults;
        }

        // Equivalent of IF NOT VEHICLE-YEAR-OK
        if (isVehicleYearValid(VEHICLE_YEAR,partSuppAddrPO.getParts().getVehicleYear(),editResults)) {
            return editResults;
        }
        
        // Equivalent of IF NOT WEEKS-LEAD-TIME-OK
        if (isWeeksLeadTimeValid(WEEKS_LEAD_TIME,partSuppAddrPO.getParts().getWeekLeadTime(),editResults)) {
            return editResults;
        }
        return editResults;
        // Continue with the rest of the code...
    }

}