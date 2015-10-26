package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ webSearch.GetLinksListWebSearchEmptyResultsTest.class,
	webSearch.GetLinksListWebSearchExcludingTest.class, webSearch.GetLinksListWebSearchFormatReferencesTest.class,
	webSearch.GetLinksListWebSearchTest.class, imageSearch.GetLinksListImageSearchEmptyResultsTest.class,
	imageSearch.GetLinksListImageSearchExcludingTest.class,
	imageSearch.GetLinksListImageSearchFormatReferencesTest.class, imageSearch.GetLinksListImageSearchTest.class })
@RunWith(Suite.class)
public class SuiteGetLinksListTest {

}
