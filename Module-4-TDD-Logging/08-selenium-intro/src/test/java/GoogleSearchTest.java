// GoogleSearchTest.java
// A classic beginner Selenium WebDriver example.
// NOTE: This test needs a real Chrome browser + internet connection to actually execute.
// It is provided here as a REFERENCE/LEARNING example of basic Selenium commands and
// locators, since this sandboxed environment has no GUI browser available to run it in.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GoogleSearchTest {

    private WebDriver driver;

    // Runs before each test - opens a fresh browser session (test fixture setup).
    @BeforeEach
    void setUp() {
        // Selenium 4.6+ Selenium Manager automatically downloads the matching ChromeDriver.
        driver = new ChromeDriver();
    }

    // Runs after each test - always close the browser to free resources (teardown).
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testGoogleSearchChangesPageTitle() {
        System.out.println("Opening browser and navigating to search engine...");

        // Basic command: navigate to a URL
        driver.get("https://www.google.com");

        String titleBeforeSearch = driver.getTitle();
        System.out.println("Page title before search: " + titleBeforeSearch);

        // Locator: find the search box by its "name" attribute
        WebElement searchBox = driver.findElement(By.name("q"));

        String searchQuery = "Java Full Stack Engineer digital nurture";
        System.out.println("Typing search query: '" + searchQuery + "'");

        // Basic command: type text, then press Enter
        searchBox.sendKeys(searchQuery);
        searchBox.submit();

        String titleAfterSearch = driver.getTitle();
        System.out.println("Page title after search: " + titleAfterSearch);

        // Assert that the title actually changed after performing the search
        assertNotEquals(titleBeforeSearch, titleAfterSearch,
                "Page title should change after performing a search");

        System.out.println("Test PASSED: Page title changed after search, as expected.");
    }
}
