package com.ldpst.paste_service.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseWrapper<T> {
    private String message;
    private T object; 

    public ResponseWrapper() {}

    public ResponseWrapper(String message, T object) {
        this.message = message;
        this.object = object;
    }

    public ResponseWrapper(String message) {
        this.message = message;
    }

    public ResponseWrapper(T object) {
        this.object = object;
    }

    public ResponseWrapper<T> message(String msg) {
        this.message = msg;
        return this;
    }

    public ResponseWrapper<T> object(T obj) {
        this.object = obj;
        return this;
    }
}
