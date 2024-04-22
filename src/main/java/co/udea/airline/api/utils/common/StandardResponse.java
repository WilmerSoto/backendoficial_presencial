package co.udea.airline.api.utils.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StandardResponse<T> {

    private int status;
    private String message;
    private String devMesssage;
    private T body;

    public StandardResponse() {
    }

    public StandardResponse(StatusStandardResponse status, T body) {
        this.status = status.getStatus();
        this.body = body;
    }

    public StandardResponse(StatusStandardResponse status, String message, T body){
        this.status = status.getStatus();
        this.message = message;
        this.body = body;
    }

    public StandardResponse(StatusStandardResponse status) {
        this.status = status.getStatus();
    }

    public StandardResponse(String message, StatusStandardResponse status) {
        this.status = status.getStatus();
        this.message = message;
    }

    public StandardResponse(StatusStandardResponse status, String message) {
        this.status = status.getStatus();
        this.message = message;
    }

    public StandardResponse(int status, String message, T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public StandardResponse(int status, String message, String devMesssage, T body) {
        this.status = status;
        this.message = message;
        this.devMesssage = devMesssage;
        this.body = body;
    }

    public enum StatusStandardResponse {
        OK(0),
        ERROR(1);

        private int status;

        StatusStandardResponse(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }
}
