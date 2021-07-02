package com.sirsavio.estudo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sirsavio.estudo.domain.Address;
import com.sirsavio.estudo.domain.BoletoPayment;
import com.sirsavio.estudo.domain.CardPayment;
import com.sirsavio.estudo.domain.Category;
import com.sirsavio.estudo.domain.City;
import com.sirsavio.estudo.domain.Client;
import com.sirsavio.estudo.domain.Order;
import com.sirsavio.estudo.domain.OrderItem;
import com.sirsavio.estudo.domain.Payment;
import com.sirsavio.estudo.domain.Product;
import com.sirsavio.estudo.domain.State;
import com.sirsavio.estudo.domain.enums.ClientType;
import com.sirsavio.estudo.domain.enums.Status;
import com.sirsavio.estudo.repositories.AddressRepository;
import com.sirsavio.estudo.repositories.CategoryRepository;
import com.sirsavio.estudo.repositories.CityRepository;
import com.sirsavio.estudo.repositories.ClientRepository;
import com.sirsavio.estudo.repositories.OrderItemRepository;
import com.sirsavio.estudo.repositories.OrderRepository;
import com.sirsavio.estudo.repositories.PaymentRepository;
import com.sirsavio.estudo.repositories.ProductRepository;
import com.sirsavio.estudo.repositories.StateRepository;

@SpringBootApplication
public class EstudoApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
