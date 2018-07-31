package ru.raiffeisen.cources.elements;

import org.openqa.selenium.WebElement;

public class EditableTextField {
    private WebElement element;
    private String content;
    private String placeholderText;

    public EditableTextField(WebElement element) {
        this.element = element;
        content = element.getText();
        placeholderText = element.getAttribute("placeholder");
    }

    public void enterText(String text){
        this.content = text;
        element.clear();
        element.sendKeys(text);
    }

    public void appendText(String text){
        this.content = text;
        element.sendKeys(text);
    }

    public void addLeftText(String text){
        String presentText = element.getText();
        presentText = text + presentText;

        this.content = presentText;
        element.clear();
        element.sendKeys(presentText);
    }

    public String getContent() {
        return content;
    }

    public String getPlaceholderText() {
        return placeholderText;
    }
}
