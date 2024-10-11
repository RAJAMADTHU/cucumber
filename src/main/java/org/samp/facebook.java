package org.samp;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook extends Baseclass {

	public facebook() {
		// TODO Auto-generated constructor stub
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbuton() {
		return loginbuton;
	}

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(xpath = "//input[@data-testid='royal_pass']")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginbuton;

}