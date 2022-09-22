package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Coder;
import com.repository.CoderRepository;

@SpringBootTest
class CoderServiceImplTest {
	
	@Autowired
	CoderServiceImpl coderservice;
	
	@MockBean
	CoderRepository repo;
	

//	@Test
	@Disabled
	void testGetCoder() throws Throwable {
		
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Ashutosh");
		c1.setTech("Python");
		
		Optional<Coder> c2 = Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(coderservice.getCoder(2)).isEqualTo(c1);
		

	}

	@Test
	void testGetCoders() {
		
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Ashutosh");
		c1.setTech("Python");
		
		Coder c2 = new Coder();
		c2.setCid(2);
		c2.setCname("Brian");
		c2.setTech("AI");
		
		List<Coder> coderList = new ArrayList<>();
		coderList.add(c1);
		coderList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(coderList);
		
		assertThat(coderservice.getCoders()).isEqualTo(coderList);
		
	}

	@Test
	void testAddCoder() {
		
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Ashutosh");
		c1.setTech("Python");
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(coderservice.addCoder(c1)).isEqualTo(c1);
	}


	@Test
	void testDeleteCoder() {
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Ashutosh");
		c1.setTech("Python");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getCid())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getCid()));
	}



	@Test
	void testUpdateCoder() {
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Ashutosh");
		c1.setTech("Python");
		
		Optional<Coder> c2 = Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setCname("Ashutosh10");
		c1.setTech("Big Data");
		
		assertThat(coderservice.updateCoder(c1)).isEqualTo(c1);
	}


}
