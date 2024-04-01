package main.dto;

import java.util.Arrays;
import java.util.List;

public class Suppliers {

        private String SUPPLIER_CODE;
        private String SUPPLIER_TYPE ;
        public final List<String> SUPPLIER_TYPE_LIST = Arrays.asList("S","D","M ","I");
        private boolean SUBCONTRACTOR;
        private boolean DISTRIBUTOR;
        private boolean MANUFACTURER;
        private boolean IMPORTER;
        private String SUPPLIER_NAME;
        private String SUPPLIER_PERF;
        private String SUPPLIER_RATING;

        public final List<String> SUPPLIER_RATING_LIST = Arrays.asList("1","2","3");
        private boolean HIGHEST_QUALITY;
        private boolean AVERAGE_QUALITY;
        private boolean LOWEST_QUALITY;
        private String SUPPLIER_STATUS;

        public final List<String> SUPPLIER_STATUS_LIST = Arrays.asList("1","2","3");
        private boolean GOVT_COMM;
        private boolean GOVT_ONLY;
        private boolean COMMERCIAL_ONLY;
        private String SUPPLIER_ACT_DATE;


    public Suppliers(String dataLine) {
        this.SUPPLIER_CODE = dataLine.substring(92,102);
        this.SUPPLIER_TYPE = dataLine.substring(102,103);
        this.SUPPLIER_NAME = dataLine.substring(103,118);
        this.SUPPLIER_PERF = dataLine.substring(118,121);
        this.SUPPLIER_RATING = dataLine.substring(121,122);
        this.SUPPLIER_STATUS = dataLine.substring(122,123);
        this.SUPPLIER_ACT_DATE = dataLine.substring(123,131);
    }

    public String getSUPPLIER_CODE() {
        return SUPPLIER_CODE;
    }

    public void setSUPPLIER_CODE(String SUPPLIER_CODE) {
        this.SUPPLIER_CODE = SUPPLIER_CODE;
    }

    public String getSUPPLIER_TYPE() {
        return SUPPLIER_TYPE;
    }

    public void setSUPPLIER_TYPE(String SUPPLIER_TYPE) {
        this.SUPPLIER_TYPE = SUPPLIER_TYPE;
    }

    public boolean isSUBCONTRACTOR() {
        return SUBCONTRACTOR;
    }

    public void setSUBCONTRACTOR(boolean SUBCONTRACTOR) {
        this.SUBCONTRACTOR = SUBCONTRACTOR;
    }

    public boolean isDISTRIBUTOR() {
        return DISTRIBUTOR;
    }

    public void setDISTRIBUTOR(boolean DISTRIBUTOR) {
        this.DISTRIBUTOR = DISTRIBUTOR;
    }

    public boolean isMANUFACTURER() {
        return MANUFACTURER;
    }

    public void setMANUFACTURER(boolean MANUFACTURER) {
        this.MANUFACTURER = MANUFACTURER;
    }

    public boolean isIMPORTER() {
        return IMPORTER;
    }

    public void setIMPORTER(boolean IMPORTER) {
        this.IMPORTER = IMPORTER;
    }

    public String getSUPPLIER_NAME() {
        return SUPPLIER_NAME;
    }

    public void setSUPPLIER_NAME(String SUPPLIER_NAME) {
        this.SUPPLIER_NAME = SUPPLIER_NAME;
    }

    public String getSUPPLIER_PERF() {
        return SUPPLIER_PERF;
    }

    public void setSUPPLIER_PERF(String SUPPLIER_PERF) {
        this.SUPPLIER_PERF = SUPPLIER_PERF;
    }

    public String getSUPPLIER_RATING() {
        return SUPPLIER_RATING;
    }

    public void setSUPPLIER_RATING(String SUPPLIER_RATING) {
        this.SUPPLIER_RATING = SUPPLIER_RATING;
    }

    public boolean isHIGHEST_QUALITY() {
        return HIGHEST_QUALITY;
    }

    public void setHIGHEST_QUALITY(boolean HIGHEST_QUALITY) {
        this.HIGHEST_QUALITY = HIGHEST_QUALITY;
    }

    public boolean isAVERAGE_QUALITY() {
        return AVERAGE_QUALITY;
    }

    public void setAVERAGE_QUALITY(boolean AVERAGE_QUALITY) {
        this.AVERAGE_QUALITY = AVERAGE_QUALITY;
    }

    public boolean isLOWEST_QUALITY() {
        return LOWEST_QUALITY;
    }

    public void setLOWEST_QUALITY(boolean LOWEST_QUALITY) {
        this.LOWEST_QUALITY = LOWEST_QUALITY;
    }

    public String getSUPPLIER_STATUS() {
        return SUPPLIER_STATUS;
    }

    public void setSUPPLIER_STATUS(String SUPPLIER_STATUS) {
        this.SUPPLIER_STATUS = SUPPLIER_STATUS;
    }

    public boolean isGOVT_COMM() {
        return GOVT_COMM;
    }

    public void setGOVT_COMM(boolean GOVT_COMM) {
        this.GOVT_COMM = GOVT_COMM;
    }

    public boolean isGOVT_ONLY() {
        return GOVT_ONLY;
    }

    public void setGOVT_ONLY(boolean GOVT_ONLY) {
        this.GOVT_ONLY = GOVT_ONLY;
    }

    public boolean isCOMMERCIAL_ONLY() {
        return COMMERCIAL_ONLY;
    }

    public void setCOMMERCIAL_ONLY(boolean COMMERCIAL_ONLY) {
        this.COMMERCIAL_ONLY = COMMERCIAL_ONLY;
    }

    public String getSUPPLIER_ACT_DATE() {
        return SUPPLIER_ACT_DATE;
    }

    public void setSUPPLIER_ACT_DATE(String SUPPLIER_ACT_DATE) {
        this.SUPPLIER_ACT_DATE = SUPPLIER_ACT_DATE;
    }
}

