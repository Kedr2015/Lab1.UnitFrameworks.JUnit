package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ webSearch.SaveFilesToDiskTest.class, imageSearch.SaveImageToDiskTest.class })
@RunWith(Suite.class)
public class SuiteSaveFilesToDiskTest {

}
