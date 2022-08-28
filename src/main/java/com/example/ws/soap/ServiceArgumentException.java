package com.example.ws.soap;

import javax.xml.ws.WebFault;

@WebFault
public class ServiceArgumentException extends Exception{

    Myfault myfault;

    public ServiceArgumentException(Myfault myfault) {
        super(myfault.getDescription());
        this.myfault = myfault;
    }

    public ServiceArgumentException(String message, Throwable cause, Myfault myfault) {
        super(message, cause);
        this.myfault = myfault;
    }

    public ServiceArgumentException(Throwable cause, Myfault myfault) {
        super(cause);
        this.myfault = myfault;
    }

    public ServiceArgumentException(Throwable cause, boolean enableSuppression, boolean writableStackTrace, Myfault myfault) {
        super(myfault.getDescription(), cause, enableSuppression, writableStackTrace);
        this.myfault = myfault;
    }

    public Myfault getMyfault() {
        return myfault;
    }

    public void setMyfault(Myfault myfault) {
        this.myfault = myfault;
    }
}
