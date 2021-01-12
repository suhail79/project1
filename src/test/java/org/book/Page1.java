package org.book;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page1 {
	public static WebDriver driver;

	@BeforeClass
	private void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	private void prog() {
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 11");

		driver.findElement(By.id("nav-search-submit-button")).click();

		List<WebElement> li = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("with duplicates:" + li.size());

		Set<WebElement> st = new HashSet<WebElement>();
		System.out.println("without duplicates:" + st.size());

		st.addAll(li);

		for (WebElement element : st) {
			String txt = element.getText();
			System.out.println(txt);

		}

	}

}
