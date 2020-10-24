package com.isoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class IndexController {
	@RequestMapping(value = "/index")
	public String indexMethod(HttpServletRequest request) {

		System.out.println("indexMethod got it...");
		return "index";   // /WEB-INF/jsp/index.jsp

	}
	
	@RequestMapping(value = "/second")
	public String secondMethod(HttpServletRequest request) {

		System.out.println("secondMethod got it...");
		return "second";   // /WEB-INF/jsp/index.jsp

	}
	
	@ResponseBody
	@RequestMapping(value = "/third")
	public String thirdMethod(HttpServletRequest request) {

		System.out.println("thirdMethod got it...");
		return "third";    

	}
	
	//---------------------------@RequestParam------------------------------
	
	//http://localhost:8080/springMVC-learn/mvc/four?word=USA
	//默认参数名和方法形参一样
	@ResponseBody
	@RequestMapping(value = "/four")
	public String fourMethod(@RequestParam String word) {

		System.out.println("fourMethod got it...");
		return "hello " + word;   

	}
	
	
	
    //http://localhost:8080/springMVC-learn/mvc/five?mpara=British
    @RequestMapping(value = "/five")
    @ResponseBody
    public String fiveMethod(@RequestParam(value="mpara") String word)  {//如果形参和url @RequestMapping 的参数名不一样，则需显示
    	System.out.println("fiveMethod got it...");
    	return "hello " + word;
    }
	
	
    
    //--------------------@PathVariable------------------------------
    
    
	//http://localhost:8080/springMVC-learn/mvc/say/jerry
	@RequestMapping(value = "/say/{name}")
	@ResponseBody
	public String sixMethod(@PathVariable String name) {
		System.out.println("sixMethod got it...");
	    return "hello "+name;
	}
    
    
	
	//http://localhost:8080/springMVC-learn/mvc/xxx/tom
	@RequestMapping(value = "/xxx/{name}")
	@ResponseBody
	public String sevenMethod(@PathVariable("name") String p) { //如果形参和url @RequestMapping 的参数名不一样，则需显示
		System.out.println("sevenMethod got it...");
	    return "say "+p;
	}
    
    
    
    
    
    
	
	
}
