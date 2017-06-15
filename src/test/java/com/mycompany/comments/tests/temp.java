package com.mycompany.comments.tests;

import static com.codeborne.selenide.Selenide.open;

public class temp {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("http://commentssprintone.azurewebsites.net/");

    }
}
