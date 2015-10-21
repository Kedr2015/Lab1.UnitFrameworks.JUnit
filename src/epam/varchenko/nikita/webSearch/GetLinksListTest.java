package epam.varchenko.nikita.webSearch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.epam.searcher.googlesearch.*;

import org.junit.Test;
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
public class GetLinksListTest {
    /**
     * Parameter tests
     * 
     */
    @DataPoints
    public static Object[][] testData = new Object[][] { { "giraffe", 4 }, { "Buffalo", 3 } };

    List<String> supplierNames = new ArrayList<String>();
    WebSearch name = new WebSearch();
    public String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    Pattern patt = Pattern.compile(regex);

    /**
     * Checking the number of search results
     */
    @Theory
    public void checkList(final Object... testData) {
	System.out.println("The test checkList starts... ");
	supplierNames = name.getLinksList((String) testData[0], (Integer) testData[1]);
	System.out.println("Number of expected results " + (Integer) testData[1]);
	assertTrue("The list does not contain the right amount of links",
		supplierNames.size() == (Integer) testData[1]);
	System.out.println("Test finished");
	System.out.println("");
    }

    /**
     * Checking the name of search results
     */
    @Theory
    public void checkReferences(final Object... testData) {
	System.out.println("The test checkReferences starts... ");
	supplierNames = name.getLinksList((String) testData[0], (int) testData[1]);
	for (String item : supplierNames) {
	    Matcher matcher = patt.matcher(item);
	    assertTrue("The list contains no links: " + item, matcher.matches());
	    System.out.println("Test finished");
	    System.out.println("");
	}
    }

    /**
     * Check with zero search results
     */
    @Theory
    public void checkListQueryEmpty(final Object... testData) {
	System.out.println("The test checkListQueryEmpty starts... ");
	supplierNames = name.getLinksList((String) testData[0], 0);
	assertTrue("The list contains links", supplierNames.size() == 0);
	System.out.println("Test finished");
	System.out.println("");
    }

    /**
     * Check with zero search results
     */
    @Theory
    public void checkListQueryZero() {
	System.out.println("The test checkListQueryZero starts... ");
	supplierNames = name.getLinksList("", 0);
	assertTrue("The list contains links", supplierNames.size() == 0);
	System.out.println("Test finished");
	System.out.println("");
    }

    /**
     * Check with a blank search results
     */
    @Theory
    public void checkListQueryGap() {
	System.out.println("The test checkListQueryGap starts... ");
	supplierNames = name.getLinksList(" ", 0);
	assertTrue("The list contains links", supplierNames.size() == 0);
	System.out.println("Test finished");
	System.out.println("");
    }

    /**
     * Checking the extreme number of search results
     */
    @Theory
    public void checkListQueryMax(final Object... testData) {
	System.out.println("The test checkListQueryMax starts... ");
	supplierNames = name.getLinksList((String) testData[0], 8);
	assertTrue("The list contains 8 links", supplierNames.size() == 8);
	System.out.println("Test finished");
	System.out.println("");
    }

    /**
     * Check the number of overflows search results
     */
    @Theory
    public void checkListQueryZeroing() {
	System.out.println("The test checkListQueryZeroing starts... ");
	supplierNames = name.getLinksList(" ", 9);
	assertTrue("The list contains links", supplierNames.size() == 0);
	System.out.println("Test finished");
	System.out.println("");
    }

    /**
     * Checking exception when receiving the input: Number of results
     */
    @Theory
    @Test(expected = IllegalArgumentException.class)
    public void checkListSizeNull(final Object... testData) {
	System.out.println(
		"The test checkListSizeNull starts.\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	name.getLinksList((String) testData[0], null);

    }

    /**
     * Checking exception when receiving the input: Object search
     */
    @Theory
    @Test(expected = IllegalArgumentException.class)
    public void checkListInquiryNull() {
	System.out.println(
		"The test checkListInquiryNull starts.\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	name.getLinksList(null, 3);
    }

}
