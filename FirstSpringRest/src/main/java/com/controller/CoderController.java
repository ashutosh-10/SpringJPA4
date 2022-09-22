package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.service.CoderService;

@RestController
@RequestMapping("api")
public class CoderController {
	@Autowired
	CoderService coderservice;
	
	
	
	@GetMapping("/getCoder/{cid}")
	public Coder getCoder(@PathVariable int cid) throws Throwable
	{
			Coder c1 = coderservice.getCoder(cid);
			return c1;
	}
	
	
	@GetMapping("/getCoders")
	public List<Coder> getCoders()
	{
		return coderservice.getCoders();
	}
	
	
	
	@PostMapping("/addcoder")
	public Coder addCoders(@RequestBody Coder c)
	{
		Coder rc =coderservice.addCoder(c);
		return rc;
	}
	
	
	
	@PostMapping("/addcoders")
	public List<Coder> addCoders(@RequestBody List<Coder> c)
	{
		List<Coder> rl = coderservice.addCoders(c);
		return rl;
	}
	
	
	@DeleteMapping("/deletecoder")
	public String deletecoder(@RequestBody Coder c)
	{
		String s = coderservice.deleteCoder(c);
		return s;
		
	}
	
	
	@DeleteMapping("/deletecoderbyid/{cid}")
	public String deletecoderById(@PathVariable int cid)
	{
		String s = coderservice.deleteCoderById(cid);
		return s;
		
	}
	
	
	@PutMapping("/updatecoder")
	public Coder updateCoder(@RequestBody Coder c)
	{
		Coder c1 = coderservice.updateCoder(c);
		return c1;
	}
	
	
	@GetMapping("/getcoderbycname/{cname}")
	public Coder getCoderByCname(@PathVariable String cname)
	{
		Coder c = coderservice.getCoderByCname(cname);
		return c;
	}
	
	
	
	@GetMapping("/getcoderbytechsorted/{tech}")
	public List<Coder> getCoderByTechSorted(@PathVariable String tech)
	{
		List<Coder> c = coderservice.getCoderByTechSorted(tech);
		return c;
	}
	
	
	
	
}
