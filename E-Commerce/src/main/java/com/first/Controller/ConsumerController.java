package com.first.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.Entity.Consumer;
import com.first.Repository.ConsumerRepo;
import com.first.Security.JwtUtil;
import com.first.Service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

		  
	@Autowired
    private ConsumerService service;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	    @Autowired
	    private ConsumerRepo consumerRepo;
	 
    @PostMapping("/register")
    public Consumer register(@RequestBody Consumer consumer) {
     return service.register(consumer);
    		
}

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Consumer consumer) {
    String token = service.login(consumer.getUsername(), consumer.getPassword());
    return Map.of("token", token);
}

}


/* @Autowired
private PasswordEncoder encoder;



@PostMapping("/register")
public String register(@RequestBody User user) {
    user.setPassword(encoder.encode(user.getPassword()));
    userRepo.save(user);
    return "User registered";
}

@PostMapping("/login")
public String login(@RequestBody User user) {
    User dbUser = userRepo.findByUsername(user.getUsername())
            .orElseThrow();

    if (encoder.matches(user.getPassword(), dbUser.getPassword())) {
        return jwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole().name());
    }
    return "Invalid credentials";
}
}
*/