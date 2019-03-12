package com.mathesh.student.test.util.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stores and exposes information about data-binding and validation errors of a specific object.
 *
 */
public class Errors {

    /** Global error list attribute. */
    private List<String> errors = new ArrayList<String>();

    private Map<String, String> fieldErrors = new HashMap<String, String>();

    /**
     * Get global error.
     * @return error list
     */
     public List<String> getErrors() {
         return this.errors;
     }

     /**
      * Get field errors.
      * @return map of field errors
      */
     public Map<String, String> getFieldErrors() {
         return fieldErrors;
     }

     /**
      * Add error.
      * @param errorMessage to set
      */
     public void addError(String errorMessage) {
         this.errors.add(errorMessage);
     }

     /**
      * Add field errors.
      *
      * @param field to set
      * @param errorMessage to set
      */
     public void addFieldError(String field, String errorMessage) {
         this.fieldErrors.put(field, errorMessage);
     }

     /**
      * Check we have error and field errors.
      * @return true/false
      */
     public Boolean hasErrors() {
         return !(fieldErrors.isEmpty() && errors.isEmpty());
     }
}
