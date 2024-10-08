package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Careers_Page;
import pages.Insider_Home_Page;
import pages.QA_Page;
import pages.View_Role_Page;
import utilities.Driver;
import utilities.Methods;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InsiderTest {
    Insider_Home_Page insiderHomePage = new Insider_Home_Page();
    Careers_Page careers_page = new Careers_Page();
    QA_Page qa_page = new QA_Page();
    View_Role_Page view_role_page = new View_Role_Page();

    ExtentReports extentReport;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    public void Insider_Test (){
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "extentReport/report"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        extentReport.setSystemInfo("Tester","Dilek");
        extentReport.setSystemInfo("Browser","Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentTest = extentReport.createTest("Insider_Test","Test Raporu");

        // 1- Visit https://useinsider.com/ and check Insider home page is opened or not

        Driver.getDriver().get("https://useinsider.com/");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("insider"));
        extentTest.info("Insider Home Page'e gidilir");

        // 2- Select the “Company” menu in the navigation bar, select “Careers”

        insiderHomePage.companyLocate.click();
        Methods.bekle(1);
        insiderHomePage.careersLocate.click();

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("careers"));

        Methods.bekle(1);
        careers_page.acceptCookie.click();
        extentTest.info("Company tiklanir ardindan Careers seçilir");

       // and check Career page, its Locations, Teams, and Life at Insider blocks are open or not

        Methods.scroll(careers_page.seeAllTeamButton);

        Assert.assertTrue(careers_page.seeAllTeamButton.isDisplayed());
        Assert.assertTrue(careers_page.locations.isDisplayed());

        Methods.bekle(1);

        Methods.scroll(careers_page.life);
        Assert.assertTrue(careers_page.life.isDisplayed());
        extentTest.info("Location,Teams,Life at Insider blocklari goruntulenir");

        // 3- Go to https://useinsider.com/careers/quality-assurance/, click “See all QA jobs”, filter jobs by Location:
            // “Istanbul, Turkey”, and Department: “Quality Assurance”, check the presence of the job list

        Driver.getDriver().get("https://useinsider.com/careers/quality-assurance/");
        Methods.bekle(1);
        qa_page.seeAllQAJob.click();
        Methods.bekle(1);

        Methods.scroll_partual();

        Methods.bekle(3);
        qa_page.locationSelection.click();    // lokasyon dropdown una tiklandi

        Methods.bekle(2);
        qa_page.istanbulSelection.click();    // lokasyon istanbul secildi
        qa_page.locationSelection.click();   // dropdown menu kapansin assertler yapilabilsin diye yapilan click

        Methods.bekle(3);
        Assert.assertTrue(qa_page.qaTestFirst.isDisplayed());   // QA ilaninin oldugu dogrulandi
        Assert.assertTrue(qa_page.qaTestSecond.isDisplayed());  // QA ilaninin oldugu dogrulandi
        extentTest.info("Lokasyon Istanbul, Turkey ve Department Quality Assurance olarak filtrelenir," +
                "sonuclarin listelendigi gorulur ");


        // 4- Check that all jobs’ Position contains “Quality Assurance”, Department contains
           //“Quality Assurance”, and Location contains “Istanbul, Turkey”

        Assert.assertTrue(qa_page.locationControl.getText().contains("Istanbul, Turkey"));
        Assert.assertTrue(qa_page.departmentControl.getText().contains("Quality Assurance"));
        Assert.assertTrue(qa_page.positionControl1.getText().contains("Quality Assurance"));
        Assert.assertTrue(qa_page.positionControl2.getText().contains("Quality Assurance"));
        extentTest.info("Istanbul, Turkey ve Quallity Assurance icerdikleri dogrulanir");

        // 5- Click the “View Role” button and check that this action redirects us to the Lever Application form page

        Methods.scroll_partual();
        qa_page.viewRoleButton.click();

        Methods.switchToWindow(1);
        Assert.assertTrue(view_role_page.applyJobButton.isDisplayed());

        Driver.quitDriver();
        extentTest.info("View Role butonuna tiklanip Application form page'e gidilip sayfada oldugumuz dogrulanir");
        extentTest.pass("Test basrili bir sekilde sonuclanir");
        extentReport.flush();
    }

}
