package interfaces;

public interface LoginPage {
    void clickMyAccount();
    void clickLogin();
    void setTxtEmail(String email);
    void setTxtPassword(String password);
    void clickLoginBtn();
    String verifyLogin();
}
