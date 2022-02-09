package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class LoginPage_PF {
    @FindBy(id= "name")
    WebElement  txt_username;

    @FindBy(id ="password")
    WebElement txt_password;

    @FindBy(id = "login")
    WebElement btn_login;

   /* @FindBy(partialLinkText = "Kundan")
    List<WebElement> myLinks;

    @FindBy(how = How.ID, using = "name")
    WebElement abc;*/

    WebDriver d;

    public LoginPage_PF(WebDriver d) {
        this.d = d;
//PageFactory.initElements(d,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(d,30),this);
    }


    public void enterUsername(String username){
        txt_username.sendKeys(username);
    }
    public void enterPassword(String password){
        txt_password.sendKeys(password);
    }

    public void clickLogin(){

        btn_login.click();
    }



    }


