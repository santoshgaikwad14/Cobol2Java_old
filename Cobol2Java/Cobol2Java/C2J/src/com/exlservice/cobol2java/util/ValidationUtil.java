package com.exlservice.cobol2java.util;

import com.exlservice.cobol2java.dto.EditResults;
import com.exlservice.cobol2java.dto.SuppAdd;

import java.util.List;

import static com.exlservice.cobol2java.constants.Constants.*;
import static com.exlservice.cobol2java.constants.Constants.WS_EDIT_STATUS_N;

public class ValidationUtil {

    public static boolean isEmptyString(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if (EMPTY_STRING.equals(fieldValue)) {
            updateEditResults(fieldName, fieldValue, String.format(IS_REQUIRED_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if (fieldValue.isEmpty()) {
            updateEditResults(fieldName, fieldValue, String.format(IS_REQUIRED_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }

    public static boolean checkVehicleYear(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if (!CommonUtil.isInteger(fieldValue) || fieldValue.equals("0")) {
            updateEditResults(fieldName, fieldValue, String.format(IS_REQUIRED_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }

    public static boolean checkVehicleMake(String fieldName, String fieldValue, EditResults editResults) {
        // Equivalent of IF VEHICLE-MAKE = SPACES
        if (isEmpty(VEHICLE_MAKE, fieldValue,editResults)) {
            return true;
        }
        if ( !(VehicleUtil.VEHICLE_MAKE_LIST.contains(fieldValue))) {
            // Equivalent of MOVE VEHICLE-MAKE TO WS-EDIT-FIELD
            updateEditResults(fieldName, fieldValue, String.format(IS_NOT_VALID_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }


    public static boolean isVehicleYearValid(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if (!CommonUtil.isInteger(fieldValue) || fieldValue.equals("0")) {
            updateEditResults(fieldName, fieldValue, String.format(IS_REQUIRED_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        if (!CommonUtil.isVehicleYearValid(fieldValue)) {
            // Equivalent of MOVE VEHICLE-YEAR TO WS-EDIT-FIELD
            updateEditResults(fieldName, fieldValue, String.format(IS_NOT_VALID_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }

    public static boolean isWeeksLeadTimeValid(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if(!CommonUtil.isWeeksLeadTimeValid(fieldValue)) {
            // Equivalent of MOVE WEEKS-LEAD-TIME TO WS-EDIT-FIELD
            updateEditResults(fieldName, fieldValue, String.format(IS_NOT_VALID_ERROR,fieldName), editResults);
            return true;
        }
        return false;
    }

    public static void updateEditResults(String fieldName, String fieldValue, String errorMsg, EditResults editResults) {
        editResults.setField(fieldValue);
        // Equivalent of MOVE TO WS-EDIT-ERROR-MESSAGE
        editResults.setErrorMessage(String.format(errorMsg,fieldName));
        // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
        editResults.setStatus(WS_EDIT_STATUS_N);
        editResults.setSuccessful(false);
    }

    public static boolean checkSupplierPerf(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if (!CommonUtil.isDouble(fieldValue) || fieldValue.equals("0")) {
            // Equivalent of MOVE VEHICLE-MAKE TO WS-EDIT-FIELD
            updateEditResults(fieldName, fieldValue, String.format(IS_NOT_VALID_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }

    public static boolean isValidSupplier(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if (EMPTY_STRING.equals(fieldValue)) {
            updateEditResults(fieldName, fieldValue, String.format(IS_REQUIRED_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        if ( !(SupplierUtil.isValidSupplier(fieldValue))) {
            updateEditResults(fieldName, fieldValue, String.format(IS_NOT_VALID_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }

    public static boolean isValidRating(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if ( !(SupplierUtil.isValidRating(fieldValue))) {
            updateEditResults(fieldName, fieldValue, String.format(IS_NOT_VALID_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }

    public static boolean isValidSupplierStatus(String fieldName, String fieldValue, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + fieldValue);
        if (!SupplierUtil.isValidSupplierStatus(fieldValue)) {
            updateEditResults(fieldName, fieldValue, String.format(IS_NOT_VALID_ERROR,fieldName), editResults);
            // Equivalent of EXIT PARAGRAPH
            return true;
        }
        return false;
    }

    public static boolean isValidAddressType(String fieldName, List<SuppAdd> suppAdd, EditResults editResults) {
        System.out.println(String.format(VALIDATING_PARTS,fieldName) + suppAdd);
        for (int indx = 0; indx < 3; indx++) {
            if (!SupplierUtil.isValidAddressType(suppAdd.get(indx).getType())) {
                updateEditResults(fieldName, suppAdd.get(indx).getType(), String.format(IS_NOT_VALID_ERROR,fieldName), editResults);
                return true;
            }
        }
        return false;
    }

}
