package com.g33kzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g33kzone.pojo.User;
import com.g33kzone.service.UserService;

@RestController
@RequestMapping("derby/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "user/findall", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> fetchAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.fetchAll());
	}

	@RequestMapping(value = "user/add", method = RequestMethod.POST, produces = "application/text")
	public ResponseEntity<String> adduser(@RequestBody User user) {
		userService.adduser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Created...");
	}

	@RequestMapping(value = "user/findfname/{firstName}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> findByFirstName(@PathVariable String firstName) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByFirstName(firstName));
	}
	
	@RequestMapping(value = "user/findlname/{lastName}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> findByLastName(@PathVariable String lastName) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByLastName(lastName));
	}

}
