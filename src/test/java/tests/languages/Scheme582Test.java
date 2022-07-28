package tests.languages;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class Scheme582Test extends BaseTest {

    @Test
    public void testUrlSchemeLanguage() {
        final String expectedUrl = "http://www.99-bottles-of-beer.net/language-scheme-582.html";
        final String SchemeLanguage = "Scheme (original version)";

        String actualUrl =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopListRealSubmenu()
                        .clickLanguage(SchemeLanguage)
                        .getURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void testHeaderTextSchemeLanguage() {
        final String expectedHeader = "Language Scheme";
        final String SchemeLanguage = "Scheme (original version)";

        String actualHeader =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopListRealSubmenu()
                        .clickLanguage(SchemeLanguage)
                        .getH2MainText();

        Assert.assertEquals(actualHeader, expectedHeader);
    }
}
