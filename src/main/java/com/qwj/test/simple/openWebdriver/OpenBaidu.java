package com.qwj.test.simple.openWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBaidu {
	public static void main(String[] args){
		System.out.println("start selenium");
		WebDriver chromedriver = new ChromeDriver();
		chromedriver.get("http://www.baidu.com/");
		chromedriver.findElement(By.id("kw")).sendKeys("selenium webUI");
		chromedriver.findElement(By.id("su")).click();
		chromedriver.close();
	}
}
