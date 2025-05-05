package com.nexalyze.nexalyze.configuration.json;

import java.util.HashMap;

public class JsonObject extends HashMap<String, Object> {

    public void addMessage(String message){
        this.put("message" , message);
    }
    public void addError(String error){
        this.put("error" , error);
    }

    public void addId(Integer id){
        this.put("id" , id);
    }

}
