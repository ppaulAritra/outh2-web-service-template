/**
 * 
 */
package com.cexpress.adminpanel.domain;

/**
 * @author Aritra
 *
 */
public class Role {

	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
