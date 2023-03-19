package tests.top_lists;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_lists.TopListRealPage;
import runner.BaseTest;

import java.util.List;

public class TopListRealTest extends BaseTest {

    @Test
    public void testH2HeaderText() {
        final String expectedText = "Top Rated Real Languages";

        String actualText =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopListRealSubmenu()
                        .getH2MainText()
                        .trim();

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testH2HeaderColor() {
        final String expectedColor = "rgba(27, 101, 28, 1)";

        String actualColor =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopListRealSubmenu()
                        .getH2Main()
                        .getCssValue("color");

        Assert.assertEquals(actualColor, expectedColor);
    }

    @Test
    public void testTableHeaderText() {
        final String expectedTableHeaderText = "# Language Author Date Comments Rate";

        String actualTableHeaderText =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopListRealSubmenu()
                        .getTextStringThTags();

        Assert.assertEquals(actualTableHeaderText, expectedTableHeaderText);
    }

    @Test
    public void testFirstThreeLanguagesInTheTable() {
        final List<String> expectedLanguages = List.of(
                "1. REBOL Anonymous 04/20/05 1",
                "2. NetLogo (Some kind of logo for Multi Agent System) Antoine Cervoise 07/16/10 0",
                "3. clojure (More clojurisk and human readable versio)\tThomas G. Kristensen\t03/08/10\t0"
        );

        TopListRealPage realPage =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopListRealSubmenu();

        Assert.assertEquals(realPage.getTextOneElementFromListTrs(0), expectedLanguages.get(0));
        Assert.assertEquals(realPage.getTextOneElementFromListTrs(1), expectedLanguages.get(1));
        Assert.assertEquals(realPage.getTextOneElementFromListTrs(2), expectedLanguages.get(2));
    }

    @Test
    public void testRandomLinkInTableIsClickable() {

        String oldUrl =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopListRealSubmenu()
                        .getDriver()
                        .getCurrentUrl();

        TopListRealPage realPage = new TopListRealPage(getDriver());

        realPage.getRandomTdLink().click();

        String newUrl = getDriver().getCurrentUrl();

        Assert.assertNotEquals(newUrl, oldUrl);
    }
}