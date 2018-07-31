package ru.raiffeisen.cources;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.raiffeisen.cources.checkers.MenuMealChecker;
import ru.raiffeisen.cources.checkers.MenuTestPairChecker;
import ru.raiffeisen.cources.data.DriverPool;
import ru.raiffeisen.cources.data.MenuCheckerDataSupplier;
import ru.raiffeisen.cources.data.MenuChoiseTestPair;
import ru.raiffeisen.cources.pages.DeliveryClubMainPageObject;

import static org.junit.Assert.*;

public class DeliveryClubTest {

    @Test
    public void pizzaTest() {
        WebDriver localDriver = DriverPool.instance.pollDriver();

        localDriver.get("https://www.delivery-club.ru/");
        DeliveryClubMainPageObject deliveryClubMainPageObject =
                new DeliveryClubMainPageObject();
        deliveryClubMainPageObject.init(localDriver);

        deliveryClubMainPageObject.gotoPizzaMenu();
        deliveryClubMainPageObject.searchByAddr("Москва, проспект Андропова, 18к1");

        MenuMealChecker menuMealChecker =
                new MenuMealChecker(deliveryClubMainPageObject);
        assertTrue(menuMealChecker.getWrongList().toString(), menuMealChecker.check());

        assertEquals("Поиск блюд и ресторанов",
                                    deliveryClubMainPageObject
                                            .getSearchMealField()
                                            .getPlaceholderText());

        DriverPool.instance.releaseDriver(localDriver);
    }

    @Test
    public void menuTest(){
        WebDriver localDriver = DriverPool.instance.pollDriver();

        localDriver.get("https://www.delivery-club.ru/");
        DeliveryClubMainPageObject deliveryClubMainPageObject =
                new DeliveryClubMainPageObject();
        deliveryClubMainPageObject.init(localDriver);

        for (MenuChoiseTestPair pair:
                MenuCheckerDataSupplier.getTestData()) {
            deliveryClubMainPageObject.gotoMenu(pair.getClickedMenuName());
            deliveryClubMainPageObject.searchByAddr("Москва, проспект Андропова, 18к1");

            MenuTestPairChecker checker = new MenuTestPairChecker(deliveryClubMainPageObject, pair);
            assertTrue(checker.getWrongList().toString(), checker.check());
        }

        DriverPool.instance.releaseDriver(localDriver);
    }

}