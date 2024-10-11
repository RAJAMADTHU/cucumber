package org.samp;

import static org.junit.Assert.assertTrue;

import javax.management.InstanceAlreadyExistsException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.samp.Baseclass;
import junit.framework.Assert;

public class tasku3 extends Baseclass {


		@Test
		public void t1() {		
	launchBorwser();
	launchUrl("https://www.instagram.com/");
	WebElement id = driver.findElement(By.xpath("//input[@maxlength='75']"));
	passText("raja", id);
	Assert.assertTrue(false);
	WebElement pass = driver.findElement(By.name("password"));
	passText("iud78", pass);

	System.out.println("test1");
	
		}
	

		@Test
		public void t2() {		
		launchBorwser();
		System.out.println("test2");
		launchUrl("https://www.facebook.com/");}
		@Test
		public void t3() {		
		launchBorwser();
		launchUrl("https://www.inmakeslh.in/admin/chapter-documents/1670049158.pdf");
		System.out.println("test3");
		}
		
		@Test
		public void t6() {		
		
		launchBorwser();
		launchUrl("https://www.inmakeslh.in/admin/chapter-documents/1670049158.pdf");
		System.out.println("test6");
		}
	
	
		}

