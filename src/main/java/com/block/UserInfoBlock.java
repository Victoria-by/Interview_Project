package com.block;

import com.util.service.PageElementService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("User info block")
@FindBy(xpath = "//span[contains(text(), 'automation auto')]")
public class UserInfoBlock extends HtmlElement {

    private final static String USER_NAME_LOCATOR_PATTERN = "//span[contains(text(), '%s')]";

    public boolean isLoggedIn(String userName) {
        return PageElementService.findElement(By.xpath(String.format(USER_NAME_LOCATOR_PATTERN, userName)))
                .isDisplayed();
    }
}
