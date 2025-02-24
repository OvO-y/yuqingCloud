package com.yuqing.user.dto;

public class Result {
    private static final String SUCCESS="0";
    private static  final  String ERROR="-1";
    private String code;
    private String message;
    private Object data;
    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }
    public static Result error(String message){
        Result result = new Result();
        result.setCode(ERROR);
        result.setMessage(message);
        return result;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
