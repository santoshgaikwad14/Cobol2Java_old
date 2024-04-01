package main;

import main.dto.EditResults;
import main.dto.PartSuppAddrPO;
import main.parsers.FINPARTS;
import main.parsers.FINSUPPL;
import main.parsers.PartSuppAddrParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FINAL02 {

    public static void main(String[] args) {
        String PARTSUPP="resources/PARTSUPP.txt";
        String PARTSUPP_REC;
        String WS_PARTSUPP_STATUS="00"; //
        boolean WS_PARTSUPP_STATUS_OK; //
        String WS_EOF;  //
        boolean EOF_FOUND;
        int WS_PARTSUPP_READ=0;
        EditResults editResults = new EditResults(null, true, "Y", null, null);


        try {
            // Equivalent of 000-HOUSEKEEPING
            ClassLoader classLoader = FINAL02.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(PARTSUPP);
//            List<PartSuppAddrPO> partSuppAddrPOList = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                // Read lines until the end of the file
                while ((line = reader.readLine()) != null) {
                    System.out.println("Processing Record Number: "+WS_PARTSUPP_READ);
                    System.out.println("###########################");

                    PARTSUPP_REC = line;

                    PartSuppAddrPO partSuppAddrPO = PartSuppAddrParser.parse(PARTSUPP_REC);
//                        partSuppAddrPOList.add(partSuppAddrPO);

                    edit(partSuppAddrPO, editResults);
                    WS_PARTSUPP_READ+=1;
//                        System.out.println("Processed Record Number: "+WS_PARTSUPP_READ);
                    System.out.println("###########################");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error opening file PARTSUPP, Status: " + e);
            }

        } catch (Exception e) {
            System.out.println("Error opening file PARTSUPP, Status: " + e);
        }
    }

    private static void edit(PartSuppAddrPO partSuppAddrPO, EditResults editResults){
        editResults.setStatus("Y");
        editResults.setField("  ");

        FINPARTS.WS_FINPARTS(partSuppAddrPO, editResults);

        if (!editResults.isSuccessful()) {
            System.out.println(" - Parts Edit: FAILED, Error: " + editResults.getErrorMessage());
            System.out.println(" ** Invalid Value: " + editResults.getField());
//            break;
        } else {
            System.out.println(" - Parts Edit: PASSED");
            }

        editResults.setStatus("Y");

        FINSUPPL.WS_FINSUPPL(partSuppAddrPO, editResults);

        if (!editResults.isSuccessful()) {
            System.out.println(" - Supplies Edit: FAILED, Error: " + editResults.getErrorMessage());
            System.out.println(" ** Invalid Value: " + editResults.getField());
//            break;
        } else {
            System.out.println(" - Supplies Edit: PASSED");
        }
    }
}
