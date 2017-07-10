package mum.waa.fd.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity

@Table(name = "Patient")
public class Patient extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int patientId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Size(min = 4, max = 4, message = FamilyDoctorConstants.EXACTLY_DIGITS_VALIDATION)
	@Column(name = "SSN")
	private String ssn;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PATIENT_ID")
	private List<Appointment> appointmentList;

	/**
	 * <p>Constructor for Patient.</p>
	 */
	public Patient() {
		// default constructor
	}

	
	public Patient(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Address address, String ssn) {
		super(firstName, lastName, dateOfBirth, gender, phone, user, address);
		this.ssn = ssn;
		appointmentList = new ArrayList<Appointment>();
	}

	
	public int getPatientId() {
		return patientId;
	}

	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	
	public String getSsn() {
		return ssn;
	}

	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	
	public String getSSN() {
		return ssn;
	}

	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
