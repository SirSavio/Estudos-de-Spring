package com.sirsavio.estudo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sirsavio.estudo.domain.Address;
import com.sirsavio.estudo.domain.Category;
import com.sirsavio.estudo.domain.City;
import com.sirsavio.estudo.domain.Client;
import com.sirsavio.estudo.domain.Product;
import com.sirsavio.estudo.domain.State;
import com.sirsavio.estudo.domain.enums.ClientType;
import com.sirsavio.estudo.repositories.AddressRepository;
import com.sirsavio.estudo.repositories.CategoryRepository;
import com.sirsavio.estudo.repositories.CityRepository;
import com.sirsavio.estudo.repositories.ClientRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product prod1 = new Product(null, "Computador", 2000.00);
		Product prod2 = new Product(null, "Impressora", 8000.00);
		Product prod3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));
		
		prod1.getCategories().addAll(Arrays.asList(cat1));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
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
		
		
	}

}
