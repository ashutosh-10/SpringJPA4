package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.ResourceNotFoundException;
import com.entity.Coder;
import com.repository.CoderRepository;


@Service
public class CoderServiceImpl implements CoderService {
	
	
	@Autowired
	CoderRepository repo; //because we have to get the data from DAO layer which is repository layer

	@Override
	public Coder getCoder(int cid) throws Throwable{
//		Optional c = repo.findById(cid);
//		Coder c1 = (Coder) c.get();
		Supplier s1 = ()->new ResourceNotFoundException("Coder does not exist in database");
		Coder c = repo.findById(cid).orElseThrow(s1);
		return c;
		
	}
	



	@Override
	public List<Coder> getCoders() {
		List<Coder> lc =  repo.findAll();
		return lc;
	}

	@Override
	public Coder addCoder(Coder c) {
		repo.save(c);
		return c;
	}

	@Override
	public List<Coder> addCoders(List<Coder> c) {
		
		repo.saveAll(c);
		return c;
	}

	@Override
	public String deleteCoder(Coder c) {
		repo.delete(c);
		return "deleted";
	}

	@Override
	public String deleteCoderById(int cid) {
		repo.deleteById(cid);
		return "deleted by id";
	}

	@Override
	public Coder updateCoder(Coder c) {
		int i = c.getCid();
		Coder c1 = repo.findById(i).orElseThrow();
		c1.setCname(c.getCname());
		c1.setTech(c.getTech());
		repo.save(c1);	
		return c1;
	}

	@Override
	public Coder getCoderByCname(String cname) {
		// TODO Auto-generated method stub
		Coder c  = repo.getCoderByCname(cname);
		return c;
	}

	@Override
	public List<Coder> getCoderByTechSorted(String tech) {
		List<Coder> c1 = repo.getCoderByTechSorted(tech);
		return c1;
	}


	
	
//	
//	public Coder getCoderByCname(String cname)
//	{
//		Coder c  = repo.getCoderByCname(cname);
//		return c;
//	}
//	
//	public List<Coder> getCoderByTechSorted(String tech)
//	{
//		List<Coder> c1 = repo.getCoderByTechSorted(tech);
//		return c1;
//	}



}
