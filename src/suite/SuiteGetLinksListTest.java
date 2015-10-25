package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ webSearch.GetLinksListWebSearchTest.class, imageSearch.GetLinksListImageSearchTest.class,
	getLinksListExclusionsTest.GetLinksListSearchExcludingTest.class })
@RunWith(Suite.class)
public class SuiteGetLinksListTest {

}
