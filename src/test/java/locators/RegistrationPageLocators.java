package locators;

/**
 * Contains all locators and locator patterns for Account Registration Page
 * Organized by form sections
 */
public class RegistrationPageLocators {
    // Personal Details section locators
    public static class PersonalDetails {
        public static final String FIRST_NAME_INPUT = "//input[@id='input-firstname']";
        public static final String LAST_NAME_INPUT = "//input[@id='input-lastname']";
        public static final String EMAIL_INPUT = "//input[@id='input-email']";
        public static final String TELEPHONE_INPUT = "//input[@id='input-telephone']";
    }

    // Password section locators
    public static class Password {
        public static final String PASSWORD_INPUT = "//input[@id='input-password']";
        public static final String PASSWORD_CONFIRM_INPUT = "//input[@id='input-confirm']";
    }

    // Agreement section locators
    public static class Agreement {
        public static final String AGREE_CHECKBOX = "//input[@name='agree']";
    }

    // Form submission locators
    public static class Submit {
        public static final String CONTINUE_BUTTON = "//input[@value='Continue']";
        public static final String SUCCESS_MESSAGE = "//h1[normalize-space()='Your Account Has Been Created!']";
    }


} 