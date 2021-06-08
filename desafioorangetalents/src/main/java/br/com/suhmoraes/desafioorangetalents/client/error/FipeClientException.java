package br.com.suhmoraes.desafioorangetalents.client.error;

import org.springframework.http.HttpStatus;

import feign.Response;

public class FipeClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;
	private final HttpStatus status;
	

    public FipeClientException(final String message, final HttpStatus status) {
        super(message);
        this.status = status;
    }

    public FipeClientException(final Response error, final String errorSource) {
        super(errorSource + " :: " + error.reason());
        this.status = HttpStatus.valueOf(error.status());
    }

    public HttpStatus getStatus() {
        return status;
    }
}