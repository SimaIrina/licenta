package mum.waa.fd.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity

@Table(name = "Doctor")
public class Doctor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int doctorId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "LICENSE_NUMBER")
	private String licenseNumber;

	@NotNull
	@Column(name = "SPECIALIZATION")
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "DOCTOR_ID")
	private List<Appointment> appointmentList;

	
	public Doctor() {
		// default constructor
	}

	
	public Doctor(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Address address, String licenseNumber, Specialization specialization) {
		super(firstName, lastName, dateOfBirth, gender, phone, user, address);
		this.licenseNumber = licenseNumber;
		this.specialization = specialization;
		appointmentList = new ArrayList<Appointment>();
	}

	
	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}

	
	public int getDoctorId() {
		return doctorId;
	}

	
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	
	public String getLicenseNumber() {
		return licenseNumber;
	}

	
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	
	public Specialization getSpecialization() {
		return specialization;
	}

	
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
