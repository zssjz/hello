package com.jason.dto;

/**
 * Created by BNC on 2019/4/11.
 */
public class MessageDTO {

    private int status;

    private int code;

    private String info;

    private Object object;

    public MessageDTO(int status, int code, String info) {
        this.status = status;
        this.code = code;
        this.info = info;
    }

    public MessageDTO(int status, int code, String info, Object object) {
        this.status = status;
        this.code = code;
        this.info = info;
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "status=" + status +
                ", code=" + code +
                ", info='" + info + '\'' +
                ", object=" + object +
                '}';
    }
}
