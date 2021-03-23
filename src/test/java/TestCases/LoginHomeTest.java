package TestCases;

import Pom.LoginHomePage;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginHomeTest {

    public static WebDriver driver;
    String baseUrl = "https://www.toctoc.com/";
    String expected = null;
    String actual = null;
    WebDriverWait waitElement;
    DesiredCapabilities capability= null;
    LoginHomePage loginHomePage;

    @BeforeTest
    @Parameters({"browser"})
    public void launchBrowser(String browser) throws Exception {
        switch (browser.toUpperCase()){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver= new ChromeDriver();
                // capability = DesiredCapabilities.chrome();
                // capability.setBrowserName("chrome");
                // capability.setPlatform(Platform.ANY);

                break;
            case "FIREFOX":
                //System.out.println("firefox");
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver =new FirefoxDriver();
                /*capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.ANY);
                */
                break;
            case "EDGE":
               /* System.out.println("edge");
                capability = DesiredCapabilities.edge();
                capability.setBrowserName("MicrosoftEdge");
                capability.setPlatform(Platform.WINDOWS);
             */  System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "OPERA":
                System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
                driver = new OperaDriver();

                break;
            case "SAFARI":
                System.out.println("safari");
                capability = DesiredCapabilities.safari();
                capability.setBrowserName("safari");
                capability.setPlatform(Platform.IOS);
                break;
            default:
                Assert.fail("Verifique el browser seleccionado");

        }
        //driver = new RemoteWebDriver(new URL(nodeUrl),capability);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    @Test(priority = 1, description = "Verifica Titulo Page")
    public void titlePage() throws InterruptedException {
        loginHomePage = new LoginHomePage(driver);
        expected = "TOCTOC.com - Casas, Departamentos en Venta y Arriendo publicados en este portal inmobiliario";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
        loginHomePage.CerrarMensaje();
    }

    @Test(priority = 2, description = "Ingresa Credenciales")
    public void login() throws Exception {
        loginHomePage.ClickEntrarLink();
        loginHomePage.EnterLogin("hurtadomariela2@gmail.com", "prueba");
        loginHomePage.ClickIniciarBtn();
    }

    @Test(priority = 3, description = "Verifica UserName")
    public void register() throws Exception {
        loginHomePage.registroPageIsDisplayed();
    }

}
