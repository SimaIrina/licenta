package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.Specialization;

public class SpecializationFormatter implements Formatter<Specialization> {

	/** {@inheritDoc} */
	@Override
	public String print(Specialization specialization, Locale locale) {
		return specialization.name();
	}

	/** {@inheritDoc} */
	@Override
	public Specialization parse(String text, Locale locale) throws ParseException {
		return Specialization.valueOf(text);
	}
}
