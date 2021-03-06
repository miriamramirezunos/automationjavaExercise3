package com.exercise3;

import java.io.FileInputStream;
import java.io.InputStream;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadConfigFile {
	private String url, user, password; 
		
	public void setEmail(String JsonUrl) {
		this.url = JsonUrl; 
	}
	
	public String getEmail() {
		return this.url; 
	}
	
	public void setUser(String JsonUser) {
		this.user = JsonUser; 
	}
	
	public String getUser() {
		return this.user; 
	}
	
	public void setPassword(String JsonPassword) {
		this.password = JsonPassword; 
	}
	
	public String getPassword() {
		return this.password; 
	}	
		
	public static String readEmail() {	
		ReadConfigFile readJson = new ReadConfigFile(); 
        JSONObject json; 
        try (InputStream input = new FileInputStream("File/jsonfile.json")) {
        	json = new JSONObject(new JSONTokener(input));
        	readJson.setEmail(json.getString("BaseUrl")); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readJson.getEmail();        
    }

    public static String readUser() {
    	ReadConfigFile readJson = new ReadConfigFile(); 
        JSONObject json; 
        try (InputStream input = new FileInputStream("File/jsonfile.json")) {
        	json = new JSONObject(new JSONTokener(input));
        	readJson.setUser(json.getString("UserName")); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readJson.getUser(); 	
    }
    
    public static String readPassword() {
    	ReadConfigFile readJson = new ReadConfigFile(); 
        JSONObject json; 
        try (InputStream input = new FileInputStream("File/jsonfile.json")) {
        	json = new JSONObject(new JSONTokener(input));
        	readJson.setPassword(json.getString("Password")); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readJson.getPassword();       	
    }

}
