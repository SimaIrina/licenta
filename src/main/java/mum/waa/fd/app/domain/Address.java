package mum.waa.fd.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity

@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int addressId;

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Pattern(regexp = FamilyDoctorConstants.STATE_REGEX, message = FamilyDoctorConstants.STATE_VALIDATION)
	@Column(name = "STATE")
	private String state;

	@Pattern(regexp = FamilyDoctorConstants.ZIPCODE_REGEX, message = FamilyDoctorConstants.ZIPCODE_VALIDATION)
	@Column(name = "ZIPCODE")
	private String zipcode;

	/**
	 * <p>Constructor for Address.</p>
	 */
	public Address() {
		// default constructor
	}

	
	public Address(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	
	public int getAddressId() {
		return addressId;
	}

	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	
	public String getStreet() {
		return street;
	}

	
	public void setStreet(String street) {
		this.street = street;
	}

	
	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	
	public String getState() {
		return state;
	}

	
	public void setState(String state) {
		this.state = state;
	}

	
	public String getZipcode() {
		return zipcode;
	}

	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
