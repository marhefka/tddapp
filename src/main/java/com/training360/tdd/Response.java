package com.training360.tdd;

public class Response<T> {
    public final static String RESPONSE_CODE_OK = "OK";

    private String resultCode;
    private T payload;

    public Response() {
        this.resultCode = RESPONSE_CODE_OK;
    }

    public Response(String resultCode) {
        this.resultCode = resultCode;
    }

    public Response(String resultCode, T payload) {
        this.resultCode = resultCode;
        this.payload = payload;
    }

    public String getResultCode() {
        return resultCode;
    }

    public T getPayload() {
        return payload;
    }

    // static otherwise it would be serialized in http response
    public static boolean isOk(Response response) {
        return response.resultCode.equals(RESPONSE_CODE_OK);
    }

    // static otherwise it would be serialized in http response
    public static boolean isNotOk(Response response) {
        return !isOk(response);
    }
}
