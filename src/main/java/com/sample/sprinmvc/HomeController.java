package com.sample.sprinmvc;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.ApiOperation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired CustomerBo customerBo ;
	
	/**
	 * Simply returns the Friends Id by inserting its entry to DB.
	 */
	@RequestMapping(value = "/Friend/", method = RequestMethod.POST)
	public @ResponseBody UUID insert(@RequestBody String Body, Locale locale, Model model) {

		ObjectMapper mapper=new ObjectMapper();
		CustomerDTO customerDTO;
		UUID uuid = null;
		try {
			customerDTO = mapper.readValue(Body, CustomerDTO.class);		
			uuid = customerBo.addCustomer(customerDTO);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return uuid;
	}
	
	@RequestMapping(value = "/test/", method = RequestMethod.POST)
	public @ResponseBody String insertTest( Locale locale, Model model) 
		{
			return "hello";
		}
	/**
	 * Simply returns the Friends data in json by fetching its entry to DB.
	 */
	@RequestMapping(value = "/Friend/{id}", method = RequestMethod.GET)
	public @ResponseBody CustomerDTO getCustomer(@PathVariable UUID id,Locale locale, Model model) {
		
		return 	customerBo.getCustomer(id);
	}
}
