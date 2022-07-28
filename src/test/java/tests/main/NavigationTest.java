package tests.main;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.browse_languages.letters.APage;
import pages.start.StartPage;
import runner.BaseTest;
import tests.TestData;

public class NavigationTest extends BaseTest {

    @Test(
            priority = 2,
            dataProviderClass = TestData.class,
            dataProvider = "MainPageTestData"
    )
    public void testFootersNavigationToUrlAndReturnBackFromBaseURL(
            int index, String footerName, String footerLink, String footerTitle
    ){
        MainPage main = openBaseURL();
        String baseLink = getDriver().getCurrentUrl();
        String baseTitle = getDriver().getTitle();

        main.clickLink(index);
        String newLink = getDriver().getCurrentUrl();
        String newTitle = getDriver().getTitle();

        if(baseTitle.equals(newTitle)) {
            Assert.assertEquals(newLink, baseLink);
        } else {
            Assert.assertNotEquals(newLink, baseLink, ">>>New URL equals previous URL, probably, we are clicking on the same menu<<<");
        }
        Assert.assertEquals(newLink, footerLink);

        getDriver().navigate().back();
        String goBackLink = getDriver().getCurrentUrl();

        Assert.assertNotEquals(newLink, goBackLink);
        if(baseTitle.equals(newTitle)) {
            Assert.assertNotEquals(goBackLink, baseLink);
        } else {
            Assert.assertEquals(goBackLink, baseLink);
        }
    }

    @Test
    public void testMenuStartNavigation() {
        StartPage start = new StartPage(getDriver());

        WebElement oldStartMenu = openBaseURL().getStartMenu();
        WebElement sameStartMenu = start.getStartMenu();

        Assert.assertEquals(oldStartMenu, sameStartMenu);

        String oldCurrentUrl = getDriver().getCurrentUrl();
        start.clickStartMenu();
        String newCurrentUrl = getDriver().getCurrentUrl();

        Assert.assertEquals(newCurrentUrl, oldCurrentUrl);

        WebElement newStartMenuAfterClick = start.getStartMenu();

        Assert.assertNotEquals(oldStartMenu, newStartMenuAfterClick);
    }



    @Test
    public void testNavigationZeroSubmenu() {
        final String text = "0.html";

        String currentUrl =
                openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickZeroSubmenu()
                .getURL();

        APage a = new APage(getDriver());

        Assert.assertTrue(a.getZeroSubmenu().isEnabled());
        Assert.assertTrue(a.getZeroSubmenu().isDisplayed());
        Assert.assertTrue(currentUrl.contains(text));
    }
    
    @Test
    public void testMenuSubmitNewLanguageNavigation() {
        openBaseURL()
                .clickSubmitNewLanguageMenu();

        Assert.assertFalse(getDriver().getPageSource().isEmpty());
        Assert.assertTrue(getDriver().getCurrentUrl().contains("submitnewlanguage"));
   }
   
    @Test
    public void testMenuAbcNavigation() {
        final String expectedMenuAbcNavigation = "http://www.99-bottles-of-beer.net/abc.html";

        openBaseURL()
                .clickBrowseLanguagesMenu();

        String actualMenuAbcNavigation = getDriver().getCurrentUrl();

        Assert.assertFalse(getDriver().getPageSource().isEmpty());
        Assert.assertEquals(actualMenuAbcNavigation, expectedMenuAbcNavigation);
    }

    @Test
    public void testMenuSearchNavigation() {
        final String expectedMenuSearchNavigation = "http://www.99-bottles-of-beer.net/search.html";

        openBaseURL()
                .clickSearchLanguagesMenu();

        String actualMenuSearchNavigation = getDriver().getCurrentUrl();

        Assert.assertFalse(getDriver().getPageSource().isEmpty());
        Assert.assertEquals(actualMenuSearchNavigation, expectedMenuSearchNavigation);
    }

    @Test
    public void testMenuTopListNavigation() {
        final String expectedMenuTopListNavigation = "http://www.99-bottles-of-beer.net/toplist.html";

        openBaseURL()
                .clickTopListsMenu();

        String actualMenuTopListNavigation = getDriver().getCurrentUrl();

        Assert.assertFalse(getDriver().getPageSource().isEmpty());
        Assert.assertEquals(actualMenuTopListNavigation, expectedMenuTopListNavigation);
    }

    @Test
    public void testMenuGuestbookV2Navigation() {
        final String expectedMenuGuestbookV2Navigation = "guestbookv2.html";

        openBaseURL().clickGuestbookV2Menu();

        Assert.assertTrue(getDriver()
                .getCurrentUrl()
                .contains(expectedMenuGuestbookV2Navigation));
    }
}