package com.mathesh.student.test.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import org.springframework.stereotype.Component;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
@Component
public class MD5 { 
    

    public String encrypt(String password) 
    { 
        try { 
  
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            byte[] messageDigest = md.digest(password.getBytes()); 
  
            BigInteger bigInteger = new BigInteger(1, messageDigest); 

            String hashtext = bigInteger.toString(16);
            
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); 
        } 
    } 
    
}