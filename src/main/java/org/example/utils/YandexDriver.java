package org.example.utils;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YandexDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        System.setProperty("chromedriver", "/Users/mac/Downloads/chromedriver_mac_arm64");
        return new ChromeDriver();
    }
}
