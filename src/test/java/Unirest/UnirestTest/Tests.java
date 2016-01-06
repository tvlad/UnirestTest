package Unirest.UnirestTest;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

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

	// _______________________________________________________________________________________

	public static String protokol = "http://";
	public static String url = protokol + "api.dev.spletter.com";
	public static String auth_key = "";
	private static String authorizationCode = "";

	// @BeforeMethod
//	public void authorizationCode() {
//		if (!auth_key.equals("")) {
//			byte[] encodedBytes = Base64
//					.encodeBase64(authorizationCode.getBytes());
//			String encoded = new String(encodedBytes);
//			authorizationCode = encoded.substring(0, encoded.length() - 1)
//					+ "6";
//		}
//	}

	@BeforeTest
	public void setDefault() {
		Unirest.setDefaultHeader("x-client-secret",
				"du4Ne73NtPvOO2mhu4HZSCHZtZ-2HI10VJpV9a9D");
		Unirest.setDefaultHeader("x-client-id", "buqx-LDNlB");

		String code = "Basic " + authorizationCode;

		Unirest.setDefaultHeader("Authorization", code);
		
		System.out.println("----------------------------");
		System.out.println("code - " + code);
		System.out.println("----------------------------");
	}
	
	public static String setAuthorizationCode() {
		if (!auth_key.equals("")) {
			byte[] encodedBytes = Base64.encodeBase64(auth_key.getBytes());
			String encoded = new String(encodedBytes);
			authorizationCode = encoded.substring(0, encoded.length() - 1)
					+ "6";
		}
		return authorizationCode;
	}

	@Test(groups = "spletter")
	public void _01_forgotPassword()
			throws InterruptedException, IOException, UnirestException {
		String current = "/users/forgot-password";
		HttpResponse<JsonNode> jsonResponse = Unirest.put(url + current)
				.field("email", "tvlad.test@gmail.com").asJson();

		System.out.println("----------------------------");
		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatus());
		System.out.println("----------------------------");

		Thread.sleep(1000);
		Unirest.clearDefaultHeaders();
	}
	
	@Test(groups = "spletter")
	public void _02_Login()
			throws InterruptedException, IOException, UnirestException {
		String login = "/users/login";
		HttpResponse<JsonNode> json = Unirest
				.post(url + login)
				.field("password", "qwerty")
				.field("email", "tvlad.test@gmail.com")
				.asJson();

		System.out.println("----------------------------");
		System.out.println(json.getBody());
		System.out.println(json.getStatus());
		System.out.println("----------------------------");

		Thread.sleep(1000);

		auth_key = json.getBody().getObject().get("auth_key")
				.toString();
		
		byte[] encodedBytes = Base64.encodeBase64(auth_key.getBytes());
		String encoded = new String(encodedBytes);
		authorizationCode = encoded.substring(0, encoded.length() - 1)
				+ "6";
	}

	@Test(groups = "spletter")
	public void _03_userCurrent()
			throws InterruptedException, IOException, UnirestException {
		String current = "/users/current";
		HttpResponse<JsonNode> jsonResponse = Unirest.get(url + current)
				.queryString("expand", "address,currency,card").asJson();

		System.out.println("----------------------------");
		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatus());
		System.out.println("----------------------------");

		Thread.sleep(1000);
	}

	

	@Test(groups = "spletter")
	public void _04_suppliers()
			throws InterruptedException, IOException, UnirestException {
		String current = "/suppliers";
		HttpResponse<JsonNode> jsonResponse = Unirest.get(url + current)
				// .queryString("expand", "user,countries_support")
				.asJson();

		System.out.println("----------------------------");
		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatus());
		System.out.println("----------------------------");

		Thread.sleep(1000);
	}
}
