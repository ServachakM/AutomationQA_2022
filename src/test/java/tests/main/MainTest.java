package tests.main;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void testH1HeaderText() {
        final String expectedH1HeaderText = "99 Bottles of Beer";

        String actualH1HeaderText =
                openBaseURL()
                        .getH1HeaderText();

        Assert.assertEquals(actualH1HeaderText, expectedH1HeaderText);
    }

    @Test
    public void testH2HeaderText() {
        final String expectedH2HeaderText = "one program in 1500 variations";

        String actualH2HeaderText =
                openBaseURL()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2HeaderText, expectedH2HeaderText);
    }

    @Test
    public void testOnloadSettings() {
        final String expectedOnloadSettings = "off('addcomments');";

        String actualOnloadSettings =
                openBaseURL()
                        .getOnloadSettings()
                        .getAttribute("onload");

        Assert.assertEquals(actualOnloadSettings, expectedOnloadSettings);
    }

    @Test
    public void testMenuStartText() {
        final String expectedMenuStartText = "Start";

        String actualMenuStartText =
                openBaseURL()
                        .getStartMenu()
                        .getText();

        Assert.assertEquals(actualMenuStartText, expectedMenuStartText.toUpperCase());
    }

    @Test
    public void testMenuStartLinkText() {
        final String expectedMenuStartLinkText = "http://www.99-bottles-of-beer.net/";

        String actualMenuStartLinkText =
                openBaseURL()
                        .getStartMenu()
                        .getAttribute("href");

        Assert.assertEquals(actualMenuStartLinkText, expectedMenuStartLinkText);
    }

    @Test
    public void testMenuAbcText() {
        final String expectedMenuAbcText = "Browse Languages".toUpperCase();

        String actualMenuAbcText =
                openBaseURL()
                        .getABCMenu()
                        .getText();

        Assert.assertEquals(actualMenuAbcText, expectedMenuAbcText);
    }

    @Test
    public void testMenuAbcLinkText() {
        final String expectedMenuAbcLinkText = "http://www.99-bottles-of-beer.net/abc.html";

        String actualMenuAbcLinkText =
                openBaseURL()
                        .getABCMenu()
                        .getAttribute("href");

        Assert.assertEquals(actualMenuAbcLinkText, expectedMenuAbcLinkText);
    }

    @Test
    public void testMenuSearchText() {
        final String expectedMenuSearchText = "Search Languages".toUpperCase();

        String actualMenuSearchText =
                openBaseURL()
                        .getSearchMenu()
                        .getText();

        Assert.assertEquals(actualMenuSearchText, expectedMenuSearchText);
    }

    @Test
    public void testMenuSearchLinkText() {
        final String expectedMenuSearchLinkText = "http://www.99-bottles-of-beer.net/search.html";

        String actualMenuSearchLinkText =
                openBaseURL()
                        .getSearchMenu()
                        .getAttribute("href");

        Assert.assertEquals(actualMenuSearchLinkText, expectedMenuSearchLinkText);
    }

    @Test
    public void testMenuTopListText() {
        final String expectedMenuTopListText = "Top Lists".toUpperCase();

        String actualMenuTopListText =
                openBaseURL()
                        .getTopListMenu()
                        .getText();

        Assert.assertEquals(actualMenuTopListText, expectedMenuTopListText);
    }

    @Test
    public void testMenuTopListLinkText() {
        final String expectedMenuTopListLinkText = "http://www.99-bottles-of-beer.net/toplist.html";

        String actualMenuTopListLinkText =
                openBaseURL()
                        .getTopListMenu()
                        .getAttribute("href");

        Assert.assertEquals(actualMenuTopListLinkText, expectedMenuTopListLinkText);
    }

    @Test
    public void testMenuGuestbookV2Text() {
        final String expectedMenuGuestbookV2Text = "Guestbook".toUpperCase();

        String actualMenuGuestbookV2Text = openBaseURL()
                .getGuestbookV2Menu()
                .getText();

        Assert.assertEquals(actualMenuGuestbookV2Text, expectedMenuGuestbookV2Text);
    }

    @Test
    public void testMenuGuestbookV2LinkText() {
        final String expectedMenuGuestbookV2LinkText = "http://www.99-bottles-of-beer.net/guestbookv2.html";

        String actualMenuGuestbookV2LinkText = openBaseURL()
                .getGuestbookV2Menu()
                .getAttribute("href");

        Assert.assertEquals(actualMenuGuestbookV2LinkText, expectedMenuGuestbookV2LinkText);
    }
}
