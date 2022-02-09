package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver d;

    private By txt_username = By.id("name");
    private By txt_password = By.id("password");
    private By btn_login = By.id("login");
    private By btn_logout = By.id("logout");

    public LoginPage(WebDriver d){
        this.d=d;
        if(!d.getTitle().equals("TestProject Demo")){
            throw new IllegalStateException("This is not login page. The Current page is "
                    +d.getCurrentUrl());
        }
    }

    public void enterUsername(String username){
        d.findElement(txt_username).sendKeys(username);
    }
    public void enterPassword(String password){
        d.findElement(txt_password).sendKeys(password);
    }

    public void clickLogin(){
        d.findElement(btn_login).click();
    }

    public boolean checkLogoutIsDisplayed(){
        return d.findElement(btn_logout).isDisplayed();
    }

    public void loginValidUser(String username, String password){
        d.findElement(txt_username).sendKeys(username);
        d.findElement(txt_password).sendKeys(password);
        d.findElement(btn_login).click();
    }


}
