package imageSearch;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.epam.searcher.googlesearch.ImageSearch;

@RunWith(Parameterized.class)
public class GetLinksListImageSearchExcludingTest {

    ImageSearch nameWebSearch = new ImageSearch();
    private final String nameObjectSearch;// Object search
    private final Integer numberResultsSearch;// Number of results

    /**
     * Constructor initialization parameter tests
     * 
     * @param testSubject
     *            - Object search
     * @param testCount
     *            - Number of results
     */
    public GetLinksListImageSearchExcludingTest(final String objectNameSearch, final Integer numberSearchResults) {
	this.nameObjectSearch = objectNameSearch;
	this.numberResultsSearch = numberSearchResults;
    }

    /**
     * Input parameters for the test
     * 
     * @return List Object
     */
    @Parameters
    public static List<Object[]> isEmptyData() {
	return Arrays.asList(new Object[][] { { "Slon", null }, { null, 3 } });
    }

    /**
     * Checking exception Web Search when receiving the input
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkImageSearchExcludingTest() {
	System.out.println(
		"The test checkImageSearchExcludingTest starts...\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	nameWebSearch.getLinksList(nameObjectSearch, numberResultsSearch);
	System.out.println("Test fails finished. Exclusions IllegalArgumentException It does not appear\n");
    }

}
