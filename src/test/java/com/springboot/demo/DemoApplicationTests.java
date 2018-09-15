package com.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class DemoApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testIndex() {
		String body = this.restTemplate.getForObject("/", String.class);
		System.out.println("Body:"+body);
		assertEquals("Hello Spring Boot!",body);
	}
    @Test
    public void testHello() {
        String body = this.restTemplate.getForObject("/hello", String.class);
        System.out.println("Body:"+body);
        assertEquals("Hello World!",body);
    }
    @Test
    public void testNotFound() {
        ResponseEntity responseEntity  = this.restTemplate.getForEntity("/notfound", String.class);
        System.out.println("Body:"+responseEntity.getBody());
        assertEquals(404,responseEntity.getStatusCode().value());
    }
}
