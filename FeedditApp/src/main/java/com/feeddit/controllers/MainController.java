package com.feeddit.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.feeddit.dto.UserDto;
import com.feeddit.model.DbEntry;
import com.feeddit.model.User;
import com.feeddit.service.EntityService;
import com.feeddit.service.UserService;

@RestController
public class MainController {

	private static String SESSION_ATTR_USER = "userDto";

	@Resource
	private EntityService entityService;

	@Autowired
	private UserService userService;

	@RequestMapping(value="/authenticateuser")
	public ModelAndView authenticateUser(@RequestBody final UserDto userDto, final HttpServletRequest request){

		System.out.println(userDto.getUsername() + " "+userDto.getPassword());


		final User user = userService.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());

		final HttpHeaders httpHeaders = new HttpHeaders();

		if(user == null) {
			//			return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
			//			model.addAttribute("error", "unesi glupi username i password ffs");
			return new ModelAndView("index");
		}

		httpHeaders.add("url", "/WEB-INF/views/welcome.jsp");
		request.getSession().setAttribute(SESSION_ATTR_USER, userDto);
		//		return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
		return new ModelAndView("index");

	}


	@RequestMapping(value= "/welcome", method = RequestMethod.GET)
	public ModelAndView helloWorld() {

		System.out.println("TADA!");

		final String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public ResponseEntity<String> testDb() {

		final Iterable<DbEntry> entries = entityService.findAll();

		final DbEntry parent = new DbEntry();
		parent.setName("John");

		final DbEntry child = new DbEntry();
		child.setName("Jack");
		child.setParent(parent);

		final List<DbEntry> list = new ArrayList<>();
		list.add(child);
		list.add(parent);

		entityService.saveAll(list);


		for(final DbEntry entry : entries) {
			entry.setParent(parent);
		}

		System.out.println("TADA!");

		return new ResponseEntity<String>("Done", HttpStatus.OK);
	}

}
