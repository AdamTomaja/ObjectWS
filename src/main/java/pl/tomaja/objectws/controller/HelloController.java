package pl.tomaja.objectws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Tomaja
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Hello spring boot!";
	}
}
