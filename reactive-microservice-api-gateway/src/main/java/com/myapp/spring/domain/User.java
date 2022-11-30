package com.myapp.spring.domain;

import java.util.List;

public record User(
		String username,String firstName,String lastName,
		List<String> roles
		) {

}
