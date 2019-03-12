package com.mathesh.student.test.Service;

import com.mathesh.student.test.Model.User;
import com.mathesh.student.test.util.exception.ApplicationException;

/**
 *
 */
public interface UserService {

    User register(User user) throws ApplicationException;

    void confirmEmailAddress(Long id) throws ApplicationException;
    
}
