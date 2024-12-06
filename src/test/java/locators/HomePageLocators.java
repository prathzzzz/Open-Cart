package locators;

/**
 * Contains all locators and locator patterns for Home Page
 * Provides methods for generating dynamic locators
 */
public class HomePageLocators {
    // Top menu locators
    public static class TopMenu {
        public static final String MY_ACCOUNT_LINK = "//span[normalize-space()='My Account']";
        public static final String REGISTER_LINK = "//a[normalize-space()='Register']";

        /**
         * Generates xpath for any top menu item
         * @param menuName exact text of menu item
         * @return xpath String
         */
        public static String getMenuLink(String menuName) {
            return String.format("//a[normalize-space()='%s']", menuName);
        }
    }

} 