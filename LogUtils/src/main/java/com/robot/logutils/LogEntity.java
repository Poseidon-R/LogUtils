package com.robot.logutils;

import java.io.Serializable;

public class LogEntity  implements Serializable {

    private String type;

    private char[] data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public LogEntity(String type, char[] data) {
        this.type = type;
        this.data = data;
    }
}
