package com.dilemma.dilemma.common;

/**
 * Created by aslan.atasoy on 09/28/2017.
 */
public class CommonFault {

    private String faultMessage;
    private String faultCode;
    private String faultedMethod;

    public String getFaultMessage() {
        return faultMessage;
    }

    public void setFaultMessage(String faultMessage) {
        this.faultMessage = faultMessage;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultedMethod() {
        return faultedMethod;
    }

    public void setFaultedMethod(String faultedMethod) {
        this.faultedMethod = faultedMethod;
    }
}
