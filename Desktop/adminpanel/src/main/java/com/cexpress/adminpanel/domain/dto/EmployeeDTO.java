/**
 * 
 */
package com.cexpress.adminpanel.domain.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cexpress.adminpanel.domain.Image;



/**
 * @author Aritra
 *
 */
public class EmployeeDTO {
	private String id;
	private String username;
	private String password;
	private String roleId;
	private String companyId;
	private String firstName;

	private String lastName;
	
	private String nationality;
	private String nationalId;
	private String passportNumber;
	private String maritalStatus;
	private String  gender;
	private Integer age;
	private Long createdBy;
	private String mobile;
	private String email;
	private String presentAddress;
	private String permanentAddress;
	private String emergencyContactName;
	private String relation;
	private String emergencyContactMobile;
	private String emergencyContactAddress;
	private String designation;
	private String licenseNumber;
	
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	private String bloodGroup;
	private String profilePictureId;
	
	private Image profilePicture;
	private String userType;

	private String religion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	public String getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRoleId() {
		return roleId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNationality() {
		return nationality;
	}
	public String getNationalId() {
		return nationalId;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public String getGender() {
		return gender;
	}
	public Integer getAge() {
		return age;
	}
	
	public String getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public String getRelation() {
		return relation;
	}
	public String getEmergencyContactMobile() {
		return emergencyContactMobile;
	}
	public String getEmergencyContactAddress() {
		return emergencyContactAddress;
	}
	public String getDesignation() {
		return designation;
	}
	public String getLicenceNumber() {
		return licenseNumber;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public String getProfilePictureId() {
		return profilePictureId;
	}
	public Image getProfilePicture() {
		return profilePicture;
	}
	public String getUserType() {
		return userType;
	}
	public String getReligion() {
		return religion;
	}
	public Date getDob() {
		return dob;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public void setEmergencyContactMobile(String emergencyContactMobile) {
		this.emergencyContactMobile = emergencyContactMobile;
	}
	public void setEmergencyContactAddress(String emergencyContactAddress) {
		this.emergencyContactAddress = emergencyContactAddress;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public void setProfilePictureId(String profilePictureId) {
		this.profilePictureId = profilePictureId;
	}
	public void setProfilePicture(Image profilePicture) {
		this.profilePicture = profilePicture;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", username=" + username + ", password=" + password + ", roleId=" + roleId
				+ ", companyId=" + companyId + ", firstName=" + firstName + ", lastName=" + lastName + ", nationality="
				+ nationality + ", nationalId=" + nationalId + ", passportNumber=" + passportNumber + ", maritalStatus="
				+ maritalStatus + ", gender=" + gender + ", age=" + age + ", createdBy=" + createdBy + ", mobile="
				+ mobile + ", email=" + email + ", presentAddress=" + presentAddress + ", permanentAddress="
				+ permanentAddress + ", emergencyContactName=" + emergencyContactName + ", relation=" + relation
				+ ", emergencyContactMobile=" + emergencyContactMobile + ", emergencyContactAddress="
				+ emergencyContactAddress + ", designation=" + designation + ", licenseNumber=" + licenseNumber
				+ ", bloodGroup=" + bloodGroup + ", profilePictureId=" + profilePictureId + ", profilePicture="
				+ profilePicture + ", userType=" + userType + ", religion=" + religion + ", dob=" + dob
				+ ", joiningDate=" + joiningDate + "]";
	}
	
	
	
	
}
