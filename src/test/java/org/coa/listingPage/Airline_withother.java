package org.coa.listingPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePack.BaseClass;

public class Airline_withother extends BaseClass {

	// click on non stop.
	// get the price of airline.
	// get the detail of the airline.

	@Test
	public void morethanonestop() {

		driver.get(
				"https://www.cheapoair.com/remotesearch?&from=NYC&to=LAS&fromDt=03/24/2021&toDt=03/30/2021&fromTm=1100&toTm=1100&rt=true&ad=1&se=1&ch=0&infl=0&infs=0&class=1&airpref=&preftyp=1&daan=&raan=&dst=&rst=&IsNS=false");

		// helper.waitFor(By.cssSelector("ul[class='filters__list'] > li > label"), 20,
		// 1);

		driver.findElement(By.xpath("//*[@class='matrix__cell  is--selected']")).click();

		WebElement price = driver.findElement(By.xpath("//*[@title='223.99']"));
		price.getText();

		// WebElement
		// airlinename=driver.findElement(By.xpath("//span[@class='matrix__airline-name']"));
		// airlinename.getText();

		/*
		 * List<WebElement> allairline=driver.findElements(By.
		 * xpath("//span[@class='matrix__airline-name']")); int a= allairline.size();
		 * System.out.println(a);
		 */

	}

}
