package com.jason.dto;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BNC on 2019/4/11.
 */
public class MessageDTO {

    private int status;

    @Enumerated(value = EnumType.STRING)
    private HttpStatus httpStatus;

    private String info;

    private Object object;

    public MessageDTO(int status, HttpStatus httpStatus, String info) {
        this.status = status;
        this.httpStatus = httpStatus;
        this.info = info;
    }

    public MessageDTO(int status, HttpStatus httpStatus, String info, Object object) {
        this.status = status;
        this.httpStatus = httpStatus;
        this.info = info;
        this.object = object;
    }

    public MessageDTO(int status, HttpStatus httpStatus, String info, Page page) {
        this.status = status;
        this.httpStatus = httpStatus;
        this.info = info;
        Map<String, Object> map = new HashMap<>();
        map.put("pageSize", page.getSize());
        map.put("pageNum", page.getNumber());
        map.put("total", page.getTotalElements());
        map.put("totalPage", page.getTotalPages());
        map.put("item", page.getContent());
        this.object = map;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
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
                ", httpStatus=" + httpStatus +
                ", info='" + info + '\'' +
                ", object=" + object +
                '}';
    }
}
