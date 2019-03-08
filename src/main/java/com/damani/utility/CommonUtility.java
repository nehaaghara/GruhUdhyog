/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.utility;

import java.util.ResourceBundle;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class CommonUtility {
    
    public static String getProperty(String propertyName){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ProjectProperty");
        return resourceBundle.getString(propertyName);
    }
    
}
