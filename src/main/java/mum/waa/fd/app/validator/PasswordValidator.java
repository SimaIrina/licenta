package mum.waa.fd.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mum.waa.fd.app.domain.Patient;
import mum.waa.fd.app.util.FamilyDoctorConstants;


public class PasswordValidator implements Validator {

	/** {@inheritDoc} */
	@Override
	public boolean supports(Class<?> clazz) {
		return Patient.class.isAssignableFrom(clazz);
	}

	/** {@inheritDoc} */
	@Override
	public void validate(Object target, Errors errors) {
		Patient patient = (Patient) target;
		if (!patient.getUser().getPassword().equals(patient.getUser().getConfirmPassword())) {
			errors.rejectValue("user.password", FamilyDoctorConstants.PASSWORD_NOTMATCH_VALIDATION);
		}
	}
}
