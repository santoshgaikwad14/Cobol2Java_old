package main.dto;

public class PurchageOrder {
    private String PO_NUMBER;
    private String BUYER_CODE;
    private int QUANTITY;
    private double UNIT_PRICE;
    private int ORDER_DATE;
    private int DELIVERY_DATE;


    public PurchageOrder(String dataLine, int i) {
        if (i==1) {
            this.PO_NUMBER = dataLine.substring(347, 353);
            this.BUYER_CODE = dataLine.substring(353, 356);
            this.QUANTITY = Integer.parseInt(dataLine.substring(356, 363));
            this.UNIT_PRICE = Float.parseFloat(dataLine.substring(363, 371));
            this.ORDER_DATE = Integer.parseInt(dataLine.substring(372, 380));
            this.DELIVERY_DATE = Integer.parseInt(dataLine.substring(380, 388));
        }

        else if (i==2){
            this.PO_NUMBER = dataLine.substring(388, 394);
            this.BUYER_CODE = dataLine.substring(394, 397);
            this.QUANTITY = Integer.parseInt(dataLine.substring(397, 404));
            this.UNIT_PRICE = Float.parseFloat(dataLine.substring(404, 413));
            this.ORDER_DATE = Integer.parseInt(dataLine.substring(413, 421));
            this.DELIVERY_DATE = Integer.parseInt(dataLine.substring(421, 429));
        }

        else if (i==3){
            this.PO_NUMBER = dataLine.substring(429, 435);
            this.BUYER_CODE = dataLine.substring(435, 438);
            this.QUANTITY = Integer.parseInt(dataLine.substring(438, 445));
            this.UNIT_PRICE = Float.parseFloat(dataLine.substring(445, 454));
            this.ORDER_DATE = Integer.parseInt(dataLine.substring(454, 462));
            this.DELIVERY_DATE = Integer.parseInt(dataLine.substring(462, 470));
        }

    }

    public String getPO_NUMBER() {
        return PO_NUMBER;
    }

    public void setPO_NUMBER(String PO_NUMBER) {
        this.PO_NUMBER = PO_NUMBER;
    }

    public String getBUYER_CODE() {
        return BUYER_CODE;
    }

    public void setBUYER_CODE(String BUYER_CODE) {
        this.BUYER_CODE = BUYER_CODE;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public double getUNIT_PRICE() {
        return UNIT_PRICE;
    }

    public void setUNIT_PRICE(double UNIT_PRICE) {
        this.UNIT_PRICE = UNIT_PRICE;
    }

    public int getORDER_DATE() {
        return ORDER_DATE;
    }

    public void setORDER_DATE(int ORDER_DATE) {
        this.ORDER_DATE = ORDER_DATE;
    }

    public int getDELIVERY_DATE() {
        return DELIVERY_DATE;
    }

    public void setDELIVERY_DATE(int DELIVERY_DATE) {
        this.DELIVERY_DATE = DELIVERY_DATE;
    }
}
