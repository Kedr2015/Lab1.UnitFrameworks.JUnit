package webSearch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.epam.searcher.googlesearch.*;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * The class is used to test the method getLinksList search web Search
 * 
 * @author Nikita_Varchenko
 *
 */
@RunWith(Parameterized.class)
public class GetLinksListWebSearchTest {

    private final String nameObjectSearch;// Object search
    private final int numberResultsSearch;// Number of results

    List<String> gettingLinks = new ArrayList<String>();
    WebSearch name = new WebSearch();

    /**
     * Constructor initialization parameter tests
     * 
     * @param testSubject
     *            - Object search
     * @param testCount
     *            - Number of results
     */
    public GetLinksListWebSearchTest(final String objectNameSearch, final int numberSearchResults) {
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
	return Arrays.asList(new Object[][] { { "giraffe", 8 }, { "Buffalo", 3 } });
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
     * Checking the number of search results
     */
    @Test
    public void checkWebListTest() {
	System.out.println("Starting with the checkWebListTest of the test parameters:\nSearch for \""
		+ nameObjectSearch + "\"\nThe amount of " + numberResultsSearch);
	assertEquals("Test fails finished.\nList query " + nameObjectSearch
		+ " does not contain the required number of links: ", gettingLinks.size(), numberResultsSearch);
	System.out.println(
		"The results of the method correspond to the input parameters.\nTest successfully finished.\n");
    }

}
