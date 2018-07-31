package ru.raiffeisen.cources.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CheckBox {
    private WebElement element;
    private boolean isChecked;
    private String name;

    public CheckBox(WebElement element) {
        this.element = element;
        isChecked = element.isSelected();
        this.name = element.getAttribute("value");
    }

    public String getName() {
        return name;
    }

    public void check(){
        if(!isChecked) {
            element.sendKeys(Keys.ARROW_LEFT);
            isChecked = true;
        }
    }

    public void unCheck(){
        if(isChecked) {
            element.sendKeys(Keys.ARROW_LEFT);
            isChecked = false;
        }
    }

    public boolean isChecked() {
        return isChecked;
    }
}
