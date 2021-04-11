package org.coa.listingPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePack.BaseClass;

public class Cheapest_fair extends BaseClass


//get number of rates or fair
// now use for loop 
//now compare all the rate and get cheapest rate.

{
	
	
	
	@Test
	public void cheapestfair()
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
         driver.get("https://www.cheapoair.com/");
		
		WebElement From= driver.findElement(By.xpath("//*[@class='suggestion-box__clear icon hidden']"));
		From.click();
		
		From.sendKeys("NYC");
		
		
		
		
		
		
		//driver.get("https://www.cheapoair.com/remotesearch?&from=NYC&to=LAS&fromDt=04/03/2021&toDt=04/05/2021&fromTm=1100&toTm=1100&rt=true&ad=1&se=1&ch=0&infl=0&infs=0&class=1&airpref=&preftyp=1&daan=&raan=&dst=&rst=&IsNS=false");
		//System.out.println("enter to check fair");
		
       //  WebElement price1=driver.findElement(By.linkText("//*[@class='sort-tab__item--price font-weight-bold']/span[2]"));
		
		//String storeprice=price1.getText();
		//System.out.println(storeprice);
		
		
		
		
	/*	for(int i=0; i<4;i++)
		{
			System.out.println("enter to check fair 1");
			
		//WebElement fair=driver.findElement(By.xpath("//*[@class='sort-tab__item--price font-weight-bold']"));
		
		//fair.getSize();
		Dimension totalfairs=fair.getSize();
		//WebElement price =driver.findElement(By.linkText("//*[@class='sort-tab__item--price font-weight-bold']"));
		WebElement price1=driver.findElement(By.linkText("//*[@class='sort-tab__item--price font-weight-bold']/span[2]"));
		
		//String storeprice=price1.getText();
		*/
		
	
		
		}
		//if
		

		
		
	}

