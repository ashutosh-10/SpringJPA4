package com.service;

import java.util.List;

import com.entity.Coder;

public interface CoderService {
	
	public Coder getCoder(int cid) throws Throwable;
	
	public List<Coder> getCoders();
	
	public Coder addCoder(Coder c);
	
	public List<Coder> addCoders(List<Coder> c);
	
	public String deleteCoder(Coder c);
	
	public String deleteCoderById(int cid);
	
	public Coder updateCoder(Coder c);
	
	public Coder getCoderByCname(String cname);
	public List<Coder> getCoderByTechSorted(String tech);
	
	
	
	
	

}
