package ru.raiffeisen.cources.checkers;

import ru.raiffeisen.cources.MenuChecker;
import ru.raiffeisen.cources.pages.DeliveryClubMainPageObject;

import java.util.ArrayList;
import java.util.List;

public class MenuMealChecker implements MenuChecker {
    private List<String> wrongList = new ArrayList<String>();

    private DeliveryClubMainPageObject page;
    private static final String PIZZA_EXPECTED_TITLE =
            "\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\tДоставка пиццы в Москве, круглосуточный онлайн заказ пиццы на дом или в офис - Delivery Club\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t \n" +
                    "\t";

    public MenuMealChecker(DeliveryClubMainPageObject page) {
        this.page = page;
    }

    @Override
    public boolean check() {
        boolean result = true;

        if(!PIZZA_EXPECTED_TITLE.equals(page.getTitle())){
            result = false;
            wrongList.add("WRONG TITLE");
        }

        if(!page.getCheckBoxPizza().isChecked()){
            result = false;
            wrongList.add("WRONG CHECKBOX");
        }

        return result;
    }

    public List<String> getWrongList() {
        return wrongList;
    }
}
