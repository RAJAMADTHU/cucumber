package org.samp;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class jaunt extends Baseclass {

	@Test
	public void t1() {
		System.out.println("test 1");

	}

	@Test
	public void t2() {
		System.out.println("test 2");
	}

	@Before
	public void date() {
		System.out.println("date"); // TODO Auto-generated method stub

	}

	@After
	public void endDate() {
		System.out.println("end date"); // TODO Auto-generated method stub

	}

	@Test
	public void t3() {
		System.out.println("test 3");
	}

	@BeforeClass
	public static void broser() {
		System.out.println("broser lanch"); // TODO Auto-generated method stub

		
		
	}
	@AfterClass
	public static void close() {
	System.out.println("broser close");	// TODO Auto-generated method stub

	}

	@Test
	public void t4() {
		System.out.println("test 4");

	}

}
