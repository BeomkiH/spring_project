package com.shop.www;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class web_Controller {

	PrintWriter pw = null;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/ajaxok3.do")
	public String ajaxok3(@RequestBody String arrData, HttpServletResponse res) throws Exception{
		
	     JSONArray jo = new JSONArray(arrData);
	     
	     for (int i = 0; i < jo.length(); i++) {
	    	 
	     JSONArray ja = jo.getJSONArray(i);
	     
	     for (int j = 0; j < ja.length(); j++) {
	     
	    	 System.out.println(ja.getString(j));
	        }
	   }
	    
	     this.pw = res.getWriter();
	     this.pw.print("ok:::::::::::");
		
		return null;
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/ajaxok2.do")
	public String ajaxok2(@RequestBody String all_data, HttpServletResponse res) throws Exception {
		
		JSONObject jo = new JSONObject(all_data);
		System.out.println(jo.get("all_data"));
		
		JSONArray ja = jo.getJSONArray("all_data");

	    for (int j = 0; j < ja.length(); j++) {
	           
	    	System.out.println(ja.getString(j));
	    }
		
	    JSONObject result = new JSONObject();
		result.put("result", "OK::::");
		this.pw = res.getWriter();
		this.pw.print(result);
		
	    
		return null;
	}
	
	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/ajaxok.do")
	public String ajaxok(@RequestParam(value ="alldata") List<String> alldata, HttpServletResponse res) throws Exception{
		
		System.out.println(alldata);
		this.pw = res.getWriter();
		JSONObject jo = new JSONObject();
		jo.put("result", "OK::::");
		this.pw.print(jo);
		
		this.pw.close();
		
		
		return null;
	}
}
