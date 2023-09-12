package com.orange.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orange.base.Baseclass;
import com.orange.keyword.KeywordDriven;

public class LoginTestPage extends Baseclass {

	public LoginTestPage() throws IOException {
		super();
	}

	public KeywordDriven keydriven;
	
	@Test
	public void loginTest() throws Exception {
		
		Baseclass base = new Baseclass();
		base.initialization();
		
		
		try {
			keydriven = new KeywordDriven();
		} catch (IOException e) {
			e.printStackTrace();
		}
		keydriven.startExceution("Sheet1");
		
	}
	
}
