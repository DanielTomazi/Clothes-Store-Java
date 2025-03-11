package com.toedter.components;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public abstract class UTF8ResourceBundle {

	public static final ResourceBundle getBundle(String baseName, Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
		if (!(bundle instanceof PropertyResourceBundle))
			return bundle;

		return new UTF8PropertyResourceBundle((PropertyResourceBundle) bundle);
	}

	private static class UTF8PropertyResourceBundle extends ResourceBundle {
		PropertyResourceBundle propertyResourceBundle;

		private UTF8PropertyResourceBundle(PropertyResourceBundle bundle) {
			this.propertyResourceBundle = bundle;
		}

		public Enumeration getKeys() {
			return propertyResourceBundle.getKeys();
		}

		protected Object handleGetObject(String key) {
			String value = (String) propertyResourceBundle.handleGetObject(key);
			if (value != null) {
				try {
					return new String(value.getBytes("ISO-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException exception) {
					throw new RuntimeException(
							"UTF-8 encoding is not supported.", exception);
				}
			}
			return null;
		}
	}
}
