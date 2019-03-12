/**
 * 
 */
package com.mathesh.student.test.util.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import org.springframework.http.HttpStatus;


/**
 * Generic Exception handling controller.
 * TODO Replace instantiation of Errors object with scoped proxy, since we have to inject prototype bean (Errors) to singleton.
 */
public class ExceptionHandlingController {

    /**
     * Handle any precondition.
     *
     * @param ex exception to handle.
     * @return errors
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody Errors handleException(ApplicationException ex) {
        return ex.getErrors();
    }

    /**
     * Generic checked exception handler.
     *
     * @param ex the exception to handle
     * @return errors
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody Errors handleException(Exception ex) {
        Errors errors = new Errors();
        errors.addError(ex.getMessage());
        return errors;
    }

}