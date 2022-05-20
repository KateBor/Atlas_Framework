package test;

import org.junit.jupiter.api.Test;
import util.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin extends BaseTest{

    @Test
    public void testLogin() {
        driver.get("https://ok.ru");
        User user = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("autotest1")
                .setId("589088855467L").build();
        onSite().onLoginPage().selectField("st.email").sendKeys(user.getLogin());
        onSite().onLoginPage().selectField("st.password").sendKeys(user.getPassword());
        onSite().onLoginPage().selectButton("t,sign_in").click();
        assertEquals(onSite().onMainPage().fullName().getText(),user.getFullName());
    }
}