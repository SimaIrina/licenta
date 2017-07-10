package mum.waa.fd.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity

@Table(name = "Admin")
public class Admin extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int adminId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "STAFF_NUMBER")
	private String staffNumber;

	/**
	 * <p>Constructor for Admin.</p>
	 */
	public Admin() {
		// default constructor
	}

	
	public Admin(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Address address, String staffNumber) {
		super(firstName, lastName, dateOfBirth, gender, phone, user, address);
		this.staffNumber = staffNumber;
	}

	
	public int getAdminId() {
		return adminId;
	}

	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	
	public String getStaffNumber() {
		return staffNumber;
	}

	
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
}
