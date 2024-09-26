/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author Keshani Perera
 */
public class createObject {
    
     public static serviceFunctions createUserOperations(String userType) {
        if ("manager".equals(userType)) {
            return new manager();
        } else if ("cashier".equals(userType)) {
            return new cashier();
        }
        // Add more user types as needed
        
        // Default case (handle if user type is not recognized)
        throw new IllegalArgumentException("Invalid user type: " + userType);
    }
    
}
