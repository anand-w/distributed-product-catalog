package com.catalog.catalogService.exception;

public class JwtExpired extends  RuntimeException{

    public JwtExpired(String msg){
        super(msg);
    }
}
