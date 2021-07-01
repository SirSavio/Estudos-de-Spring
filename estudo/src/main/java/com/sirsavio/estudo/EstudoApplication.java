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
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama mesa e banho");
		Category cat4 = new Category(null, "Eletrônicos");
		Category cat5 = new Category(null, "Jardinagem");
		Category cat6 = new Category(null, "Decoração");
		Category cat7 = new Category(null, "Perfumaria");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		Product p4 = new Product(null, "Mesa de escritório", 300.00);
		Product p5 = new Product(null, "Toalha", 50.00);
		Product p6 = new Product(null, "Colcha", 200.00);
		Product p7 = new Product(null, "TV true color", 1200.00);
		Product p8 = new Product(null, "Roçadeira", 800.00);
		Product p9 = new Product(null, "Abajour", 100.00);
		Product p10 = new Product(null, "Pendente", 180.00);
		Product p11 = new Product(null, "Shampoo", 90.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		cat3.getProducts().addAll(Arrays.asList(p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9, p10));
		cat7.getProducts().addAll(Arrays.asList(p11));
		
		p1.getCategories().addAll(Arrays.asList(cat1, cat4));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat1, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat6));
		p11.getCategories().addAll(Arrays.asList(cat7));		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");
		
		City cid1 = new City(null, "Uberlandia", est1);
		City cid2 = new City(null, "São Paulo", est2);
		City cid3 = new City(null, "Campinas", est2);
		
		est1.getCities().addAll(Arrays.asList(cid1));
		est2.getCities().addAll(Arrays.asList(cid2, cid3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "00000000000", ClientType.PF);
		cli1.getPhones().addAll(Arrays.asList("99999999", "11111111"));
		
		Address e1 = new Address(null, "Rua Flores", "300", "Apt 303", "Jardim", "35931188", cli1, cid1);
		Address e2 = new Address(null, "Rua Jardim", "55", "Apt 101", "Campo Bom", "35931188", cli1, cid2);
		
		cli1.getAddresses().addAll(Arrays.asList(e1, e2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Order ped1 = new Order(null, date.parse("30/09/2021 10:32"), cli1, e1);
		Order ped2 = new Order(null, date.parse("29/08/2021 10:32"), cli1, e2);
		
		Payment pag1 = new CardPayment(null, Status.QUITADO, ped1, 6);
		ped1.setPayment(pag1);
		
		Payment pag2 = new BoletoPayment(null, Status.PENDENTE, ped2, date.parse("20/10/2017 00:00"), null);
		ped2.setPayment(pag2);
		
		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));
		
		orderRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pag1, pag2));
		
		OrderItem oi1 = new OrderItem(ped1, p1, 0.00, 1, 2000.00);
		OrderItem oi2 = new OrderItem(ped1, p3, 0.00, 2, 80.00);
		OrderItem oi3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItems().addAll(Arrays.asList(oi1, oi2));
		ped2.getItems().add(oi3);
		
		p1.getItems().addAll(Arrays.asList(oi1));
		p2.getItems().addAll(Arrays.asList(oi3));
		p3.getItems().addAll(Arrays.asList(oi2));
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
		
	}

}
