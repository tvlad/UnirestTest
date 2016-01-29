package Unirest.UnirestTest;



import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.BeforeMethod;
import com.mashape.unirest.http.Unirest;


public class Init {

	
	public static String url = "http://api.dev.spletter.com";
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
		Unirest.setTimeouts(3000, 3000);
		Unirest.setDefaultHeader("x-client-secret",
				"du4Ne73NtPvOO2mhu4HZSCHZtZ-2HI10VJpV9a9D");
		Unirest.setDefaultHeader("x-client-id", "buqx-LDNlB");

//		String code = setAuthorizationCode();

		Unirest.setDefaultHeader("Authorization", setAuthorizationCode());
		System.out.println("BeforeMethod----------------------------");
		System.out.println("code - " + setAuthorizationCode());
		System.out.println();
		System.out.println("----------------------------");
	}
	
	public static String setAuthorizationCode() {
		String code = "";
		if (!auth_key.equals("")) {
			byte[] encodedBytes = Base64.encodeBase64(auth_key.getBytes());
			String encoded = new String(encodedBytes);
			code = encoded.substring(0, encoded.length() - 1) + "6";
		}
		
		return authorizationCode = "Basic " + code;
	}

	
}
