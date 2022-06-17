package com.block.myactivity;

import com.util.provider.NewUserDataConfigProvider;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Radio;

@Name("Matrix")
@FindBy(xpath = "//fieldset[@class = 'dciGroup matrixGroup dciGroupView']")
public class Matrix extends HtmlElement {

    protected final Logger LOG = LogManager.getLogger(getClass());

    private static final String ROW1_COLUMN1_XPATH = "//input[@id = 'gwt-uid-135']";
    private static final String ROW1_COLUMN2_XPATH = "//input[@id = 'gwt-uid-136']";
    private static final String ROW2_COLUMN1_XPATH = "//input[@id = 'gwt-uid-141']";
    private static final String ROW2_COLUMN2_XPATH = "//input[@id = 'gwt-uid-142']";

    @Name("Row1 Column1")
    @FindBy(xpath = ROW1_COLUMN1_XPATH)
    private Radio row1Column1;

    @Name("Row1 Column2")
    @FindBy(xpath = ROW1_COLUMN2_XPATH)
    private Radio row1Column2;

    @Name("Row2 Column1")
    @FindBy(xpath = ROW2_COLUMN1_XPATH)
    private Radio row2Column1;

    @Name("Row2 Column2")
    @FindBy(xpath = ROW2_COLUMN2_XPATH)
    private Radio row2Column2;

    public void selectAllMatrixValues() {
        selectRow1();
        selectRow2();
    }

    @Step("Select Row1")
    private void selectRow1() {
        String row1 = NewUserDataConfigProvider.getRow1();
        if (row1.equals("Column1")) {
            row1Column1.click();
        } else if (row1.equals("Column2")) {
            row1Column2.click();
        }
        LOG.info("Row1 selected");
    }

    @Step("Select Row2")
    private void selectRow2() {
        String row2 = NewUserDataConfigProvider.getRow2();
        if (row2.equals("Column1")) {
            row2Column1.click();
        } else if (row2.equals("Column2")) {
            row2Column2.click();
        }
        LOG.info("Row2 selected");
    }
}
