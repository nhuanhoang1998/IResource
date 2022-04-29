package GenerateData;

import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateData extends PageObject {
    String firstname, lastname, emailwithdomain, emailbodypart, password;

    public void setFirstname() {
        firstname = RandomStringUtils.randomAlphabetic(7);
    }

    public void setLastName() {
        lastname = RandomStringUtils.randomAlphabetic(7);
    }

    public void setEmailwithDomain(String domain) {
        String text = RandomStringUtils.randomAlphabetic(7);
        emailwithdomain = text+domain;
        emailbodypart = text;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getEmailwithDomain() {
        return emailwithdomain;
    }

    public String getEmailbodypart() {
        return emailbodypart;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void generateValidDatas(String domain, String password) {
        setFirstname();
        setLastName();
        setPassword(password);
        setEmailwithDomain(domain);
    }

    public void saveData() {
        ArrayList<String> internalPersona = new ArrayList<>();

        internalPersona.add(getFirstName());
        internalPersona.add(getLastName());
        internalPersona.add(getEmailwithDomain());
        internalPersona.add(getPassword());

        try {
            FileWriter fileWriter = new FileWriter("InternalPersonaAccounts.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            for (int i = 0; i < internalPersona.size(); i++) {
                bufferedWriter.write(internalPersona.get(i)+",");
            }
            bufferedWriter.close();
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
