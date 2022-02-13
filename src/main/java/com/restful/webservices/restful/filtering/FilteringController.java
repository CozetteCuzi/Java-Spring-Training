package com.restful.webservices.restful.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1", "value2", "value3");
	}

	@GetMapping("/filters")
	public List<SomeBean> retrieveSomeBeans() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
	}

}
