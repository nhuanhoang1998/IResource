package DynamicData;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@UseTestDataFrom("Testdata/demodata.csv")
@RunWith(SerenityParameterizedRunner.class)

public class DynamicDataTest{
    @Test
    //    test get data từ file csv -> OK
    public void getdatafromfile() {
        System.out.println("Available accounts:");
        System.out.println("Email: "+getDynamicEmail());
        System.out.println("Password: "+getDynamicPassword());
    }

    public String dynamicEmail;
    public String dynamicPassword;

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