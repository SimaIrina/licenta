package mum.waa.fd.app.domain;

import java.util.Date;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity

@Table(name = "Appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int appointmentId;

	@NotNull(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	@Column(name = "DATE")
	private Date date;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "TIME")
	@Size(min = 1, max = 10, message = FamilyDoctorConstants.RANGE_LETTERS_VALIDATION)
	private String time;

	@Column(name = "ROOM")
	private String room;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "DESCRIPTION")
	private String description;

	@NotNull
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status = AppointmentStatus.NEW;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Patient.class)
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Doctor.class)
	@JoinColumn(name = "DOCTOR_ID")
	private Doctor doctor;

	
	public Appointment() {
		this.invoice = new Invoice();
		this.patient = new Patient();
		this.doctor = new Doctor();
	}

	public Appointment(Date date, String room, AppointmentStatus status) {
		this.date = date;
		this.room = room;
		this.status = status;
	}

	
	public int getAppointmentId() {
		return appointmentId;
	}

	
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	
	public Date getDate() {
		return date;
	}

	
	public void setDate(Date date) {
		this.date = date;
	}

	
	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	
	public String getRoom() {
		return room;
	}

	
	public void setRoom(String room) {
		this.room = room;
	}

	
	public String getTime() {
		return time;
	}

	
	public void setTime(String time) {
		this.time = time;
	}


	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
	public Patient getPatient() {
		return patient;
	}

	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
