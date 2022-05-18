package com.tsoft.bot.frontend.pages.objects;

import org.openqa.selenium.By;

public class OpenCartObjects {

    private OpenCartObjects() {
    }

    //Login
    public static final By LNK_LOGIN = By.linkText("Login");
    public static final By TXT_CORREO = By.id("input-email");
    public static final By TXT_PASSWORD = By.id("input-password");
    public static final By BTN_LOGIN = By.cssSelector("button[class='btn btn-primary btn-lg hidden-xs']");
    public static final By TXT_PIN = By.id("input-pin");
}
