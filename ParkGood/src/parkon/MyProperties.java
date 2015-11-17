/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkon;

import java.util.Properties;

/**
 *
 * @author Xavier_2
 */
public class MyProperties {
     public Properties getProperties() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("prices.properties"));
            if (!properties.isEmpty())
                return properties;
            else
                return null;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
     }
}
