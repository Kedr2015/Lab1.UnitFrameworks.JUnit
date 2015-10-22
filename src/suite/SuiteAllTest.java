package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ webSearch.GetLinksListWebSearchTest.class, webSearch.SaveFilesToDiskTest.class,
	imageSearch.GetLinksListImageSearchTest.class, imageSearch.SaveImageToDiskTest.class })
@RunWith(Suite.class)
public class SuiteAllTest {

}
