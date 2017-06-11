package com.qwj.simple.webdriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login{
	
public static void main(String[] args) throws InterruptedException{
		
		System.out.println("start selenium");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("start login");		
		driver.get("http://www.baidu.com");	
		
		//获取cookie信息，直接登陆
		Set<Cookie> cookie = driver.manage().getCookies();
		System.out.println(cookie);
		Iterator<Cookie> it = cookie.iterator();
		while(it.hasNext()){
			Cookie coo = it.next();
			System.out.println(coo);
		}
		
		driver.findElement(By.xpath(".//*[@id='u1']/a[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__submitWrapper']/a[1]")).click();

		String search_handle = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles();
		//显示所有handle
		Iterator<String> i = handles.iterator();
		while(i.hasNext()) {
			String web = i.next();
			System.out.println(web);
		}
		
		//进入注册页面填写信息-->直接登陆已注册账号
		for(String handle : handles){
			if(handle.equals(search_handle)==false){
				driver.switchTo().window(handle);
				System.out.println("start register baidu");
				driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_3__userName']")).sendKeys("qianwenjun");
				driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_3__phone']")).sendKeys("18143476362");
				driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_3__verifyCode']")).sendKeys("8888");
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_24__confirm_continue']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_3__password']")).clear();
				driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_3__password']")).sendKeys("930314qwja");
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_3__submit']")).click();
				
//				driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_3__verifyCode']")).sendKeys("8888");
				Thread.sleep(2000);
			}			
		}
		//添加cookie信息
		Cookie cookie_baiduid = new Cookie("BAIDUID", "AFC2BC93022FD99D40E4B594396904EB:FG");
		Cookie cookie_bduss = new Cookie("BDUSS", "lJwcXFTRk9SS25lWEJzZUItREt3cnM4N01Kd01XUHBJTWxZbGlYUVNuc1c5bUpaSVFBQUFBJCQAAAAAAAAAAAEAAADgdGGscXdqX3FpYW53ZW5qdW4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABZpO1kWaTtZV");

		driver.manage().addCookie(cookie_baiduid);
		driver.manage().addCookie(cookie_bduss);
		
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		System.out.println("close web");
		driver.close();
	}

}
