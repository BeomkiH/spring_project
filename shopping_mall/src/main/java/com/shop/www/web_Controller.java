package com.shop.www;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class web_Controller {
	
	@GetMapping("/restApi.do")
	public String restApi(@SessionAttribute(name="mid", required = false) String mid) throws Exception  {
		
		if(mid==null){
			System.out.println("로그인해야만 결재내역을 확인하실 수 있습니다.");
		}
		else {
			System.out.println("결재내역은 다음과 같습니다.");
			
		}
		return null;
	}
	@PostMapping("/loginok.do") 
	public String loginok(@RequestParam(value="", required = false) String mid,HttpSession session) {
		if(mid != null || mid != "") {
		session.setAttribute("mid", mid);
		session.setMaxInactiveInterval(1800);
		
		}
		
		return null;
	}
	/*
	 * @PostMapping("/loginok.do") 
	 * public String loginok(String mid,
	 * HttpServletRequest req) {
	 * 
	 * HttpSession session = req.getSession(); session.setAttribute("mid", mid);
	 * session.setMaxInactiveInterval(1800); System.out.println(mid); return null; }
	 */

	PrintWriter pw = null;
	
	 	@CrossOrigin(origins = "*", allowedHeaders = "*")
	    @PostMapping("/ajaxok4.do")
	    public String ajaxok4(@RequestBody String basketData, HttpServletResponse res) throws Exception {
	        JSONArray ja = new JSONArray(basketData);
	        
	        for (int i = 0; i < ja.length(); i++) {
	            JSONObject jo = ja.getJSONObject(i);
	            System.out.println("Seq: " + jo.getString("seq"));
	            System.out.println("Product: " + jo.getString("product"));
	            System.out.println("Price: " + jo.getString("price"));
	        }
	        
	        JSONObject responseJson = new JSONObject();
	        responseJson.put("result", "OK::::");

	       
	        this.pw = res.getWriter();
	        this.pw.print(responseJson.toString());
	       
	        
	        return null;
	    }
	
	
	
	
	
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
