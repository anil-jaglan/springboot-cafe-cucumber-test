package io.microservices.cafe.exceptions;

public final class AlienDemandException extends RuntimeException {

    private static final long serialVersionUID = 523709150505621106L;

    public AlienDemandException(final String message) {
        super(message);
    }

}
