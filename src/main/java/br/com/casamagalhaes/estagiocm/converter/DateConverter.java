package br.com.casamagalhaes.estagiocm.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.expression.ParseException;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;

@Convert(Date.class)
public class DateConverter implements Converter<Date> {

	@Override
	public Date convert(String value, Class<? extends Date> arg1, ResourceBundle arg2) {
		// TODO Auto-generated method stub
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}