package com.tsoft.bot.frontend.pages.pages.login;
import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.objects.OpenCartObjects;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.List;
import com.tsoft.bot.frontend.pages.objects.ExcelDataObjects;
import com.tsoft.bot.frontend.pages.objects.McssObjects;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {
    private WebDriver driver;
    private static GenerateWord generateWord = new GenerateWord();
    String mensaje;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = Hook.getDriver();
    }

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.PAGE_NAME);
    }

    public void enterUrlOC(String urlTestCase) throws Throwable {
        mensaje = "Se abre la URL de la Web OpenCart";
        try {
            int countPage = Integer.parseInt(urlTestCase) - 1;
            String url = getData().get(countPage).get(ExcelDataObjects.COLUMN_URL);
            driver.get(url);
            stepPass(driver, mensaje);
            generateWord.sendText(mensaje);
            generateWord.addImageToWord(driver);
            System.out.println("SE INGRESO A LA URL");
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.PAGE_NAME, 1, 19, "FAIL");
            stepFail(driver,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }

    public void clickLoginLink() throws Throwable {
        mensaje = "Se ingresa a la opción Login";
        try {
            click(driver, OpenCartObjects.LNK_LOGIN);
            stepPass(driver, mensaje);
            generateWord.sendText(mensaje);
            generateWord.addImageToWord(driver);
            System.out.println("SE DA CLICK EN EL BOTON LOGIN DEL HOME");
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.PAGE_NAME, 1, 19, "FAIL");
            stepFail(driver,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }

    public void ingresoDatosOCLogin(String casoPrueba) throws Throwable {
        mensaje = "Se ingresa el email y la contraseña";
        try {
            int countPage = Integer.parseInt(casoPrueba) - 1;
            String document = getData().get(countPage).get(ExcelDataObjects.COLUMN_USER);
            String passwd = getData().get(countPage).get(ExcelDataObjects.COLUMN_PASWWORD);
            typeText(driver, OpenCartObjects.TXT_CORREO, document);
            typeText(driver, OpenCartObjects.TXT_PASSWORD, passwd);
            stepPass(driver, mensaje);
            generateWord.sendText(mensaje);
            generateWord.addImageToWord(driver);
            System.out.println("SE INGRESAN LOS DATOS CORRECTAMENTE");
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.PAGE_NAME, 1, 19, "FAIL");
            stepFail(driver,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }


    public void validarLoginOC() throws Exception {
        mensaje = "Se valida que el usuario ha sido logueado correctamente";
        try {

            click(driver, OpenCartObjects.BTN_LOGIN);
            Boolean validador = isDisplayed(driver, OpenCartObjects.TXT_PIN);
            if (Boolean.TRUE.equals(validador))
            {
                stepPass(driver, mensaje);
                generateWord.sendText(mensaje);
                generateWord.addImageToWord(driver);

            }
            else
            {
                System.out.println("No se pudo validar el login");
                stepFail(driver,"Usuario o contraseña inválidos");
                generateWord.sendText("Usuario o contraseña inválidos");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.PAGE_NAME, 1, 19, "FAIL");
            System.out.println("No se pudo validar el login");
            stepFail(driver,"Fallo en tiempo de respuesta: " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }

}
