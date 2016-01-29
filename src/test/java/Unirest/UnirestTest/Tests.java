package Unirest.UnirestTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Tests {

	// @Test(groups = "mainPage")
	public void _01_Test()
			throws InterruptedException, IOException, UnirestException {
		HttpResponse<JsonNode> jsonResponse = Unirest
				.post("http://httpbin.org/post")
				.header("accept", "application/json")
				.queryString("apiKey", "123").field("parameter", "value")
				.field("foo", "bar").asJson();

		System.out.println("----------------------------");
		System.out.println(jsonResponse);
		System.out.println("----------------------------");
		Thread.sleep(1000);
	}

	// @Test(groups = "mainPage")
	public void _02_Test()
			throws InterruptedException, IOException, UnirestException {

		HttpResponse<JsonNode> jsonResponse = Unirest
				.post("https://my.15five.com/mobile/login")
				.header("HTTP_USER_AGENT", "15Five/APItest")
				.queryString("debug_api", "1").field("password", "qwerty")
				.field("email", "bossapi@ce.mintemail.com").asJson();

		System.out.println("----------------------------");
		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatus());
		System.out.println(jsonResponse.getBody().getObject().get("result"));
		System.out.println(jsonResponse.getBody().getObject().get("last_name"));
		System.out.println("----------------------------");

		Thread.sleep(1000);
	}
	
	@Test
	public void _03_Test()
			throws InterruptedException, IOException, UnirestException {

		 Client c = Client.create();
	        WebResource resource = c.resource("https://my.15five.com/mobile/login");
//	        String header = resource.header("HTTP_USER_AGENT", "15Five/APItest").get(String.class);
//	        String response = resource.post(String.class);
	        ClientResponse response2 = resource.get(ClientResponse.class);
	        int status = response2.getStatus();

		System.out.println("----------------------------");
		System.out.println(status);
		System.out.println(resource);
//		System.out.println(jsonResponse.getBody().getObject().get("result"));
//		System.out.println(jsonResponse.getBody().getObject().get("last_name"));
		System.out.println("----------------------------");

		Thread.sleep(1000);
	}

	// _______________________________________________________________________________________



	
}
