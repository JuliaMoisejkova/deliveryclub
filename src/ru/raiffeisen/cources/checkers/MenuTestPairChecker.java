package ru.raiffeisen.cources.checkers;

import ru.raiffeisen.cources.MenuChecker;
import ru.raiffeisen.cources.data.MenuChoiseTestPair;
import ru.raiffeisen.cources.pages.DeliveryClubMainPageObject;

import java.util.ArrayList;
import java.util.List;

public class MenuTestPairChecker implements MenuChecker {
    private List<String> wrongList = new ArrayList<String>();

    private DeliveryClubMainPageObject page;
    private MenuChoiseTestPair pair;

    public MenuTestPairChecker(DeliveryClubMainPageObject page,
                               MenuChoiseTestPair pair) {
        this.page = page;
        this.pair = pair;
    }

    @Override
    public boolean check() {
        boolean result = true;

        if(!pair.getMenuChoiseTitle().equals(page.getTitle())){
            result = false;
            wrongList.add("WRONG TITLE");
        }

        if(!page.getCheckBoxNyName(pair.getCheckedBoxName()).isChecked()){
            result = false;
            wrongList.add("CHECKBOX UNCHECKED");
        }

        return result;
    }

    public List<String> getWrongList() {
        return wrongList;
    }
}
