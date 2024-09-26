/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import databaseConnection.usertype;
import interfaces.cashierInterface;
import interfaces.managerInterface;

/**
 *
 * @author Keshani Perera
 */
 public class cashier extends serviceFunctions {
  
    
    public void login(String userType) {
    
        // Open manager window
        cashierInterface cashierInterface = new cashierInterface();
        cashierInterface.setVisible(true);
        usertype.setUserType(userType);
   
}
   
}