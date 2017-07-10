package mum.waa.fd.app.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import mum.waa.fd.app.util.FamilyDoctorConstants;
import mum.waa.fd.app.util.FamilyDoctorUtil;

@Entity

@Table(name = "Invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int invoiceId;

	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	@Column(name = "DATE_CREATED")
	private Date dateCreated;

	@Digits(integer = 6, fraction = 2, message = FamilyDoctorConstants.AMOUNT_VALIDATION)
	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@NotNull
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private InvoiceStatus status = InvoiceStatus.NEW;

	@Column(name = "CCARD_4DIGITS")
	private String ccardLast4Digits;

	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	@Column(name = "DATE_PAID")
	private Date datePaid;

	@PrePersist
	private void setDate() {
		this.dateCreated = FamilyDoctorUtil.getCurrentDate();
	}

	
	public int getInvoiceId() {
		return invoiceId;
	}

	
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	
	public Date getDateCreated() {
		return dateCreated;
	}

	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	public BigDecimal getAmount() {
		return amount;
	}

	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	
	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	
	public String getCcardLast4Digits() {
		return ccardLast4Digits;
	}

	
	public void setCcardLast4Digits(String ccardLast4Digits) {
		this.ccardLast4Digits = ccardLast4Digits;
	}

	
	public Date getDatePaid() {
		return datePaid;
	}

	
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}
}
