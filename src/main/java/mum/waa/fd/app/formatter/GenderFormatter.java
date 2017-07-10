package mum.waa.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.waa.fd.app.domain.Gender;


public class GenderFormatter implements Formatter<Gender> {

	/** {@inheritDoc} */
	@Override
	public String print(Gender gender, Locale locale) {
		return gender.name();
	}

	/** {@inheritDoc} */
	@Override
	public Gender parse(String text, Locale locale) throws ParseException {
		return Gender.valueOf(text);
	}
}
