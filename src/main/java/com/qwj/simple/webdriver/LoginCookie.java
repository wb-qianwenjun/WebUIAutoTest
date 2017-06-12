package com.qwj.simple.webdriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginCookie {
	public static void main(String[] arge) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(800,600));
		driver.get("http://www.baidu.com");
		
		//清除cookie
		driver.manage().deleteAllCookies();
		
		//添加cookie信息
		Cookie cookie_baiduid = new Cookie("BAIDUID", "AFC2BC93022FD99D40E4B594396904EB:FG");
		Cookie cookie_bduss = new Cookie("BDUSS", "lJwcXFTRk9SS25lWEJzZUItREt3cnM4N01Kd01XUHBJTWxZbGlYUVNuc1c5bUpaSVFBQUFBJCQAAAAAAAAAAAEAAADgdGGscXdqX3FpYW53ZW5qdW4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABZpO1kWaTtZV");

		driver.manage().addCookie(cookie_baiduid);
		driver.manage().addCookie(cookie_bduss);
		
		System.out.println("添加cookie之后的浏览器cookie信息");
		printCookie(driver);
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		System.out.println("刷新之后的浏览器cookie信息");
		printCookie(driver);
		//清除cookie
		driver.manage().deleteAllCookies();
		
//		driver.close();
	}
	
	private static void printCookie(WebDriver driver){
		Set<Cookie> cookies = driver.manage().getCookies();
		Iterator<Cookie> i = cookies.iterator();
		while(i.hasNext()){
			Cookie cookie = i.next();
			System.out.println(cookie);
		}
	}
}
