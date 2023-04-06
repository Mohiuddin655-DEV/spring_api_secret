package com.example.spring_api_secret.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

@Data
public class Response<T> {
    private boolean error;
    private boolean success;
    private Status status;
    private T data;

    private Response() {
    }

    public static <T> Response<T> init(){
        return new Response<>();
    }

    public static <T> @NotNull Response<T> withData(T data) {
        final Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    public static <T> @NotNull Response<T> withData(T data, String message) {
        final Response<T> response = new Response<>();
        response.setData(data);
        response.setMessage(message);
        return response;
    }

    public static <T> @NotNull Response<T> withMessage(String message) {
        final Response<T> response = new Response<>();
        response.setMessage(message);
        return response;
    }

    public static <T> @NotNull Response<T> withError(String error) {
        final Response<T> response = new Response<>();
        response.setError(error);
        return response;
    }

    public static <T> @NotNull Response<T> withStatus(Status status) {
        final Response<T> response = new Response<>();
        response.setStatus(status);
        return response;
    }

    public static <T> @NotNull Response<T> withHttpStatus(HttpStatus status, boolean isError) {
        final Response<T> response = new Response<>();
        response.setHttpStatus(status, isError);
        return response;
    }

    public void setHttpStatus(HttpStatus status, boolean isError) {
        this.status = Status.of(status);
        this.error = isError;
        this.success = !isError;
    }

    public void setError(String error) {
        this.status = Status.error(error);
        this.error = true;
    }

    public void setMessage(String message) {
        this.status = Status.successful(message);
        this.success = true;
    }

    public void setData(T data) {
        this.status = Status.successful();
        this.data = data;
        this.success = true;
    }

    @Data
    public static class Status {
        private final int code;

        private final String message;

        private Status() {
            this(HttpStatus.OK);
        }

        private Status(int code, String message) {
            this.code = code;
            this.message = message;
        }

        private Status(@NotNull HttpStatus status) {
            this.code = status.value();
            this.message = status.getReasonPhrase();
        }

        public static @NotNull Status of(HttpStatus status) {
            return new Status(status);
        }

        public static @NotNull Status successful() {
            return new Status(HttpStatus.OK);
        }

        public static @NotNull Status successful(String message) {
            return new Status(200, message);
        }

        public static @NotNull Status created() {
            return new Status(HttpStatus.CREATED);
        }

        public static @NotNull Status updated() {
            return new Status(200, "Content Updated!");
        }

        public static @NotNull Status deleted() {
            return new Status(200, "Content Deleted!");
        }

        public static @NotNull Status error(String message) {
            return new Status(400, message);
        }

        public static @NotNull Status notFound() {
            return new Status(HttpStatus.NOT_FOUND);
        }
    }

}
