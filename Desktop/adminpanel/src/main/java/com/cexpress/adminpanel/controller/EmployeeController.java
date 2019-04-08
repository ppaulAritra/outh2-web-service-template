/**
 * 
 */
package com.cexpress.adminpanel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cexpress.adminpanel.domain.Image;
import com.cexpress.adminpanel.domain.dto.EmployeeDTO;
import com.cexpress.adminpanel.oauth.SettingsRepository;
import com.cexpress.adminpanel.service.implementation.EmployeeService;
import com.cexpress.adminpanel.service.implementation.RoleService;




/**
 * @author Aritra
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@Autowired
	RoleService roleService;
	
	@Autowired
	SettingsRepository settings; 
	@Value("${cexpressapi.file.location}")
	private String baseLocation;

	@Value("${cexpressapi.default.imageid}")
	private String defaultImageId;
	
	@GetMapping("/add")
	public ModelAndView addEmployeeShow() {
		ModelAndView modelandview = new ModelAndView("employee/create");
		
		//System.out.println(settings.toString());
		EmployeeDTO employee = new EmployeeDTO();

		Image profilePicture = new Image();

		// Redundant code.
		  profilePicture.setId(defaultImageId); profilePicture.setUrl(
		  "7RL3BL97GTN8Z5WQDTMSKIRTUDWXUF8G9MRIQE4VK4AKPBWEZMZB957WDYASLXZW5O1T6QIJL50W3BLQDSLQHX2RCUZSE465V8JOpic21623014341647434275.jpg"
		  );
		  employee.setProfilePictureId(defaultImageId);


		  employee.setProfilePicture(profilePicture);		
		  employee.setCreatedBy(settings.getUserId());
		  employee.setGender("Male");
		  employee.setMaritalStatus("Married");
		
		modelandview.addObject("employee", employee);

		modelandview.addObject("roleList", roleService.getAllRoles());

		

		List<String> bloodgroupList = new ArrayList<>();
		bloodgroupList.add("A +ve");
		bloodgroupList.add("B +ve");
		bloodgroupList.add("O +ve");
		bloodgroupList.add("AB +ve");
		bloodgroupList.add("A -ve");
		bloodgroupList.add("B -ve");
		bloodgroupList.add("O -ve");
		bloodgroupList.add("AB -ve");
		modelandview.addObject("bloodgroupList", bloodgroupList);
		modelandview.addObject("baseLocation", baseLocation);
		return modelandview;
	}
	@PostMapping("/create")

	public ModelAndView createEmployee(EmployeeDTO employee, ModelMap model) {
		
		
		System.out.println("from employee create" + employee.toString());
		EmployeeDTO emp = empService.createEmployee(employee);
		System.out.println("from employee create" + employee.toString());
		String redirectUrl = "/employee/view";
		
		return new ModelAndView("redirect:" + redirectUrl, model);
	}
	

}
