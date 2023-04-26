package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import java.util.List;


@Entity
public class Customer {

private Integer id;
private String name;
//private List<OrderDetails> orders;
private long phone;
private String email;

public Customer() {
	
}
public Customer(Integer id, String name, long phone, String email) {
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.email = email;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
//public List<OrderDetails> getOrders() {
//	return orders;
//}
//public void setOrders(List<OrderDetails> orders) {
//	this.orders = orders;
//}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
}
//public String toString() {
//	return "Customer [id=" + id + ", name=" + name + ", orders=" + orders + ", phone=" + phone + ", email=" + email
//			+ "]";
//}


}
