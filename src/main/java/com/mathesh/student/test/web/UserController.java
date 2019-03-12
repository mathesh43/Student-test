/**
 * 
 */
package com.mathesh.student.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mathesh.student.test.Model.User;
import com.mathesh.student.test.Service.UserService;
import com.mathesh.student.test.util.exception.ApplicationException;
import com.mathesh.student.test.util.exception.ExceptionHandlingController;

import io.swagger.annotations.ApiOperation;

/**
 * @author mathesh
 *
 */
@RestController
@RequestMapping("/v1/rest")
public class UserController extends ExceptionHandlingController {

    @Autowired
    private UserService userService;
    
    
    @PostMapping("/register")
    @ApiOperation(value = "Register the user")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean registerUser(@RequestBody User user) throws ApplicationException {
        
        Boolean isUserRegistered = false;
        
        User createdUser = userService.register(user);
        
        if (createdUser != null) {
            isUserRegistered = true;
        }
        
        return isUserRegistered;
        
    }
    
    @PostMapping("/confirm/{id}")
    @ApiOperation(value = "Confirm the email address")
    @ResponseStatus(HttpStatus.OK)
    public void confirmUser(@PathVariable Long id) throws ApplicationException {
        
        userService.confirmEmailAddress(id);
        
    }
    
    
}
