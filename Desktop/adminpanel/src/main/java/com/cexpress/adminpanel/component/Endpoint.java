
package com.cexpress.adminpanel.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cexpress.adminpanel.oauth.SettingsRepository;



@Component

public class Endpoint {

	public static Map<String, String> superAdmin = new HashMap<>();
	public static Map<String, String> admin = new HashMap<>();
	public static Map<String, String> employee = new HashMap<>();
	public static Map<String, String> operator = new HashMap<>();
	public static Map<String, String> customer = new HashMap<>();

	/*
	 * @Autowired static SettingsRepository settings;
	 */
	private static SettingsRepository settings;
	
	
	

	@Autowired
	public Endpoint(SettingsRepository settings) {
		Endpoint.settings = settings;
		employee.put("KEY_GET_OUTH_TOKEN", "oauth/token");
		employee.put("KEY_UPLOAD", "");
		
	}

	public static String fetchEndpoint(String key) {
		// String roleID = settings.getRolename();
		String roleID = settings.getRolename();
		System.out.println(roleID + " " + key);
		switch (roleID) {
		case "ROLE_SUPER_ADMIN":
			// break;
			System.out.println("superadmin key is" + superAdmin.get(key));
			return superAdmin.get(key);

		case "ROLE_ADMIN":
			// break;
			System.out.println("admin1 key is" + admin.get(key));
			return admin.get(key);

		
		case "ROLE_EMPLOYEE":
			// break;
			System.out.println("employee key is" + employee.get(key));
			return employee.get(key);

		}
		return "Default String";

	}

}
