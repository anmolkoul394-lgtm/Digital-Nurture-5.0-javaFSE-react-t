# Selenium – Introduction

## Theory

### What is Selenium?
**Selenium** is the most widely used open-source framework for automating **web browsers**.
It lets you write code that opens a browser, clicks buttons, fills forms, and reads page
content — exactly like a real user would — so you can test web applications end-to-end.

### Selenium WebDriver Architecture
```
Test Script (Java)  --commands-->  Selenium WebDriver API
                                          |
                                    JSON Wire Protocol / W3C WebDriver Protocol
                                          |
                                    Browser Driver (e.g. chromedriver, geckodriver)
                                          |
                                    Actual Browser (Chrome, Firefox, Edge...)
```
Your test code talks to a `WebDriver` interface, which sends commands to a browser-specific
**driver executable**, which in turn controls the real browser.

### Setting up Selenium WebDriver
1. Add the `selenium-java` dependency to `pom.xml` (see this folder's `pom.xml`).
2. Download the browser driver matching your installed browser version (e.g. ChromeDriver for
   Google Chrome) OR use **Selenium Manager** (bundled since Selenium 4.6+), which downloads
   the correct driver automatically.
3. Create a `WebDriver` instance: `WebDriver driver = new ChromeDriver();`

### Basic Selenium Commands
| Command | Purpose |
|---|---|
| `driver.get(url)` | Navigate to a web page |
| `driver.findElement(By.id("..."))` | Locate a single element |
| `element.click()` | Click a button/link |
| `element.sendKeys("text")` | Type text into an input field |
| `element.getText()` | Read the visible text of an element |
| `driver.quit()` | Close the browser and end the session |

### Locators in Selenium
Locators identify WHICH element to interact with:
- `By.id("username")`
- `By.name("username")`
- `By.className("btn-primary")`
- `By.cssSelector("input[type='submit']")`
- `By.xpath("//button[text()='Login']")`
- `By.linkText("Sign Up")`

## Files
- `src/test/java/GoogleSearchTest.java` – a classic beginner Selenium example: opens a search
  engine, types a query, and verifies the page title changes. **Requires a real Chrome browser
  and internet access to actually run** — included here as a reference/learning example, since
  this sandboxed environment has no GUI browser available.

## ▶️ How to run (on your own machine, with Chrome installed)
```bash
mvn test
```

## Expected Output (when run locally with Chrome installed)
```
Opening browser and navigating to search engine...
Page title before search: Google
Typing search query: 'Java Full Stack Engineer digital nurture'
Page title after search: Java Full Stack Engineer digital nurture - Google Search
Test PASSED: Page title changed after search, as expected.
```

## 📚 Reference
https://www.selenium.dev/documentation/webdriver/
