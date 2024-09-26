/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;
import databaseConnection.databaseConnection;
import databaseConnection.usertype;
import interfaces.managerInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import models.account;

public class manager extends serviceFunctions {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public manager() {
        con = databaseConnection.connect();
    }

    
    public void login(String userType) {
        managerInterface managerInterface = new managerInterface();
        managerInterface.setVisible(true);
        usertype.setUserType(userType);  
}

    
    
    public boolean addAccount(String txtusername, String txtpassword, String txtrole) {
        boolean success = false;
        account user = new account();
        user.setUsername(txtusername);
        user.setPassword(txtpassword);
        user.setRole(txtrole);

        try {
            // Hash the password before storing it
            String hashedPassword = hashPassword(user.getPassword());

            String q = "INSERT INTO users (user_type, username, password) VALUES (?, ?, ?)";
            pst = con.prepareStatement(q);
            pst.setString(1, user.getRole());
            pst.setString(2, user.getUsername());
            pst.setString(3, hashedPassword);
            pst.execute();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());

        // Convert byte array to hexadecimal string
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
