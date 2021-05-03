package com.example.boot_mongodb.dto;

public enum RestStatus {
    OK(200, "OK", "OK!!"),
    BadRequest(400, "Bad Request", "BadRequest!!"),
    Unauthorized(401, "Unauthorized", "Unauthorized!!"),
    ;

    private int code;
    private String name;
    private String desc;

    RestStatus() {
    }

    RestStatus(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
