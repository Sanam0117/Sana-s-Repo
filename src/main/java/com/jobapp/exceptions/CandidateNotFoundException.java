package com.jobapp.exceptions;

public class CandidateNotFoundException extends RuntimeException{

    public CandidateNotFoundException() {
        super();

    }
    public CandidateNotFoundException(String message) {
        super(message);

    }
}
