package com.mathesh.student.test.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mathesh.student.test.Model.User;
import com.mathesh.student.test.util.MD5;
import com.mathesh.student.test.util.exception.ApplicationException;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService {
    
    private List<User> users = new ArrayList<User>();
    
    private Long userId = 0l;
    
    @Autowired
    private MD5 md5;
    
    @Autowired
    private SendGridEmailService sendGridEmailService;
    
    @Value("${email}")
    private String fromEmail;

    public User register(User user) throws ApplicationException {
        
        validate(user);
        
        userId = userId + 1l;
        
        user.setId(userId);
        
        String encryptedPassword = md5.encrypt(user.getPassword());
        
        sendGridEmailService.sendText(fromEmail, user.getEmail(), "Confirm the email address", "http://localhost:8080/v1/rest/confirm/" + user.getId());
        
        user.setPassword(encryptedPassword);
        
        users.add(user);
        
        return user;
    }

    private void validate(User user) throws ApplicationException {
        
        validateFirstName(user.getFirstName());
        
        validatePassword(user.getPassword());
        
        validateEmail(user.getEmail());
        
    }

    private void validateFirstName(String firstName) throws ApplicationException {
        if (firstName == null || firstName.isEmpty()) {
            throw new ApplicationException("Please enter the first name.");
        } 
    }
    
    private void validatePassword(String password) throws ApplicationException {
        if (password == null || password.isEmpty()) {
            throw new ApplicationException("Please enter the password.");
        }
    }
    
    public void validateEmail(String email) throws ApplicationException 
    { 
        if (email == null || email.isEmpty()) {
            throw new ApplicationException("Please enter the email address.");
        }
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        
        boolean isValidEmail = pat.matcher(email).matches(); 
        
        if (!isValidEmail) {
            throw new ApplicationException("Please enter the valid email address.");
        }
    }

    @Override
    public void confirmEmailAddress(Long id) throws ApplicationException {
        
        Boolean isUserFound = false;
        
        for (User user : users) {
            if (user.getId() == id) {
                isUserFound = true;
                user.setIsEmailVerified(true);
                break;
            }
        }
        
        if (!isUserFound) {
                throw new ApplicationException("No user found for given id");
        }
    } 

}
