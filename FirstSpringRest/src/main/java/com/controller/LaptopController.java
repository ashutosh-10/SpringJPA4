package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.entity.Laptop;
import com.service.LaptopService;

@RestController
@RequestMapping("/api")
public class LaptopController {
	
	@Autowired
	LaptopService ls;
	
	@PostMapping("/addlaptop")
	public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop l)
	{
		Laptop l1 = ls.addLaptop(l);
//		return l1;
		ResponseEntity re=new ResponseEntity<Laptop>(l1,HttpStatus.OK);
		return re;
	}
	
//	@PostMapping("/addLaptop")
//	public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop l)
//	{
//		Laptop l1=ls.addLaptop(l);
//		ResponseEntity re=new ResponseEntity<Laptop>(l1,HttpStatus.OK);
//		return re;
//	}
	
	
	

	
}
