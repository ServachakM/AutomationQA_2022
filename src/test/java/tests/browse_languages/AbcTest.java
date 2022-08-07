package tests.browse_languages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.AbcPage;
import runner.BaseTest;
import tests.TestData;

import java.util.List;

public class AbcTest extends BaseTest {

    @Test
    public void testHowManyCategoriesInBrowseLanguage() {
        int expectedResult = 27;

        int actualResult =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getAllSubmenu()
                        .size();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTableTitles() {
        String expectedTableTitles = "Language, Author, Date, Comments, Rate";

        String actualTableTitles =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getTitlesTable();

        Assert.assertEquals(actualTableTitles, expectedTableTitles);
    }

    @Test
    public void testTextZeroSubmenu() {
        final String expectedTextZeroSubmenu = "0-9";

        String actualTextZeroSubmenu =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getZeroSubmenuText();

        Assert.assertEquals(actualTextZeroSubmenu, expectedTextZeroSubmenu);
    }

    @Test
    public void testLinkTextZeroSubmenu() {
        final String expectedLinkTextZeroSubmenu = "http://www.99-bottles-of-beer.net/0.html";

        String actualLinkTextZeroSubmenu =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getZeroSubmenu()
                        .getAttribute("href");

        Assert.assertEquals(actualLinkTextZeroSubmenu, expectedLinkTextZeroSubmenu);
    }

    @Test
    public void testAllNamesOfSubmenu() {

        final String expectedResultAllNamesOfSubmenu = "0-9ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String actualResultAllNamesOfSubmenu = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getAllNamesOfSubmenu();

        Assert.assertEquals(
                actualResultAllNamesOfSubmenu, expectedResultAllNamesOfSubmenu);
    }

    @Test
    public void testSubmitNewLanguageCategoryL() {
        final String expectedResult = "Category L";

        String actualResult =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickLSubmenu()
                        .getH2MainText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(
            dataProviderClass = TestData.class,
            dataProvider = "BrowseLanguagesData"
    )
    public void testLinksAndTextAllSubmenu(int index, String submenuName, String link) {
        List<WebElement> submenuElements =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getAllSubmenu();

        AbcPage abc = new AbcPage(getDriver());

        String actualLink = abc.getLink(submenuElements.get(index));
        String actualTextSubmenu  = abc.getText(submenuElements.get(index));

        Assert.assertEquals(actualLink, link);
        Assert.assertEquals(actualTextSubmenu, submenuName.toUpperCase());
    }

    @Test(
            dataProviderClass = TestData.class,
            dataProvider = "BrowseLanguagesData"
    )
    public void testH2MainAllSubmenu(int index, String submenuName, String link) {
        final String expectedH2Main = "Category " + submenuName.toUpperCase();

        AbcPage abc = new AbcPage(getDriver());

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickSubmenu(index);

        String actualH2Main = abc.getH2MainText();

        Assert.assertEquals(actualH2Main, expectedH2Main);
    }

    @Test(
            dependsOnMethods = "testH2MainAllSubmenu",
            dataProviderClass = TestData.class,
            dataProvider = "BrowseLanguagesData"
    )
    public void testClickAllSubmenuAndVerifyFirstLetterInEveryLanguage(int index, String submenuName, String link) {
        AbcPage abc = new AbcPage(getDriver());

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickSubmenu(index);

        List<String> listOfLanguages = abc.getListStringTDLinks();

        for (String language : listOfLanguages) {

            if (submenuName.equals("0-9")) {

                Assert.assertTrue(language.charAt(0) > 47 && language.charAt(0) < 58);
            } else {

                Assert.assertTrue(
                        language.substring(0, 1).equalsIgnoreCase(submenuName));
            }
        }
    }
}