package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends BaseTest {



    @Test
    void fillTestForm() {

        registrationsPage
                .openPage()
                .setFirstName("Mikhail")
                .setLastName("Zhuravlev")
                .setEmail("miha99_66@mail.ru")
                .chooseGender("Male")
                .setPhoneNumber("9126298333")
                .chooseDateBirthday("27", "May", "1988")
                .setSubjects("Commerce")
                .chooseHobbies()
                .uploadFile()
                .setAddress("Kras")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        registrationsPage.verifyResultsModalAppears()
                .verifyResults("Student Name","Mikhail Zhuravlev")
                .verifyResults("Student Email", "miha99_66@mail.ru")
                .verifyResults("Gender", "Male")
                .verifyResults("Mobile", "9126298333")
                .verifyResults("Date of Birth", "27 May,1988")
                .verifyResults("Subjects", "Commerce")
                .verifyResults("Hobbies", "Music, Reading, Sports")
                .verifyResults("Picture", "CV.jpg")
                .verifyResults("Address", "Kras")
                .verifyResults("State and City", "NCR Delhi");

    }
}
