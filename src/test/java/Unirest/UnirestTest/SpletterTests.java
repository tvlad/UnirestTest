package Unirest.UnirestTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SpletterTests extends Init{

	
	@Test(groups = "spletter")
	public void _01_Login()
			throws InterruptedException, IOException, UnirestException {
		String current = "/users/login";
		HttpResponse<JsonNode> json = Unirest
				.post(url + current)
				.field("password", "qwerty")
				.field("email", "tvlad.test@gmail.com")
				.asJson();

		System.out.println("----------------------------");
		System.out.println(json.getBody());
		System.out.println(json.getStatus());
		System.out.println(Unirest.options(url + current).toString());
		System.out.println("----------------------------");

		
		auth_key = json.getBody().getObject().get("auth_key")
				.toString();
		
		Assert.assertEquals("200", Integer.toString(json.getStatus()));
	}

	@Test(groups = "spletter")
	public void _02_userCurrent()
			throws InterruptedException, IOException, UnirestException {
		String current = "/users/current";
		HttpResponse<JsonNode> jsonResponse = Unirest
				.get(url + current)
				.queryString("expand", "address,currency,card").asJson();

		System.out.println("----------------------------");
		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatus());
		System.out.println("----------------------------");

		Thread.sleep(1000);
	}

	

	@Test(groups = "spletter")
	public void _03_suppliers()
			throws InterruptedException, IOException, UnirestException {
		String current = "/suppliers";
		HttpResponse<JsonNode> jsonResponse = Unirest.get(url + current)
				// .queryString("expand", "user,countries_support")
				.asJson();

		System.out.println("----------------------------");
		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatus());
		System.out.println(jsonResponse.getBody());
		System.out.println("----------------------------");

		Thread.sleep(1000);
		
	}
	
	@Test(groups = "spletter")
	public void _04_forgotPassword()
			throws InterruptedException, IOException, UnirestException {
//		Unirest.clearDefaultHeaders();
//		Unirest.setDefaultHeader("x-client-secret",
//				"du4Ne73NtPvOO2mhu4HZSCHZtZ-2HI10VJpV9a9D");
//		Unirest.setDefaultHeader("x-client-id", "buqx-LDNlB");
		String current = "/users/forgot-password";
		HttpResponse<JsonNode> jsonResponse = Unirest.put(url + current)
				.field("email", "tvlad.test@gmail.com").asJson();

		System.out.println("----------------------------");
		System.out.println(jsonResponse.getStatus());
		System.out.println("----------------------------");

		Thread.sleep(1000);
		}
	
	
}
