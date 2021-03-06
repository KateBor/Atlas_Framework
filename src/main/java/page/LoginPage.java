package page;

import element.Button;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import util.User;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public interface LoginPage extends WebPage, Button {

    @Retry(timeout = 20_000L, polling = 2000L)
    @FindBy("//input[@name = '{{ value }}']")
    AtlasWebElement selectField(@Param("value") String value);

    default void login(User user){
        selectField("st.email").sendKeys(user.getLogin());
        selectField("st.password").sendKeys(user.getPassword());
        selectButton("t,sign_in").should(displayed()).click();
    }
}
