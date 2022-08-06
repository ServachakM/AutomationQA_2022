package tests;

import org.testng.annotations.DataProvider;
import runner.TestUtils;

public class TestData extends TestUtils {

    @DataProvider(name = "MainPageTestData")
    public static Object[][] mainDataProvider() {

        return new Object[][]{
                {0, "Start", "http://www.99-bottles-of-beer.net/", "Start"},
                {1, "Browse Languages", "http://www.99-bottles-of-beer.net/abc.html", "Browse category A"},
                {2, "Search Languages", "http://www.99-bottles-of-beer.net/search.html", "Search Languages"},
                {3, "Top Lists", "http://www.99-bottles-of-beer.net/toplist.html", "Top Rated"},
                {4, "Guestbook", "http://www.99-bottles-of-beer.net/guestbookv2.html", "Guestbook"},
                {5, "Submit new Language", "http://www.99-bottles-of-beer.net/submitnewlanguage.html", "Submit new Language"}
        };
    }

    @DataProvider(name = "SubmenuStartData")
    public static Object[][] submenuStartDataProvider() {

        return new Object[][]{
                {0, "Team", "http://www.99-bottles-of-beer.net/team.html"},
                {1, "Song Lyrics", "http://www.99-bottles-of-beer.net/lyrics.html"},
                {2, "History", "http://www.99-bottles-of-beer.net/info.html"},
                {3, "Privacy", "http://www.99-bottles-of-beer.net/impressum.html"}
        };
    }

    @DataProvider(name = "TopListSubmenuData")
    public static Object[][] submenuTopListDataProvider() {

        return new Object[][] {
                {0, "Top Rated", "http://www.99-bottles-of-beer.net/toplist.html"},
                {1, "Top Rated Real", "http://www.99-bottles-of-beer.net/toplist_real.html"},
                {2, "Top Rated Esoteric", "http://www.99-bottles-of-beer.net/toplist_esoteric.html"},
                {3, "Top Rated Assembly", "http://www.99-bottles-of-beer.net/toplist_assembly.html"},
                {4, "Top Hits", "http://www.99-bottles-of-beer.net/tophits.html"},
                {5, "New Languages this month", "http://www.99-bottles-of-beer.net/toplist_newlanguagesthismonth.html"},
                {6, "New Comments", "http://www.99-bottles-of-beer.net/newcomments.html"},
        };
    }

    @DataProvider(name = "SubmitNewLanguageData")
    public static Object[][] submitNewLanguageDataProvider() {

        return new Object[][]{
                {getRandomStr(10), getRandomStr(5), getRandomStr(5) + "@gmail.com", Integer.toString(getRandomNumbers(4)), getRandomStr(15)},
                {getRandomStr(10), getRandomStr(5), getRandomStr(5) + "@gmail.com", Integer.toString(getRandomNumbers(4)), getRandomStr(15)},
                {getRandomStr(10), getRandomStr(5), getRandomStr(5) + "@gmail.com", Integer.toString(getRandomNumbers(4)), getRandomStr(15)},
                {getRandomStr(10), getRandomStr(5), getRandomStr(5) + "@gmail.com", Integer.toString(getRandomNumbers(4)), getRandomStr(15)},
                {getRandomStr(10), getRandomStr(5), getRandomStr(5) + "@gmail.com", Integer.toString(getRandomNumbers(4)), getRandomStr(15)},
        };
    }

    @DataProvider(name = "SearchLanguagesData")
    public static Object[][] searchLanguagesDataProvider() {

        return new Object[][] {
                {"", 0},
                {"     ", 0},
                {".", 18},
                {"1", 27},
                {"5", 19},
                {"#", 19},
                {"java", 14},
                {"python", 11},
                {"bug", 1}
        };
    }
}
