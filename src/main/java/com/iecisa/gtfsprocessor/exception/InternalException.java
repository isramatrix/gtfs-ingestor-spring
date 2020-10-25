package com.iecisa.gtfsprocessor.exception;

public class InternalException extends Exception
{
    private static final String MESSAGE = "Esta excepción no " +
            "debiera haber ocurrido. Póngase en contacto con el " +
            "desarrollador para proveer de más información.";

    public InternalException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
