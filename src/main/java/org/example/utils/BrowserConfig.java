package org.example.utils;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Configuration.baseUrl;

        public class BrowserConfig {
        public void setBrowserName(String browserName) {
        Configuration.browser = browserName;
        baseUrl = "https://stellarburgers.nomoreparties.site/";

        if (browserName == "yandex" || browserName == "Yandex"){
        setYandexBrowserProperties();
        }
        }

        public void setYandexBrowserProperties() {
        Configuration.timeout = 4000;
        Configuration.browser = YandexDriver.class.getName();
        baseUrl = "https://stellarburgers.nomoreparties.site/";
        }
        }
