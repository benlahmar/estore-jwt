package com.habib.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.habib.entities.User;
import com.habib.repo.IUser;


@RestController
public class UserApi {
	@Autowired
	IUser urepo;
	
	@GetMapping("/users")
	public List<User> getuser()
	{
		return urepo.findAll();
	}
	
		
	@GetMapping("/users/{id}")
	@ResponseBody
	public String getu(@PathVariable long id)
	{
		User u=urepo.findById(id).get();
		return "<br>"+u.getUsername()+"</br>";
	}
	
	
	@GetMapping("/abc/info")
	@ResponseBody
	public String getu2(@PathVariable long id)
	{
		User u=urepo.findById(id).get();
		return u.getinfo();
	}
	
	@GetMapping("/test")
	public String tt()
	{
		return "hello";
	}
}
