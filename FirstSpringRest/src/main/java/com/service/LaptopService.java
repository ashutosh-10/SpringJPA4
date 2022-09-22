package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Coder;
import com.entity.Laptop;
import com.repository.LaptopRepo;

@Service
public class LaptopService {
	@Autowired
	LaptopRepo repo;
	
	public Laptop addLaptop(Laptop l)
	{
		repo.save(l);
		return l;
	}

	

}
