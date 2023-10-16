package com.habib.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.habib.entities.User;
import com.habib.repo.IUser;





@RestController
@RequestMapping("/api")
public class Auth {

	@Autowired
	IUser urepo;
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/register1")
	public User register(@RequestBody User u)
	{
		String ps=encoder.encode(u.getPassword());
		u.setPassword(ps);
		return urepo.save(u);
		
	}
	
	@GetMapping("/register2")
	public User register(@RequestParam String log,@RequestParam String pas,@RequestParam String role)
	{
		String ps=encoder.encode(pas);
		User u=new User();
		u.setUsername(log);
		u.setPassword(ps);
		u.setRole(role);
		return urepo.save(u);
		
	}

	@PostMapping("/authentificate1")
	public User authent()
	{
		
		return null;
	}
	
	
	@GetMapping("/users")
	public List<User> getuser()
	{
		return urepo.findAll();
	}
	
	@GetMapping("/test")
	public String tt()
	{
		return "hello";
	}
}
