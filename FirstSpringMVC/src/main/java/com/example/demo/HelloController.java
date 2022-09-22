package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello()
	{
		System.out.println("in hello");
		return "Welcome to Spring MVC";
	}
	
	
	@RequestMapping("getCoder")
	@ResponseBody
	public Coder getCoderRealQuick()
	{
		Coder c = new Coder();
		c.setCid(101);
		c.setCname("Ashutosh");
		c.setTech("Python Django.....Spring destroyed");
		
		return c;
	}
	
}
