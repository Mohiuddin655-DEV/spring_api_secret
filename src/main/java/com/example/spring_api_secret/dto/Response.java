package com.example.spring_api_secret.dto;

import lombok.Data;

public class Response<T> {
    private boolean success;
    private Error error;
    private String message;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public Response<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response<T> setMessage(String message) {
        this.message = message;
        this.success = true;
        return this;
    }

    public Error getError() {
        return error;
    }

    public Response<T> setError(String error) {
        this.error = new Error(error);
        return this;
    }

    public Response<T> setError(int code) {
        this.error = new Error(code);
        return this;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        this.data = data;
        this.success = true;
        return this;
    }

    public static <T> Response<T> withData(T data) {
        return new Response<T>().setData(data);
    }

    public static <T> Response<T> withData(T data, String message) {
        return new Response<T>().setData(data).setMessage(message);
    }

    public static <T> Response<T> withMessage(String message) {
        return new Response<T>().setMessage(message);
    }

    public static <T> Response<T> withError(String error) {
        return new Response<T>().setError(error);
    }

    public static <T> Response<T> withError(int code) {
        return new Response<T>().setError(code);
    }

    @Data
    public static class Error {
        private int code;
        private String message;

        public Error(int code) {
            this.code = code;
        }

        public Error(String message) {
            this.message = message;
        }

        public int getCode() {
            return code = 0;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message = "";
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
