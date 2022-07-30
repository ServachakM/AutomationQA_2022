package tests.top_lists;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_lists.TopListPage;
import runner.BaseTest;
import tests.TestData;

import java.util.List;

public class TopListTest extends BaseTest {

    @Test(
            priority = 1
    )
    public void testCountSubmenu() {
        int expectedCount = 7;

        int actualCount =
                openBaseURL()
                        .clickTopListsMenu()
                        .getAllSubmenu()
                        .size();

        Assert.assertEquals(actualCount, expectedCount, ">>>Expected count submenu TopLists = 7, but getting failure");
    }

    @Test(
            priority = 2,
            dependsOnMethods = "testCountSubmenu",
            dataProviderClass = TestData.class,
            dataProvider = "TopListSubmenuData"
    )
    public void testSubmenuText(int index, String name, String link) {
        TopListPage topList = new TopListPage(getDriver());

        List<WebElement> submenuElements =
                openBaseURL()
                        .clickTopListsMenu()
                        .getAllSubmenu();

        String submenuText = topList.getText(submenuElements.get(index));
        String submenuLink = topList.getLink(submenuElements.get(index));

        Assert.assertEquals(submenuText, name);
        Assert.assertEquals(submenuLink, link);
    }

    @Test(
            priority = 2
    )
    public void testGoToTheTopRated() {
        final String expectedResult = "Top Rated";

        String actualResult =
                openBaseURL()
                        .clickTopListsMenu()
                        .getH2MainText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(
            priority = 2
    )
    public void testCountOfLanguagesInTopRated() {
        final int expectedResult = 25;

        int actualResult =
                openBaseURL()
                        .clickTopListsMenu()
                        .getCountTDLinks();

        Assert.assertEquals(actualResult, expectedResult);
    }
}