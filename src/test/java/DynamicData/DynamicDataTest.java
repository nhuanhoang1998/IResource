package DynamicData;

import Elements.LoginPage_Elements;
import Pages.LoginPage;
import cucumber.api.java.Before;
import groovy.util.logging.Log;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.yecht.Data;

@UseTestDataFrom("Testdata/demodata.csv")
@RunWith(SerenityParameterizedRunner.class)

public class DynamicDataTest{
    @Test
    //    test get data từ file csv -> OK
    public void test_getdatafromfile() {
        System.out.println(getDynamicEmail());
        System.out.println(getDynamicPassword());
    }

    public String dynamicEmail;
    public String dynamicPassword;
    public String a = getDynamicEmail();
    public String b = getDynamicPassword();

    public DynamicDataTest() {
    }

    public String getDynamicEmail() {
        return dynamicEmail;
    }

    public String getDynamicPassword() {
        return dynamicPassword;
    }

    public void setDynamicEmail(String dynamicEmail) {
        this.dynamicEmail = dynamicEmail;
    }

    public void setDynamicPassword(String dynamicPassword) {
        this.dynamicPassword = dynamicPassword;
    }
}