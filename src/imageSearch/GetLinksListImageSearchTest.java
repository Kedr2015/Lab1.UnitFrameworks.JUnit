package imageSearch;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.List;
import com.epam.searcher.googlesearch.*;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * The class is used to test the method getLinksList search web Search
 * 
 * @author Nikita_Varchenko
 *
 */
@RunWith(Theories.class)
public class GetLinksListImageSearchTest {

    List<String> gettingLinks = new ArrayList<String>();
    ImageSearch name = new ImageSearch();

    @DataPoints
    public static Object[][] dateList = new Object[][] { { "giraffe", 8 }, { "Buffalo", 3 } };

    /**
     * Checking the number of search results
     */
    @Theory
    public void checkImageSearchListTest(final Object... testData) {
	System.out.println("Starting with the checkImageSearchListTest of the test parameters:\nSearch for \""
		+ (String) testData[0] + "\"\nThe amount of " + (Integer) testData[1]);
	try {
	    gettingLinks = name.getLinksList((String) testData[0], (Integer) testData[1]);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error method getLinksList\nWith the following parameters:\nSearch for \"" + (String) testData[0]
		    + "\"\nThe amount of " + (Integer) testData[1]);
	}
	assertEquals("Test fails finished.\nList query " + (String) testData[0]
		+ " does not contain the required number of links: ", gettingLinks.size(), testData[1]);
	System.out.println(
		"The results of the method correspond to the input parameters.\nTest successfully finished.\n");
    }

}
