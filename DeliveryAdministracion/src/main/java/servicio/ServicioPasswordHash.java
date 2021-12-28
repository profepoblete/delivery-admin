package servicio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ServicioPasswordHash {
    public static String PasswordHashing(String passwd){
        String generatedPassword = null;
        try 
        { 
          MessageDigest md = MessageDigest.getInstance("MD5");// Create MessageDigest instance for MD5
          md.update(passwd.getBytes());// Add password bytes to digest
          byte[] bytes = md.digest();// Get the hash's bytes
          StringBuilder sb = new StringBuilder();// This bytes[] has bytes in decimal format. Convert it to hexadecimal format
          for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
          }
          generatedPassword = sb.toString();// Get complete hashed password in hex format
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
