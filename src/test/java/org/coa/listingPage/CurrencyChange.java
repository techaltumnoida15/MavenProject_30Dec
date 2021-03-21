package org.coa.listingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePack.BaseClass;

public class CurrencyChange extends BaseClass
{
	
	//change the currency into indian rupee
	@Test
	public void currency() throws InterruptedException
	{
		driver.get("https://www.cheapoair.com/air/listing?&d1=NYC&r1=LAS&dt1=03/24/2021&d2=LAS&r2=NYC&dt2=03/30/2021&tripType=ROUNDTRIP&cl=ECONOMY&ad=1&se=0&ch=0&infs=0&infl=0");

		WebElement currvalue=driver.findElement(By.xpath("//*[@class='header-block__item currency-wrap']/span"));
		
	//check if curreny already INR then curreny will not change
		
		System.out.println(currvalue.getText());
		
		
		
		
	//	try {
		
		WebElement changecurrency=driver.findElement(By.xpath("//*[@class='header-block__item currency-wrap']"));
		
		System.out.println(changecurrency.getText());
		
		
		//assert.assertNotEquals(changecurrency, currvalue);
	//	assert.assertn
	
		changecurrency.click();
		System.out.println(" Click Successfully ");

		
		
	//}catch(Exception e)
	{
		System.out.println("not Click ");
	}
		
		WebElement curr=driver.findElement(By.xpath("//*[@class='flag-INR']"));
		
		Thread.sleep(1000);
		curr.click();
		
	
		System.out.println("currency click successfully");
	
	
	
	}
	
	

}
