package imageSearch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.epam.searcher.googlesearch.ImageSearch;

/**
 * The class is used to test the method getLinksList search web Search
 * 
 * @author Nikita_Varchenko
 *
 */
@RunWith(Parameterized.class)
public class GetLinksListImageSearchFormatReferencesTest {
    private final String nameObjectSearch;// Object search
    private final int numberResultsSearch;// Number of results

    List<String> gettingLinks = new ArrayList<String>();
    ImageSearch name = new ImageSearch();
    public String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    Pattern patt = Pattern.compile(regex);

    /**
     * Constructor initialization parameter tests
     * 
     * @param testSubject
     *            - Object search
     * @param testCount
     *            - Number of results
     */
    public GetLinksListImageSearchFormatReferencesTest(final String objectNameSearch, final int numberSearchResults) {
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
	return Arrays.asList(new Object[][] { { "Three", 8 }, { "Buffalo", 3 } });
    }

    @Before
    public void beforeActions() {
	try {
	    gettingLinks = name.getLinksList(nameObjectSearch, numberResultsSearch);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error method getLinksList\nWith the following parameters:\nSearch for \"" + nameObjectSearch
		    + "\"\nThe amount of " + numberResultsSearch);
	}
    }

    /**
     * Check the format of search results
     */
    @Test
    public void checkImageSearchFormatReferencesTest() {
	System.out.println("Starting with the checkImageSearchFormatReferencesTest of the test parameters:\nSearch for \""
		+ nameObjectSearch + "\"\nThe amount of " + numberResultsSearch);
	for (String linksSearch : gettingLinks) {// Checking each result
						 // individually
	    System.out.println("Check the format strings search result " + linksSearch);
	    Matcher matcher = patt.matcher(linksSearch);
	    assertTrue(
		    "Test fails finished.\nList of requests: " + nameObjectSearch
			    + " It does not contain the results in the form of links: " + linksSearch,
		    matcher.matches());
	}
	System.out.println(
		"The results of the method correspond to the input parameters.\nTest successfully finished.\n");
    }

}
