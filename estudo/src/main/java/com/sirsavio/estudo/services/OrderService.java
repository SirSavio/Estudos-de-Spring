package com.sirsavio.estudo.services;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.BoletoPayment;
import com.sirsavio.estudo.domain.Order;
import com.sirsavio.estudo.domain.OrderItem;
import com.sirsavio.estudo.domain.enums.Status;
import com.sirsavio.estudo.repositories.OrderItemRepository;
import com.sirsavio.estudo.repositories.OrderRepository;
import com.sirsavio.estudo.repositories.PaymentRepository;
import com.sirsavio.estudo.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repo;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private ProductService productService;
	
	public Order findById(Integer id) {
		Optional<Order> cate = repo.findById(id);
		
		return cate.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Order.class.getName())); 
	}
	
	public Order create(Order obj) {
		obj.setId(null);
		obj.setDate(new Date(0));
		obj.getPayment().setStatus(Status.PENDENTE);
		obj.getPayment().setOrder(obj);
		if(obj.getPayment() instanceof BoletoPayment) {
			BoletoPayment pay = (BoletoPayment) obj.getPayment();
			boletoService.generateBoletoPayment(pay, obj.getDate());
		}
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());
		
		for(OrderItem item : obj.getItems()) {
			item.setDiscount(0.0);
			item.setPrice(productService.findById(item.getProduct().getId()).getPrice());
			item.setOrder(obj);
		}
		
		orderItemRepository.saveAll(obj.getItems());
		return obj;
	}
}
