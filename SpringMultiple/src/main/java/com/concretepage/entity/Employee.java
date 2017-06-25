package com.concretepage.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Employee")

public class Employee implements Serializable {
     
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	 private int id;
	
	public Set<Addresses> getAddress() {
		return address;
	}

	public void setAddress(Set<Addresses> address) {
		this.address = address;
	}

	@Size(min=5, max=20)
	@Column(name = "firstName")
    private String firstName;
	
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Addresses> address;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Size(min=5, max=20)
	@Column(name = "lastName")
	private String lastName;
	
	@Min(18)
	@Max(100)
	@Column(name = "age")
    private int age;
	
	@NotNull
	@Column(name = "gender")
    private String gender;
	
	@Size(min=5, max=20)
	@Column(name = "username")
    private String username;
	@Size(min=8, max=15)
	@Column(name = "password")
    private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	private static Map<String, String> cityMap = new HashMap<String, String>(); 
	private static Map<String, String> genderOptions = new HashMap<String, String>();	
	public static Map<String, String> getPersonMap() {
		if (cityMap.size() == 0) {
			cityMap.put("Varanasi", "Varanasi");
			cityMap.put("Allahabad", "Allahabad");
			cityMap.put("Ghaziabad", "Ghaziabad");
			cityMap.put("Noida", "Noida");
		}
		return cityMap;
	}
	public static Map<String, String> getGenderOptions() {
        if(genderOptions.size() == 0) {
        	genderOptions.put("M", "Male");
        	genderOptions.put("F", "Female");
        }
        return genderOptions;
	}
}
