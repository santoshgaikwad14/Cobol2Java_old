package main.dto;

public class EditResults {

    private String WS_EDIT_RESULTS;

    private boolean WS_PASS_EDIT_OK;
    private String WS_EDIT_STATUS;
    private String WS_EDIT_FIELD;
    private String WS_EDIT_ERROR_MESSAGE;

    public EditResults(String WS_EDIT_RESULTS, boolean WS_PASS_EDIT_OK, String WS_EDIT_STATUS, String WS_EDIT_FIELD, String WS_EDIT_ERROR_MESSAGE) {
        this.WS_EDIT_RESULTS = WS_EDIT_RESULTS;
        this.WS_PASS_EDIT_OK = WS_PASS_EDIT_OK;
        this.WS_EDIT_STATUS = WS_EDIT_STATUS;
        this.WS_EDIT_FIELD = WS_EDIT_FIELD;
        this.WS_EDIT_ERROR_MESSAGE = WS_EDIT_ERROR_MESSAGE;
    }

    public String getWS_EDIT_RESULTS() {
        return WS_EDIT_RESULTS;
    }

    public void setWS_EDIT_RESULTS(String WS_EDIT_RESULTS) {
        this.WS_EDIT_RESULTS = WS_EDIT_RESULTS;
    }

    public boolean isWS_PASS_EDIT_OK() {
        return WS_PASS_EDIT_OK;
    }

    public void setWS_PASS_EDIT_OK(boolean WS_PASS_EDIT_OK) {
        this.WS_PASS_EDIT_OK = WS_PASS_EDIT_OK;
    }

    public String getWS_EDIT_STATUS() {
        return WS_EDIT_STATUS;
    }

    public void setWS_EDIT_STATUS(String WS_EDIT_STATUS) {
        this.WS_EDIT_STATUS = WS_EDIT_STATUS;
    }

    public String getWS_EDIT_FIELD() {
        return WS_EDIT_FIELD;
    }

    public void setWS_EDIT_FIELD(String WS_EDIT_FIELD) {
        this.WS_EDIT_FIELD = WS_EDIT_FIELD;
    }

    public String getWS_EDIT_ERROR_MESSAGE() {
        return WS_EDIT_ERROR_MESSAGE;
    }

    public void setWS_EDIT_ERROR_MESSAGE(String WS_EDIT_ERROR_MESSAGE) {
        this.WS_EDIT_ERROR_MESSAGE = WS_EDIT_ERROR_MESSAGE;
    }
}
