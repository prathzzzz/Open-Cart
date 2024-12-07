package locators;

public class MyAccountPageLocators {
    public static class TopMenu {
        public static final String MY_ACCOUNT_LINK = "//span[normalize-space()='My Account']";
    }

    public static class Dashboard {
        public static final String MY_ACCOUNT_TEXT = "//h2[normalize-space()='My Account']";
        public static final String LOGOUT = "//a[@class='list-group-item'][normalize-space()='Logout']";
    }
} 