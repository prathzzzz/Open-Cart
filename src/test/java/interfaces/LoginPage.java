package interfaces;

public interface LoginPage {
    void clickLogin();
    void setTxtEmail(String email);
    void setTxtPassword(String password);
    void clickLoginBtn();
    String getIncorrectCredentialMessage();

}
