package ru.raiffeisen.cources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.raiffeisen.cources.elements.CheckBox;
import ru.raiffeisen.cources.elements.EditableTextField;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DeliveryClubMainPageObject extends AbstractPage {
    private WebDriver driver;

    @FindBy(id = "user-addr__input")
    private WebElement addrInput;

    @FindBy(className = "user-addr__submit")
    private WebElement searchSubmitBtn;

    @FindBy(className = "authorization-btn--enter")
    private WebElement authBtn;

    private WebDriverWait waiter;

    private EditableTextField searchMealField;
    private CheckBox checkBoxPizza;

    private List<CheckBox> checkBoxList = new ArrayList<>();

    @Override
    public void init(WebDriver webDriver) {
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        waiter = new WebDriverWait(driver, 20);
        PageFactory.initElements(webDriver, this);
    }

    public void auth(String login, String password){
        authBtn.click();

        EditableTextField loginField =
                new EditableTextField(driver.findElement(By.className("user-login__input")));
        loginField.appendText(login);

        //EditableTextField passField = new EditableTextField(driver.findElement(By.))
    }

    public CheckBox getCheckBoxNyName(String name){
        for (CheckBox checkBox:
             checkBoxList) {
            if(checkBox.getName().equals(name)){
                return checkBox;
            }
        }

        return null;
        //return checkBoxList.stream().filter(checkBox -> checkBox.getName().equals(name)).findFirst().get();
    }

    public void searchByAddr(String address){
        fillAddrField(address);
        searchSubmitBtn.click();

        checkBoxPizza =
                new CheckBox(
                        waiter.until(
                                ExpectedConditions
                                        .presenceOfElementLocated(
                                                By.xpath("//input[./following-sibling::span[contains(.,'Пицца')]]")
                                        )
                        )
                );
    }

    public void fillAddrField(String address){
        addrInput.sendKeys(address);
    }

    public void gotoMenu(String menuName){
        WebElement menuLink =
                driver.findElement(By.linkText(menuName));

        if(menuLink != null){
            menuLink.click();

            List<WebElement> checkBoxes =
                    driver.findElements(
                            By.xpath("//div[@class='vendors-filter__items-visible']/label/input"));

            checkBoxes.clear();
            for (WebElement elem:
                 checkBoxes) {
                CheckBox checkBox = new CheckBox(elem);
                checkBoxList.add(checkBox);
            }

            //checkBoxes.stream().map(elem -> new CheckBox(elem)).collect(Collectors.toList());
        }
    }

    public List<CheckBox> getCheckBoxList() {
        return checkBoxList;
    }

    public void gotoPizzaMenu(){
        WebElement pizzaMenuLink =
                driver.findElement(By.linkText("Пицца"));

        if(pizzaMenuLink != null){
            pizzaMenuLink.click();

            searchMealField =
                    new EditableTextField(
                            waiter.until(
                                    ExpectedConditions
                                            .presenceOfElementLocated(
                                                    By.xpath("//input[@class='search-form__input input--def']")))
                    );
        }
    }

    public EditableTextField getSearchMealField() {
        return searchMealField;
    }

    public CheckBox getCheckBoxPizza() {
        return checkBoxPizza;
    }
}
