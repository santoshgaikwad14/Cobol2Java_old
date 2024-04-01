package main;

import main.dto.EditResults;
import main.dto.PartSuppAddrPO;

public class FINSUPPL {
        String LILIAN;
        String MSG_NO_X;
        int VSTRING_LENGTH;
        String[] VSTRING_TEXT;
        int PICSTR_VSTRING_LENGTH;
        String[] PICSTR_VSTRING_TEXT;
        int CONDITION_TOKEN_VALUE_SEVERITY;
        int CONDITION_TOKEN_VALUE_MSG_NO;
        int CONDITION_TOKEN_VALUE_CLASS_CODE;
        int CONDITION_TOKEN_VALUE_CAUSE_CODE;
        String CONDITION_TOKEN_VALUE_CASE_SEV_CTL;
        String CONDITION_TOKEN_VALUE_FACILITY_ID;
        int FC_I_S_INFO;
        String WS_EDIT_RESULTS_WS_EDIT_STATUS;
        String WS_EDIT_RESULTS_WS_EDIT_FIELD;
        String WS_EDIT_RESULTS_WS_EDIT_ERROR_MESSAGE;
        public static void WS_FINSUPPL(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {

        // Equivalent of PROCEDURE DIVISION USING PART-SUPP-ADDR-PO, WS-EDIT-RESULTS.

            // Equivalent of MOVE 'Y' TO WS-EDIT-STATUS
            editResults.setWS_EDIT_STATUS("Y");

            // Equivalent of DISPLAY 'Validating Suppliers:' PART-NUMBER
            System.out.println("Validating Suppliers: " + partSuppAddrPO.getSuppliers().getSUPPLIER_NAME());

            // Equivalent of PERFORM 000-EDITS
            edits(partSuppAddrPO, editResults);

            // Equivalent of GOBACK
            return;

    }
        // Equivalent of 000-EDITS.
        private static void edits(PartSuppAddrPO partSuppAddrPO, EditResults editResults) {
            // Equivalent of IF SUPPLIER-CODE = SPACES
            if (partSuppAddrPO.getSuppliers().getSUPPLIER_CODE().equals(" ")) {
                // Equivalent of MOVE ' SUPPLIER-CODE IS REQUIRED ' TO WS-EDIT-ERROR-MESSAGE
                editResults.setWS_EDIT_ERROR_MESSAGE(" SUPPLIER-CODE IS REQUIRED ");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setWS_EDIT_STATUS("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF SUPPLIER-TYPE = SPACES
            if (partSuppAddrPO.getSuppliers().getSUPPLIER_TYPE().equals(" ")) {
                // Equivalent of MOVE ' SUPPLIER-TYPE IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
                editResults.setWS_EDIT_ERROR_MESSAGE(" SUPPLIER-TYPE IS REQUIRED");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setWS_EDIT_STATUS("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF SUPPLIER-NAME = SPACES
            if (partSuppAddrPO.getSuppliers().getSUPPLIER_NAME().equals(" ")) {
                // Equivalent of MOVE ' SUPPLIER-NAME IS REQUIRED' TO WS-EDIT-ERROR-MESSAGE
                editResults.setWS_EDIT_ERROR_MESSAGE(" SUPPLIER-NAME IS REQUIRED");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setWS_EDIT_STATUS("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF SUPPLIER-PERF IS NOT NUMERIC OR SUPPLIER-PERF = 0
            if (!isNumeric(partSuppAddrPO.getSuppliers().getSUPPLIER_PERF()) || partSuppAddrPO.getSuppliers().getSUPPLIER_PERF().equals("0")) {
                // Equivalent of MOVE ' SUPPLIER-PERF IS REQUIRED: ' TO WS-EDIT-ERROR-MESSAGE
                editResults.setWS_EDIT_ERROR_MESSAGE(" SUPPLIER-PREF IS REQUIRED");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setWS_EDIT_STATUS("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF NOT (SUBCONTRACTOR OR DISTRIBUTOR OR MANUFACTURER OR IMPORTER)
            if (!(partSuppAddrPO.getSuppliers().SUPPLIER_TYPE_LIST.contains(partSuppAddrPO.getSuppliers().getSUPPLIER_TYPE()))) {
                // Equivalent of MOVE ' SUPPLIER-TYPE IS not valid.' TO WS-EDIT-ERROR-MESSAGE
                editResults.setWS_EDIT_ERROR_MESSAGE(" SUPPLIER-TYPE IS not valid.");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setWS_EDIT_STATUS("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF NOT (HIGHEST-QUALITY OR AVERAGE-QUALITY OR LOWEST-QUALITY)
            if (!(partSuppAddrPO.getSuppliers().SUPPLIER_RATING_LIST.contains(partSuppAddrPO.getSuppliers().getSUPPLIER_RATING()))) {
                // Equivalent of MOVE ' SUPPLIER-RATING IS not valid.' TO WS-EDIT-ERROR-MESSAGE
                editResults.setWS_EDIT_ERROR_MESSAGE(" SUPPLIER-RATING IS not valid.");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setWS_EDIT_STATUS("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of IF NOT (GOVT-COMM OR GOVT-ONLY OR COMMERCIAL-ONLY)
            if (!(partSuppAddrPO.getSuppliers().SUPPLIER_STATUS_LIST.contains(partSuppAddrPO.getSuppliers().getSUPPLIER_STATUS()))) {
                // Equivalent of MOVE SUPPLIER-STATUS TO WS-EDIT-FIELD
                editResults.setWS_EDIT_FIELD(partSuppAddrPO.getSuppliers().getSUPPLIER_STATUS());

                // Equivalent of MOVE ' SUPPLIER-STATUS IS not valid.' TO WS-EDIT-ERROR-MESSAGE
                editResults.setWS_EDIT_ERROR_MESSAGE(" SUPPLIER-STATUS IS not valid.");

                // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                editResults.setWS_EDIT_STATUS("N");

                // Equivalent of EXIT PARAGRAPH
                return;
            }

            // Equivalent of PERFORM VARYING ADDR-IDX FROM 1 BY 1 UNTIL ADDR-IDX > 3
            for (int ADDR_IDX = 1; ADDR_IDX <= 3; ADDR_IDX++) {
                // Equivalent of IF NOT (ORDER-ADDRESS(ADDR-IDX) OR SCHED-ADDRESS(ADDR-IDX) OR REMIT-ADDRESS(ADDR-IDX) )

                if (! partSuppAddrPO.getSuppAddLists().get(ADDR_IDX).ADDRESS_TYPE_LIST.contains(partSuppAddrPO.getSuppAddLists().get(ADDR_IDX).getADDRESS_TYPE())){
                    // Equivalent of MOVE ADDRESS-TYPE(ADDR-IDX) TO WS-EDIT-FIELD
                    editResults.setWS_EDIT_FIELD(partSuppAddrPO.getSuppAddLists().get(ADDR_IDX).getADDRESS_TYPE());

                    // Equivalent of MOVE ' SUPPLIER-STATUS IS not valid.' TO WS-EDIT-ERROR-MESSAGE
                    editResults.setWS_EDIT_ERROR_MESSAGE(" SUPPLIER-STATUS IS not valid.");

                    // Equivalent of MOVE 'N' TO WS-EDIT-STATUS
                    editResults.setWS_EDIT_STATUS("N");

                    // Equivalent of EXIT PARAGRAPH
                    return;
                }
            }
        }

        // Helper method to check if a string is numeric
        private static boolean isNumeric(String str) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }