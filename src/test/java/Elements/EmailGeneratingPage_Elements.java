package Elements;

import org.openqa.selenium.By;

public class EmailGeneratingPage_Elements {
    public By enterMailField = By.className("text-right");

    public By goButton = By.name("commit");

    public By fullMailAddress = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/h3[1]");

    public By emailTitle = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[3]");

    public By emailBody = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/pre[1]");
}
