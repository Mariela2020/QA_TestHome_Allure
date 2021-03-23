package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginHomePage {

    private final WebDriver driver;

    public LoginHomePage(WebDriver driver){
        //super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy( id = "onesignal-slidedown-cancel-button")
    private WebElement btnmensaje;

    @FindBy(id = "btnLogin")
    private WebElement btnentrar;

    @FindBy(id = "IngresoUsuario.CorreoElectronico")
    private WebElement txtemailusuario;

    @FindBy(id = "IngresoUsuario.Contrasena")
    private WebElement txtpassword;

    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[3]/form/div[4]/button")
    private WebElement btniniciar;

    @FindBy(className = "nom-user")
    private WebElement txtnomuser;
    private String nombreUser1 = "Mariela";

    public void CerrarMensaje() throws InterruptedException {
        btnmensaje.click();
        Thread.sleep(2000);
    }
    public void ClickEntrarLink()  {
        btnentrar.click();
    }

    public void EnterLogin(String userName, String password) {
        txtemailusuario.sendKeys(userName);
        txtpassword.sendKeys(password);
    }

    public void ClickIniciarBtn() throws InterruptedException {
        btniniciar.click();
        Thread.sleep(3000);
    }

    public boolean isDisplayed(WebElement element) throws Exception {
        try {
            return element.isDisplayed();
        }catch (Exception e){
            throw new Exception("No se pudo encontrar el elemento:" + element);
        }
    }

    public boolean registroPageIsDisplayed() throws Exception {
        return this.isDisplayed(txtnomuser) && this.equals(nombreUser1);

    }


}