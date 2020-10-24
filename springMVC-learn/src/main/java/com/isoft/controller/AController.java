package com.isoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
*@author anonymous
*@createTime 2020年10月24日 下午9:58:08
*@describe
*/

@RestController
@RequestMapping("/a")
public class AController {
	@RequestMapping(value = "/second")
	public String secondMethod(HttpServletRequest request) {

		System.out.println("secondMethod got it...");
		return "second";   

	}
	
	//---------------------------@RequestParam------------------------------
	
		//http://localhost:8080/springMVC-learn/a/four?word=USA
		//默认参数名和方法形参一样
		@RequestMapping(value = "/four")
		public String fourMethod(@RequestParam String word) {

			System.out.println("fourMethod got it...");
			return "hello " + word;   

		}
		
		
		
	    //http://localhost:8080/springMVC-learn/a/five?mpara=British
	    @RequestMapping(value = "/five")
	    public String fiveMethod(@RequestParam(value="mpara") String word)  {//如果形参和url @RequestMapping 的参数名不一样，则需显示
	    	System.out.println("fiveMethod got it...");
	    	return "hello " + word;
	    }
		
		
	    
	    //--------------------@PathVariable------------------------------
	    
	    
		//http://localhost:8080/springMVC-learn/a/say/jerry
		@RequestMapping(value = "/say/{name}")
		public String sixMethod(@PathVariable String name) {
			System.out.println("sixMethod got it...");
		    return "hello "+name;
		}
	    
	    
		
		//http://localhost:8080/springMVC-learn/a/xxx/tom
		@RequestMapping(value = "/xxx/{name}")
		public String sevenMethod(@PathVariable("name") String p) { //如果形参和url @RequestMapping 的参数名不一样，则需显示
			System.out.println("sevenMethod got it...");
		    return "say "+p;
		}
	    
	

}
