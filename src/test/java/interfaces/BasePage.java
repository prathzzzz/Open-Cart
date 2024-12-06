package interfaces;

import org.openqa.selenium.WebElement;

/**
 * Base interface defining common page actions
 */
public interface BasePage {
    void clickElement(WebElement element);
    void enterText(WebElement element, String text);
    String getElementText(WebElement element);
} 