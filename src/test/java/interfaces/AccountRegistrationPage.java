package interfaces;

/**
 * Interface defining actions available on Account Registration Page
 */
public interface AccountRegistrationPage {
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setEmail(String email);
    void setTelephone(String phoneNumber);
    void setPassword(String password);
    void setPasswordConfirm();
    void clickCheckboxAgree();
    void clickContinueButton();
    String getAccountCreatedMessage();
} 