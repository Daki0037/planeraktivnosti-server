package me.danilo.planeraktivnosti.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AuthService {

    public String getHashedPassword(String password) throws NoSuchAlgorithmException {
        String hashedPassword = "";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();

        hashedPassword = javax.xml.bind.DatatypeConverter.printHexBinary(bytes);

        return hashedPassword;
    }

}
