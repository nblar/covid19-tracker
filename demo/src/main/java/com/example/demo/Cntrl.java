package com.example.demo;

import java.util.HashMap;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import resources.COVID19;

//@CrossOrigin(origins = "")
@RestController
@RequestMapping("info")

public class Cntrl {
    @CrossOrigin(origins="*")
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public HashMap<Object,Object> getinfo()
	{   System.out.println("INSIDE");
		COVID19 data=new COVID19(); //ResponseEntity<?>
		data.runfunction();
		
		HashMap<Object,Object> stats=new HashMap<Object,Object>();
		stats.putAll(data.getInfy());
		
		return stats;
	}
	
}
