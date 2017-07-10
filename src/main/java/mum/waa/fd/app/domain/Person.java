package mum.waa.fd.app.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@MappedSuperclass

public abstract class Person {

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "LAST_NAME")
	private String lastName;

	@NotNull(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@NotNull
	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.MALE;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Pattern(regexp = FamilyDoctorConstants.PHONE_REGEX, message = FamilyDoctorConstants.PHONE_VALIDATION)
	@Column(name = "PHONE")
	private String phone;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	/**
	 * <p>Constructor for Person.</p>
	 */
	public Person() {
		// default constructor
	}

	
	public Person(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.user = user;
		this.address = address;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	public Gender getGender() {
		return gender;
	}

	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	public String getPhone() {
		return phone;
	}

	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}

	
	public Address getAddress() {
		return address;
	}

	
	public void setAddress(Address address) {
		this.address = address;
	}
}
