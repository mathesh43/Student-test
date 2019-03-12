package com.mathesh.student.test.util.exception;


/**
 *
 */
public class ApplicationException extends Exception {

    /** Serial version id. */
    private static final long serialVersionUID = 1L;

    /**
     * Errors object to get all the errors.
     */
    private Errors errors;

    /**
     * Constructor to display error message for ApplicationException.
     *
     * @param errorMessage to be displayed as exception message.
     */
    public ApplicationException(String errorMessage) {
        Errors errors = new Errors();
        errors.addError(errorMessage);
        this.errors = errors;
    }
    
    /**
     * Constructor to display error message for ApplicationException.
     *
     * @param errorField to mention the error field.
     * @param errorMessage to be displayed as exception message.
     */
    public ApplicationException(String errorField, String errorMessage) {
        Errors errors = new Errors();
        errors.addFieldError(errorField, errorMessage);
        this.errors = errors;
    }

    /**
     * Get the errors.
     *
     * @return errors object
     */
    public Errors getErrors() {
        return this.errors;
    }

}
