package com.graph.response;

public class Response {

    private ResponseStatus status;
    private ResponseCode code;

    public Response(ResponseStatus status, ResponseCode code) {
        this.status = status;
        this.code = code;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

}
