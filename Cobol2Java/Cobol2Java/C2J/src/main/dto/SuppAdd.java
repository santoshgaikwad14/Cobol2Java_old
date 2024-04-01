package main.dto;

import java.util.Arrays;
import java.util.List;

public class SuppAdd {
    private String ADDRESS_TYPE;

    public final List<String> ADDRESS_TYPE_LIST = Arrays.asList("1","2","3");
    private boolean ORDER_ADDRESS;
    private boolean SCHED_ADDRESS;
    private boolean REMIT_ADDRESS;
    private String ADDRESS_1;
    private String ADDRESS_2;
    private String ADDRESS_3;
    private String CITY;
    private String ADDR_STATE;
    private int ZIP_CODE;


    public SuppAdd(String dataLine, int i) {
        if(i == 1) {
            this.ADDRESS_TYPE = dataLine.substring(131,132);
            this.ADDRESS_1 = dataLine.substring(132,147);
            this.ADDRESS_2 = dataLine.substring(147,162);
            this.ADDRESS_3 = dataLine.substring(162,177);
            this.CITY = dataLine.substring(177,192);
            this.ADDR_STATE = dataLine.substring(192,194);
            this.ZIP_CODE = Integer.parseInt(dataLine.substring(194,203));
        } else if(i == 2) {
            this.ADDRESS_TYPE = dataLine.substring(203,204);
            this.ADDRESS_1 = dataLine.substring(204,219);
            this.ADDRESS_2 = dataLine.substring(219,234);
            this.ADDRESS_3 = dataLine.substring(234,249);
            this.CITY = dataLine.substring(249,264);
            this.ADDR_STATE = dataLine.substring(264,266);
            this.ZIP_CODE = Integer.parseInt(dataLine.substring(266,275));
        } else if(i == 3) {
            this.ADDRESS_TYPE = dataLine.substring(275,276);
            this.ADDRESS_1 = dataLine.substring(276,291);
            this.ADDRESS_2 = dataLine.substring(291,306);
            this.ADDRESS_3 = dataLine.substring(306,321);
            this.CITY = dataLine.substring(321,336);
            this.ADDR_STATE = dataLine.substring(336,338);
            this.ZIP_CODE = Integer.parseInt(dataLine.substring(338,347));
        }
    }

    public String getADDRESS_TYPE() {
        return ADDRESS_TYPE;
    }

    public void setADDRESS_TYPE(String ADDRESS_TYPE) {
        this.ADDRESS_TYPE = ADDRESS_TYPE;
    }

    public boolean isORDER_ADDRESS() {
        return ORDER_ADDRESS;
    }

    public void setORDER_ADDRESS(boolean ORDER_ADDRESS) {
        this.ORDER_ADDRESS = ORDER_ADDRESS;
    }

    public boolean isSCHED_ADDRESS() {
        return SCHED_ADDRESS;
    }

    public void setSCHED_ADDRESS(boolean SCHED_ADDRESS) {
        this.SCHED_ADDRESS = SCHED_ADDRESS;
    }

    public boolean isREMIT_ADDRESS() {
        return REMIT_ADDRESS;
    }

    public void setREMIT_ADDRESS(boolean REMIT_ADDRESS) {
        this.REMIT_ADDRESS = REMIT_ADDRESS;
    }

    public String getADDRESS_1() {
        return ADDRESS_1;
    }

    public void setADDRESS_1(String ADDRESS_1) {
        this.ADDRESS_1 = ADDRESS_1;
    }

    public String getADDRESS_2() {
        return ADDRESS_2;
    }

    public void setADDRESS_2(String ADDRESS_2) {
        this.ADDRESS_2 = ADDRESS_2;
    }

    public String getADDRESS_3() {
        return ADDRESS_3;
    }

    public void setADDRESS_3(String ADDRESS_3) {
        this.ADDRESS_3 = ADDRESS_3;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getADDR_STATE() {
        return ADDR_STATE;
    }

    public void setADDR_STATE(String ADDR_STATE) {
        this.ADDR_STATE = ADDR_STATE;
    }

    public int getZIP_CODE() {
        return ZIP_CODE;
    }

    public void setZIP_CODE(int ZIP_CODE) {
        this.ZIP_CODE = ZIP_CODE;
    }
}
