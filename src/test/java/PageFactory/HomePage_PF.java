package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF {
    @FindBy(id = "logout")
    WebElement btn_logout;

    WebDriver d;

    public HomePage_PF(WebDriver d) {
    }

    public void HomePage_PF(WebDriver d){
        this.d=d;
        PageFactory.initElements(d, HomePage_PF.class);
    }

    public boolean checkLogoutIsDisplayed(){

        return btn_logout.isDisplayed();
    }
}
