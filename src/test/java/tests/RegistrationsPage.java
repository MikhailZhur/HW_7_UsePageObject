package tests;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {
    CalendarComponents calendarComponents = new CalendarComponents();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final static String titleText = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            inputFile = $("input[type='file']");

    public RegistrationsPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        return this;
    }

    public RegistrationsPage removeBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    private void executeJavaScript(String s) {
    }

    public RegistrationsPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationsPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationsPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationsPage chooseGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationsPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationsPage chooseDateBirthday(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponents.setDateBirthday(day, month, year);
        return this;
    }

    public RegistrationsPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationsPage chooseHobbies() {
        $(byText("Music")).click();
        $(byText("Reading")).click();
        $(byText("Sports")).click();
        return this;
    }

    public RegistrationsPage uploadFile() {
        inputFile.uploadFile(new File("src/test/resources/CV.jpg"));
        return this;
    }

    public RegistrationsPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationsPage setState(String value) {
        $("#state").click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationsPage setCity(String value) {
        $("#city").click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationsPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationsPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationsPage verifyResults(String key, String value){
        registrationResultsModal.verifyResults(key, value);
        return this;
    }
}
