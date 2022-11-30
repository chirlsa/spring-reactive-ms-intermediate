package com.myapp.spring.security.context;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.domain.User;

import reactor.core.publisher.Mono;

@RestController
public class UserController {
	
	@GetMapping("user")
	public Mono<User> getUserContext(@AuthenticationPrincipal OidcUser oidcUser){
		
		var user = new User(oidcUser.getPreferredUsername(), 
				oidcUser.getGivenName(), oidcUser.getFamilyName(),oidcUser.getClaimAsStringList("roles"));
		return Mono.just(user);
		
	}

}
