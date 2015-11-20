/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkgood;

import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author Xavier_2
 */
public class Messages {
	private static final String BUNDLE_NAME = "parkgood.messages"; //$NON-NLS-1$

	  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	  private Messages() {}

	  public static String getString(String key) {
	    try {
	      return RESOURCE_BUNDLE.getString(key);
	    } catch (MissingResourceException e) {
	      return '!' + key + '!';
	    }
	  }
}
