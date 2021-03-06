package com.exercise3;

public class AmazonPage {
	static String url, amazonUser, amazonPw; 
	
	public static void goToAmazon() throws Exception {
		url = ReadConfigFile.readEmail();
		Browser.goTo(url);
	}
	
	public static void login() throws Exception {
		amazonUser = ReadConfigFile.readUser();
		amazonPw = ReadConfigFile.readPassword(); 
		Browser.loginAmazonUser(amazonUser, amazonPw); 		 
	}	
	
	public static void close() throws Exception {
		Browser.close(); 
	}
}
