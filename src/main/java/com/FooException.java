package com;

public class FooException extends Exception {

    private static final long serialVersionUID = -4742821342872227456L;


    private String msg;

    public FooException() {
        super();
    }

    public FooException(Throwable t) {
        super(t);
    }

    public FooException(String msg) {
        super(msg);

        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}