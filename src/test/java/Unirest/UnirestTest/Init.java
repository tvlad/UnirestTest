package Unirest.UnirestTest;



import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.BeforeMethod;
import com.mashape.unirest.http.Unirest;


public class Init {

	
	public static String protokol = "http://";
	public static String url = protokol + "api.dev.spletter.com";
	public static String auth_key = "";
	protected static String authorizationCode = "";

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

	@BeforeMethod
	public void setDefault() {
		Unirest.setDefaultHeader("x-client-secret",
				"du4Ne73NtPvOO2mhu4HZSCHZtZ-2HI10VJpV9a9D");
		Unirest.setDefaultHeader("x-client-id", "buqx-LDNlB");

		String code = "Basic " + setAuthorizationCode();

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

	
}
