package com.qwj.test.simple.openWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web{
	
	private String url;	
	
	public void openWeb(String url){
		System.out.println("start selenium");
		WebDriver chromedriver = new ChromeDriver();
		chromedriver.get(url);
//		chromedriver.findElement(By.id("kw")).sendKeys("selenium webUI");
//		chromedriver.findElement(By.id("su")).click();
//		chromedriver.close();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
