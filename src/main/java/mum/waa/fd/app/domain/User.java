package mum.waa.fd.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity

@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = -622855600192016623L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int userId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Email(message = FamilyDoctorConstants.EMAIL_VALIDATION)
	@Column(name = "EMAIL", unique = true)
	private String email;

	@Size(min = 5, max = 100, message = FamilyDoctorConstants.RANGE_LETTERS_VALIDATION)
	@Column(name = "PASSWORD")
	private String password;

	@Size(min = 5, max = 100, message = FamilyDoctorConstants.RANGE_LETTERS_VALIDATION)
	@Transient
	private String confirmPassword;

	@NotNull
	@Column(name = "ENABLED")
	private Boolean enabled;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")
	private List<Authority> authorities;

	
	public User() {
		this.enabled = Boolean.TRUE;
		this.authorities = new ArrayList<Authority>();
	}

	
	public int getUserId() {
		return userId;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public Boolean getEnabled() {
		return enabled;
	}

	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	
}
