package main.dto;

import java.util.Arrays;
import java.util.List;

public class Parts {

    private String PART_NUMBER = " ";
    private String PART_NAME= " ";
    private String SPEC_NUMBER=" ";
    private String GOVT_COMML_CODE=" ";
    private String BLUEPRINT_NUMBER= " ";
    private String UNIT_OF_MEASURE=" ";
    private String WEEKS_LEAD_TIME= "0";
    private boolean WEEKS_LEAD_TIME_OK;
    private String VEHICLE_MAKE = " ";

    public final List<String> VEHICLE_MAKE_LIST = Arrays.asList("CHR","FOR","GM ","VW ","TOY","JAG","PEU","BMW");
    private boolean CHRYSLER;
    private boolean FORD;
    private boolean GM;
    private boolean VOLKSWAGON;
    private boolean TOYOTA;
    private boolean JAGUAR;
    private boolean PEUGEOT;
    private boolean BMW;
    private String VEHICLE_MODEL = " ";
    private String VEHICLE_YEAR= "0";
    private boolean VEHICLE_YEAR_OK;
    private String FILLER="xxxxxxxxxxxxxx";

    public Parts(String dataLine) {
        this.PART_NUMBER = dataLine.substring(0,23);
        this.PART_NAME = dataLine.substring(23,37);
        this.SPEC_NUMBER = dataLine.substring(37,44);
        this.GOVT_COMML_CODE = dataLine.substring(44,45);
        this.BLUEPRINT_NUMBER = dataLine.substring(45,55);
        this.UNIT_OF_MEASURE = dataLine.substring(55,58);
        this.WEEKS_LEAD_TIME = dataLine.substring(58,61) ;
        this.VEHICLE_MAKE = dataLine.substring(61,64);
        this.VEHICLE_MODEL = dataLine.substring(64,74);
        this.VEHICLE_YEAR = dataLine.substring(74,78);
        this.FILLER = "XXXXXXXXXXXXXX";
    }

//    public Parts(String dataLine){
//        this.PART_NUMBER = dataLine.substring(0,23);
//        this.PART_NAME = dataLine.substring(24,38);
//        this.SPEC_NUMBER = dataLine.substring(39,45);
//    }

    public String getPART_NUMBER() {
        return PART_NUMBER;
    }

    public void setPART_NUMBER(String PART_NUMBER) {
        this.PART_NUMBER = PART_NUMBER;
    }

    public String getPART_NAME() {
        return PART_NAME;
    }

    public void setPART_NAME(String PART_NAME) {
        this.PART_NAME = PART_NAME;
    }

    public String getSPEC_NUMBER() {
        return SPEC_NUMBER;
    }

    public void setSPEC_NUMBER(String SPEC_NUMBER) {
        this.SPEC_NUMBER = SPEC_NUMBER;
    }

    public String getGOVT_COMML_CODE() {
        return GOVT_COMML_CODE;
    }

    public void setGOVT_COMML_CODE(String GOVT_COMML_CODE) {
        this.GOVT_COMML_CODE = GOVT_COMML_CODE;
    }

    public String getBLUEPRINT_NUMBER() {
        return BLUEPRINT_NUMBER;
    }

    public void setBLUEPRINT_NUMBER(String BLUEPRINT_NUMBER) {
        this.BLUEPRINT_NUMBER = BLUEPRINT_NUMBER;
    }

    public String getUNIT_OF_MEASURE() {
        return UNIT_OF_MEASURE;
    }

    public void setUNIT_OF_MEASURE(String UNIT_OF_MEASURE) {
        this.UNIT_OF_MEASURE = UNIT_OF_MEASURE;
    }

    public String getWEEKS_LEAD_TIME() {
        return WEEKS_LEAD_TIME;
    }

    public void setWEEKS_LEAD_TIME(String WEEKS_LEAD_TIME) {
        this.WEEKS_LEAD_TIME = WEEKS_LEAD_TIME;
    }

    public boolean isWEEKS_LEAD_TIME_OK() {
        return WEEKS_LEAD_TIME_OK;
    }

    public void setWEEKS_LEAD_TIME_OK(boolean WEEKS_LEAD_TIME_OK) {
        this.WEEKS_LEAD_TIME_OK = WEEKS_LEAD_TIME_OK;
    }

    public String getVEHICLE_MAKE() {
        return VEHICLE_MAKE;
    }

    public void setVEHICLE_MAKE(String VEHICLE_MAKE) {
        this.VEHICLE_MAKE = VEHICLE_MAKE;
    }

    public boolean isCHRYSLER() {
        return CHRYSLER;
    }

    public void setCHRYSLER(boolean CHRYSLER) {
        this.CHRYSLER = CHRYSLER;
    }

    public boolean isFORD() {
        return FORD;
    }

    public void setFORD(boolean FORD) {
        this.FORD = FORD;
    }

    public boolean isGM() {
        return GM;
    }

    public void setGM(boolean GM) {
        this.GM = GM;
    }

    public boolean isVOLKSWAGON() {
        return VOLKSWAGON;
    }

    public void setVOLKSWAGON(boolean VOLKSWAGON) {
        this.VOLKSWAGON = VOLKSWAGON;
    }

    public boolean isTOYOTA() {
        return TOYOTA;
    }

    public void setTOYOTA(boolean TOYOTA) {
        this.TOYOTA = TOYOTA;
    }

    public boolean isJAGUAR() {
        return JAGUAR;
    }

    public void setJAGUAR(boolean JAGUAR) {
        this.JAGUAR = JAGUAR;
    }

    public boolean isPEUGEOT() {
        return PEUGEOT;
    }

    public void setPEUGEOT(boolean PEUGEOT) {
        this.PEUGEOT = PEUGEOT;
    }

    public boolean isBMW() {
        return BMW;
    }

    public void setBMW(boolean BMW) {
        this.BMW = BMW;
    }

    public String getVEHICLE_MODEL() {
        return VEHICLE_MODEL;
    }

    public void setVEHICLE_MODEL(String VEHICLE_MODEL) {
        this.VEHICLE_MODEL = VEHICLE_MODEL;
    }

    public String getVEHICLE_YEAR() {
        return VEHICLE_YEAR;
    }

    public void setVEHICLE_YEAR(String VEHICLE_YEAR) {
        this.VEHICLE_YEAR = VEHICLE_YEAR;
    }

    public boolean isVEHICLE_YEAR_OK() {
        return VEHICLE_YEAR_OK;
    }

    public void setVEHICLE_YEAR_OK(boolean VEHICLE_YEAR_OK) {
        this.VEHICLE_YEAR_OK = VEHICLE_YEAR_OK;
    }

    public String getFILLER() {
        return FILLER;
    }

    public void setFILLER(String FILLER) {
        this.FILLER = FILLER;
    }
}
