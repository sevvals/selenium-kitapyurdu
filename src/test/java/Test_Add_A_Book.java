import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Add_A_Book extends BaseTest {

    HomePage homePage;
    BooksPage booksPage;
    BookDetailPage bookDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void click_bestseller() {
        homePage = new HomePage(driver);
        homePage.navBar.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[1]/div/div[1]/div[1]/ul[1]/li[1]/a")));
    }

    @Test
    @Order(2)
    public void click_on_bestseller_literature_books(){
        driver.findElement(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[1]/div/div[1]/div[1]/ul[1]/li[1]/a")).click();
        booksPage = new BooksPage(driver);
        Assertions.assertTrue(booksPage.isOnBooksPage(), "Not on books page!");
    }

    @Test
    @Order(3)
    public void select_a_random_book(){
        booksPage.selectRandomBook();
        bookDetailPage = new BookDetailPage(driver);
        Assertions.assertTrue(bookDetailPage.isOnBookDetailPage(), "Not on book detail page!");
    }

    @Test
    @Order(4)
    public void add_book_to_cart() throws InterruptedException {
        bookDetailPage.addToCart();
        Thread.sleep(2000);
    }

    @Test
    @Order(5)
    public void go_to_cart() throws InterruptedException {
        homePage.goToCart();
        cartPage = new CartPage(driver);
        Thread.sleep(2000);
        Assertions.assertTrue(cartPage.checkIfAdded(), "Not added to cart!");
    }
}
