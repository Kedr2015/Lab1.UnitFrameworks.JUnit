package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ webSearch.GetLinksListWebSearchTest.class, imageSearch.GetLinksListImageSearchTest.class, })
@RunWith(Suite.class)
public class SuiteGetLinksListTest {

}
