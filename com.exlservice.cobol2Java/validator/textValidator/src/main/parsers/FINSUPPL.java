package main.parsers;

import main.dto.EditResults;
import main.dto.PartSuppAddrPO;
import main.utils.CommonUtil;
import main.utils.SupplierUtil;

public class FINSUPPL {
        public static void WS_FINSUPPL(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {

        // Equivalent of PROCEDURE DIVISION USING PART-SUPP-ADDR-PO, WS-EDIT-RESULTS.

            // Equivalent of MOVE 'Y' TO WS-EDIT-STATUS
            editResults.setStatus("Y");

            // Equivalent of DISPLAY 'Validating Supplier:' PART-NUMBER
            System.out.println("Validating Supplier: " + partSuppAddrPO.getSupplier().getName());

            // Equivalent of PERFORM 000-EDITS
            edits(partSuppAddrPO, editResults);

            // Equivalent of GOBACK
            return;

    }
        // Equivalent of 000-EDITS.
        private static void edits(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {
            // Equivalent of IF SUPPLIER-CODE = SPACES
            if (partSuppAddrPO.getSupplier().getCode().equals(" ")) {
                // Equivalent of MOVE ' SUPPLIER-CODE IS REQUIRED ' TO WS-EDIT-ERROR-MESSAGE
                editResults.setErrorMessage(" SUPPLIER-CODE IS REQUIRED ");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setStatus("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF SUPPLIER-TYPE = SPACES
            if (partSuppAddrPO.getSupplier().getType().equals(" ")) {
                // Equivalent of MOVE ' SUPPLIER-TYPE IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
                editResults.setErrorMessage(" SUPPLIER-TYPE IS REQUIRED");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setStatus("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF SUPPLIER-NAME = SPACES
            if (partSuppAddrPO.getSupplier().getName().equals(" ")) {
                // Equivalent of MOVE ' SUPPLIER-NAME IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
                editResults.setErrorMessage(" SUPPLIER-NAME IS REQUIRED");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setStatus("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF SUPPLIER-PERF IS NOT NUMERIC OR SUPPLIER-PERF = 0
            if (!CommonUtil.isDouble(partSuppAddrPO.getSupplier().getPerf()) || partSuppAddrPO.getSupplier().getPerf().equals("0")) {
                // Equivalent of MOVE ' SUPPLIER-PERF IS REQUIRED: ' TO WS-EDIT-ERROR-MESSAGE
                editResults.setErrorMessage(" SUPPLIER-PREF IS REQUIRED");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setStatus("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF NOT (SUBCONTRACTOR OR DISTRIBUTOR OR MANUFACTURER OR IMPORTER)
//            if (!(partSuppAddrPO.getSupplier().SUPPLIER_TYPE_LIST.contains(partSuppAddrPO.getSupplier().getSUPPLIER_TYPE()))) {
            if (!SupplierUtil.isValidSupplier(partSuppAddrPO.getSupplier().getType())) {
                // Equivalent of MOVE ' SUPPLIER-TYPE IS not valid.' TO WS-EDIT-ERROR-MESSAGE
                editResults.setErrorMessage(" SUPPLIER-TYPE IS not valid.");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setStatus("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF NOT (HIGHEST-QUALITY OR AVERAGE-QUALITY OR LOWEST-QUALITY)
//            if (!(partSuppAddrPO.getSupplier().SUPPLIER_RATING_LIST.contains(partSuppAddrPO.getSupplier().getSUPPLIER_RATING()))) {
            if (!SupplierUtil.isValidRating(partSuppAddrPO.getSupplier().getRating())) {
                // Equivalent of MOVE ' SUPPLIER-RATING IS not valid.' TO WS-EDIT-ERROR-MESSAGE
                editResults.setErrorMessage(" SUPPLIER-RATING IS not valid.");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setStatus("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF NOT (GOVT-COMM OR GOVT-ONLY OR COMMERCIAL-ONLY)
//            if (!(partSuppAddrPO.getSupplier().SUPPLIER_STATUS_LIST.contains(partSuppAddrPO.getSupplier().getSUPPLIER_STATUS()))) {
            if (!SupplierUtil.isValidSupplierStatus(partSuppAddrPO.getSupplier().getStatus())) {

                    // Equivalent of MOVE SUPPLIER-STATUS TO WS-EDIT-FIELD
                editResults.setField(partSuppAddrPO.getSupplier().getStatus());

                // Equivalent of MOVE ' SUPPLIER-STATUS IS not valid.' TO WS-EDIT-ERROR-MESSAGE
                editResults.setErrorMessage(" SUPPLIER-STATUS IS not valid.");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setStatus("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of PERFORM VARYING ADDR-IDX FROM 1 BY 1 UNTIL ADDR-IDX > 3
            for (int ADDR_IDX = 1; ADDR_IDX <= 3; ADDR_IDX++) {
                // Equivalent of IF NOT (ORDER-ADDRESS(ADDR-IDX) OR SCHED-ADDRESS(ADDR-IDX) OR REMIT-ADDRESS(ADDR-IDX) )

//                if (!partSuppAddrPO.getSuppAddLists().get(ADDR_IDX).ADDRESS_TYPE_LIST.contains(partSuppAddrPO.getSuppAddLists().get(ADDR_IDX).getADDRESS_TYPE())){
                if (!SupplierUtil.isValidAddressType(partSuppAddrPO.getSuppAddLists().get(ADDR_IDX).getType())){

                    // Equivalent of MOVE ADDRESS-TYPE(ADDR-IDX) TO WS-EDIT-FIELD
                    editResults.setField(partSuppAddrPO.getSuppAddLists().get(ADDR_IDX).getType());

                    // Equivalent of MOVE ' SUPPLIER-STATUS IS not valid.' TO WS-EDIT-ERROR-MESSAGE
                    editResults.setErrorMessage(" SUPPLIER-STATUS IS not valid.");

                    // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                    editResults.setStatus("N");

                    // Equivalent of EXIT PARAGRAPH
                    return;
                }
            }
        }

        // Helper method to check if a string is numeric
//        private static boolean isNumeric(String str) {
//            try {
//                Double.parseDouble(str);
//                return true;
//            } catch (NumberFormatException e) {
//                return false;
//            }
//        }
    }