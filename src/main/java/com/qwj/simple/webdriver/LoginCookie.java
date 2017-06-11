package com.qwj.simple.webdriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCookie {
	public static void main(String[] arge){
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		
		//添加cookie信息
		Cookie cookie_baiduid = new Cookie("BAIDUID", "AFC2BC93022FD99D40E4B594396904EB:FG");
		Cookie cookie_bduss = new Cookie("BDUSS", "lJwcXFTRk9SS25lWEJzZUItREt3cnM4N01Kd01XUHBJTWxZbGlYUVNuc1c5bUpaSVFBQUFBJCQAAAAAAAAAAAEAAADgdGGscXdqX3FpYW53ZW5qdW4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABZpO1kWaTtZV");

		driver.manage().addCookie(cookie_baiduid);
		driver.manage().addCookie(cookie_bduss);
		
		Set<Cookie> cookies = driver.manage().getCookies();
		Iterator<Cookie> i = cookies.iterator();
		while(i.hasNext()){
			Cookie cookie = i.next();
			System.out.println(cookie);
		}
		
		
		driver.navigate().refresh();
	}
}
