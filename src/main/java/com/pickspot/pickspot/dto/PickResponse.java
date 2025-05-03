package com.pickspot.pickspot.dto;

public class PickResponse {

    private Integer containerId;
    private Integer targetX;
    private Integer targetY;
    private String errorMessage;

    public PickResponse(Integer containerId, Integer targetX, Integer targetY) {
        this.containerId = containerId;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public PickResponse(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
