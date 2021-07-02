package com.sirsavio.estudo.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.BoletoPayment;

@Service
public class BoletoService {
	public void generateBoletoPayment(BoletoPayment pag, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pag.setDueDate(cal.getTime());
	}
}
