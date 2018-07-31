package ru.raiffeisen.cources.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DriverPool {
    private static final String WEBDRIVER_CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER = "C:\\Users\\User\\Downloads\\chromedriver.exe";

    private List<WebDriver> drivers =
            new CopyOnWriteArrayList<>();

    private DriverPool(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER_KEY, WEBDRIVER_CHROME_DRIVER);

        for (int i = 0; i < 50; i++) {
            drivers.add(new ChromeDriver());
        }
    }

    public synchronized WebDriver pollDriver(){
        if(drivers.size() == 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return pollDriver();
        }
        WebDriver webDriver = drivers.get(drivers.size()-1);
        drivers.remove(webDriver);
        return webDriver;
    }

    public synchronized void releaseDriver(WebDriver driver){
        driver.quit();
        drivers.add(driver);
    }

    public static final DriverPool instance = new DriverPool();




}
