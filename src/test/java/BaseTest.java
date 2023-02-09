import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    WebDriver driver;

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.kitapyurdu.com/");
        driver.manage().window().maximize();
    }

    /*
    @AfterAll
    public void tearDown(){
        driver.quit();
    }

     */
}
