package tests.top_lists;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import tests.TestData;

import java.util.List;

public class TopListTest extends BaseTest {

    @Test
    public void testGoToTheTopRated() {
        final String expectedResult = "Top Rated";

        String actualResult =
                openBaseURL()
                        .clickTopListsMenu()
                                .getH2MainText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCountOfLanguagesInTopRated() {
        final int expectedResult = 25;

        int actualResult =
                openBaseURL()
                        .clickTopListsMenu()
                        .getCountTDLinks();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(  priority = 1,
            dataProviderClass = TestData.class,
            dataProvider = "TopListSubmenuData"
    )
    public void testSubmenuText( int index, String name) {

        List<WebElement> names =
                openBaseURL()
                        .clickTopListsMenu()
                        .getAllSubmenu();

        String nameText = names.get(index).getText();

        Assert.assertEquals(nameText, name);
    }
}
