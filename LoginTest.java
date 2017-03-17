import Util.SystemConstant;
import domain.Login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by EF on 08/03/2017.
 */

public class LoginTest {

    Login login = new Login();

    @Test
    public void SuccessLogin()
    {
        login.login(SystemConstant.USERNAME,SystemConstant.PASSWORD);
    }

    @Test
    public void fillRequestForm()
    {
        login.fillRequestForm(SystemConstant.Name,SystemConstant.RegNo,SystemConstant.Address,SystemConstant.TP,SystemConstant.Email);
    }



    @AfterClass
    public void classCleanUp(){
        login.closeBrowser();
    }


      /*
  @Test
  public void testLoginWithBlankUsername(){
      login.login("aaaa", SystemConstant.PASSWORD);
      Assert.assertEquals(login.getLoginErrorMessage(), Messages.LOGIN_ERROR_MESSAGE);
  }

*/

}
