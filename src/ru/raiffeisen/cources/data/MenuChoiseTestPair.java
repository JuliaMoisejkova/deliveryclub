package ru.raiffeisen.cources.data;

public class MenuChoiseTestPair {
    private String menuChoiseTitle;
    private String checkedBoxName;

    private String clickedMenuName;

    public MenuChoiseTestPair(String menuChoiseTitle, String checkedBoxName, String clickedMenuName) {
        this.menuChoiseTitle = menuChoiseTitle;
        this.checkedBoxName = checkedBoxName;
        this.clickedMenuName = clickedMenuName;
    }

    public String getMenuChoiseTitle() {
        return menuChoiseTitle;
    }

    public void setMenuChoiseTitle(String menuChoiseTitle) {
        this.menuChoiseTitle = menuChoiseTitle;
    }

    public String getCheckedBoxName() {
        return checkedBoxName;
    }

    public void setCheckedBoxName(String checkedBoxName) {
        this.checkedBoxName = checkedBoxName;
    }

    public String getClickedMenuName() {
        return clickedMenuName;
    }

    public void setClickedMenuName(String clickedMenuName) {
        this.clickedMenuName = clickedMenuName;
    }
}
