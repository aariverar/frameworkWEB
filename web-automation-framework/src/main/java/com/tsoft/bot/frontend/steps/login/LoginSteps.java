package com.tsoft.bot.frontend.steps.login;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.pages.login.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private final LoginPage login = new LoginPage(driver);

    public LoginSteps() {
        this.driver = Hook.getDriver();
    }


    @Given("^Usuario ingresa url\"([^\"]*)\"$")
    public void usuarioIngresaUrl(String setNumberUrl) throws Throwable {
        login.enterUrlOC(setNumberUrl);
        login.clickLoginLink();
    }

    @When("^Usuario ingresa datos de email y contrasenia \"([^\"]*)\"$")
    public void usuarioIngresaDatosDeEmailYContrasenia(String casoprueba) throws Throwable {
        login.ingresoDatosOCLogin(casoprueba);
    }

    @Then("^Se valida el ingreso correcto$")
    public void seValidaElIngresoCorrecto() throws Exception {
        login.validarLoginOC();
    }
}
