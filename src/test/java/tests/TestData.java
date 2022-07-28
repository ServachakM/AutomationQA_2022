package tests;

import org.testng.annotations.DataProvider;

public class TestData {

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

    @DataProvider(name = "TopListSubmenuData")
    public static Object[][] submenuDataProvider() {

        return new Object[][] {
                {0, "Top Rated"},
                {1, "Top Rated Real"},
                {2, "Top Rated Esoteric"},
                {3, "Top Rated Assembly"},
                {4, "Top Hits"},
                {5, "New Languages this month"},
                {6, "New Comments"},
        };
    }
}
