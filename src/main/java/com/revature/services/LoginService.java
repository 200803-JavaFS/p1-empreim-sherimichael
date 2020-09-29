package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDao; 
import com.revature.models.LoginDTO; 
import com.revature.models.User;

import org.apache.commons.codec.binary.Hex;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class LoginService {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
    UserDao uDao = new UserDao();     
    
    public boolean login(LoginDTO l) throws UnsupportedEncodingException { 
    	log.info("@login in LoginService => using salting with PBKDF2");
    	User u = uDao.findByUsername(l.username);
        String salt = "41601";
        int iterations = 1000;
        int keyLength = 512;
        String password = l.password;
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
        String hashedString = Hex.encodeHexString(hashedBytes);

        System.out.println(hashedString);


        if((u!=null) && hashedString.equals(u.getPassword())) {
        	return true;
	
        }else {
        	return false; 
        }
    }
    
    public static byte[] hashPassword( final char[] password, final byte[] salt, final int iterations, final int keyLength ) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
            SecretKey key = skf.generateSecret( spec );
            byte[] res = key.getEncoded( );
            return res;
        } catch ( NoSuchAlgorithmException | InvalidKeySpecException e ) {
            throw new RuntimeException( e );
        }
    }   
}
