package locators;

public class LoginPageLocators {

    // Top menu locators
    public static class TopMenu {
        public static final String LOGIN_LINK = "//a[normalize-space()='Login']";
    }

    public static class LoginForm {
        public static final String EMAIL_INPUT = "//input[@id='input-email']";
        public static final String PASSWORD_INPUT = "//input[@id='input-password']";
        public static final String LOGIN_BUTTON = "//input[@value='Login']";
    }

}
