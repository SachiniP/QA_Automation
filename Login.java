package domain;

/**
 * Created by EF on 08/03/2017.
 */

import Page.LoginPage;

public class Login {

    LoginPage loginPage = new LoginPage();

    public void login(String username, String password){
       loginPage.clickLoginLink();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        loginPage.checkElement();
    }

    public void fillRequestForm(String Name, String regNo, String Address,String TP,String Email)
    {
        loginPage.fillRequestForm(Name,regNo,Address,TP,Email);
    }

    public String getLoginErrorMessage(){
        return loginPage.getErrorMessage();
    }

    public void closeBrowser(){
        loginPage.closeBrowser();
    }



}
