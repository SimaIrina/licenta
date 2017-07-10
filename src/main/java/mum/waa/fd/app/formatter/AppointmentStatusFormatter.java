package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.AppointmentStatus;


public class AppointmentStatusFormatter implements Formatter<AppointmentStatus> {

	/** {@inheritDoc} */
	@Override
	public String print(AppointmentStatus appointmentStatus, Locale locale) {
		return appointmentStatus.name();
	}

	/** {@inheritDoc} */
	@Override
	public AppointmentStatus parse(String text, Locale locale) throws ParseException {
		return AppointmentStatus.valueOf(text);
	}
}
