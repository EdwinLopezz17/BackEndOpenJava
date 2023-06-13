package com.acme.learning.platform.shared.domain.service.communication;

import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
public abstract class BaseResponse <T>{
    private boolean succes;
    private String message;
    private T resource;


    public BaseResponse(String message) {
        this.succes=false;
        this.message = message;
        this.resource=null;
    }

    public BaseResponse(T resource) {
        this.succes=true;
        this.message= Strings.EMPTY;
        this.resource = resource;
    }
}
