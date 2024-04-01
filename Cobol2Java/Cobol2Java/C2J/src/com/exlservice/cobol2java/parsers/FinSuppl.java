package com.exlservice.cobol2java.parsers;

import com.exlservice.cobol2java.dto.EditResults;
import com.exlservice.cobol2java.dto.PartSuppAddrPO;

import static com.exlservice.cobol2java.constants.Constants.*;
import static com.exlservice.cobol2java.constants.Constants.SUPPLIES_EDIT_PASSED;
import static com.exlservice.cobol2java.util.ValidationUtil.*;

public class FinSuppl {

    public static void wsFinSuppl(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {
        EditResults editResult = edits(partSuppAddrPO, editResults);
        if (!editResults.isSuccessful()) {
            System.out.println(" - Supplies Edit: FAILED, Error: " + editResults.getErrorMessage());
            System.out.println(SUPPLIES_EDIT_FAILED + editResult.getErrorMessage());
            System.out.println(INVALID_VALUE + editResult.getField());
            editResults.setStatus(WS_EDIT_STATUS_N);
        } else {
            editResults.setStatus(EDIT_RESULT_STATUS_Y);
            editResults.setField(EDIT_RESULT_EMPTY_FILED);
            System.out.println(SUPPLIES_EDIT_PASSED);
        }
    }

    // Equivalent of 000-EDITS.
    private static EditResults edits(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {

        if (isEmptyString(SUPPLIER_NAME,partSuppAddrPO.getSupplier().getName(), editResults)) {
            return editResults;
        }

        if (isEmptyString(SUPPLIER_CODE,partSuppAddrPO.getSupplier().getCode(), editResults)) {
            return editResults;
        }

        if (isEmptyString(SUPPLIER_CODE,partSuppAddrPO.getSupplier().getType(), editResults)) {
            return editResults;
        }

        if (checkSupplierPerf(SUPPLIER_PREF,partSuppAddrPO.getSupplier().getPerf(), editResults)) {
            return editResults;
        }

        if (isValidSupplier(SUPPLIER_TYPE,partSuppAddrPO.getSupplier().getType(), editResults)) {
            return editResults;
        }

        if (isValidRating(SUPPLIER_RATING ,partSuppAddrPO.getSupplier().getRating(),editResults)) {
            return editResults;
        }

        if (isValidSupplierStatus(SUPPLIER_STATUS,partSuppAddrPO.getSupplier().getStatus(),editResults)) {
            return editResults;
        }

        if (isValidAddressType(SUPPLIER_STATUS,partSuppAddrPO.getSuppAddLists(),editResults)) {
            return editResults;
        }
        return editResults;
    }
}