package com.block.myactivity;

import com.util.provider.NewUserDataConfigProvider;
import com.util.service.PageElementService;
import com.util.waiter.Waiter;
import com.webdriver.WebDriverDiscovery;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.io.File;

@Name("Group2 section")
@FindBy(xpath = "//fieldset[contains(@class, 'dciGroup dciGroupView')]")
public class Group2 extends HtmlElement {

    protected final Logger LOG = LogManager.getLogger(getClass());

    private static final String IMAGE_FILE_PATH = "src/test/resources/imageUpload/raspberry_cheesecake.PNG";
    private static final String UPLOAD_FILE_XPATH = "//input[@type = 'file']";
    private static final String REMOVE_FILE_XPATH = "//i[@id = 'fileInput_removeFile']";
    private static final String SLIDER_XPATH = "//div[@name = 'simple-slider']";

    @Name("Remove file button")
    @FindBy(xpath = REMOVE_FILE_XPATH)
    private WebElement removeFile;

    @Name("Slider")
    @FindBy(xpath = SLIDER_XPATH)
    private WebElement slider;

    @Step("Upload image")
    public void uploadImage() {
        File file = new File(IMAGE_FILE_PATH);
        WebElement uploadElement = PageElementService.findElement(By.xpath(UPLOAD_FILE_XPATH));
        uploadElement.sendKeys(file.getAbsolutePath());
        Waiter.waitForWebElementVisible(removeFile);
        LOG.info("Image uploaded");
    }

    @Step("Move slider")
    public void moveSliderBar() {
        Waiter.waitForWebElementVisible(slider);
        Dimension sliderSize = slider.getSize();
        int sliderWidth = sliderSize.getWidth();

        int xCoord = slider.getLocation().getX();

        Actions builder = new Actions(WebDriverDiscovery.getWebDriver());
        builder.moveToElement(slider)
                .click()
                .dragAndDropBy(slider, xCoord + sliderWidth,
                        Integer.parseInt(NewUserDataConfigProvider.getSliderValue()))
                .build()
                .perform();
        LOG.info("Slider moved");
    }
}
