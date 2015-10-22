package imageSearch;

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
 * The class is used to test the method getLinksList search image Search
 * 
 * @author Nikita_Varchenko
 *
 */
@RunWith(Theories.class)
public class GetLinksListImageSearchTest {

    /**
     * Parameter tests
     * 
     */
    @DataPoints
    public static Object[][] testData = new Object[][] { { "giraffe", 4 }, { "Buffalo", 3 } };

    List<String> supplierNames = new ArrayList<String>();
    ImageSearch name = new ImageSearch();
    public String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    Pattern patt = Pattern.compile(regex);

    /**
     * Checking the number of search results
     */
    @Theory
    public void checkImageListTest(final Object... testData) {
	System.out.println("The test checkListTest starts... ");
	try {
	    supplierNames = name.getLinksList((String) testData[0], (Integer) testData[1]);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method getLinksList");
	}
	System.out.println("Number of expected results " + (Integer) testData[1]);
	assertTrue("Test fails finished.\nThe list does not contain the right amount of links: " + (Integer) testData[1]
		+ " instead " + supplierNames.size(), supplierNames.size() == (Integer) testData[1]);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Checking the name of search results
     */
    @Theory
    public void checkImageReferencesTextTest(final Object... testData) {
	System.out.println("The test checkReferencesTextTest starts... ");
	try {
	    supplierNames = name.getLinksList((String) testData[0], (int) testData[1]);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method getLinksList");
	}
	for (String item : supplierNames) {
	    Matcher matcher = patt.matcher(item);
	    System.out.println("Check the format string " + item);
	    assertTrue("Test fails finished.\nThe list contains no links: " + item, matcher.matches());
	}
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Check with zero search results
     */
    @Theory
    public void checkImageListQueryEmptyTest(final Object... testData) {
	System.out.println("The test checkListQueryEmptyTest starts... ");
	try {
	    supplierNames = name.getLinksList((String) testData[0], 0);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method getLinksList");
	}
	System.out.println("Check the result on the absence of references");
	assertTrue("Test fails finished.\nThe list contains links", supplierNames.size() == 0);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Check with zero search results
     */
    @Theory
    public void checkImageListQueryZeroTest() {
	System.out.println("The test checkListQueryZeroTest starts... ");
	try {
	    supplierNames = name.getLinksList("", 0);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method getLinksList");
	}
	System.out.println("Check the result on the absence of references");
	assertTrue("Test fails finished.\nThe list contains links", supplierNames.size() == 0);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Check with a blank search results
     */
    @Theory
    public void checkImageListQueryGap() {
	System.out.println("The test checkListQueryGap starts... ");
	try {
	    supplierNames = name.getLinksList(" ", 0);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method getLinksList");
	}
	System.out.println("Check the result on the absence of references");
	assertTrue("Test fails finished.\nThe list contains links", supplierNames.size() == 0);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Checking the extreme number of search results
     */
    @Theory
    public void checkImageListQueryMaxTest(final Object... testData) {
	System.out.println("The test checkListQueryMaxTest starts... ");
	try {
	    supplierNames = name.getLinksList((String) testData[0], 8);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method getLinksList");
	}
	System.out.println("Check the result on the absence of references");
	assertTrue("Test fails finished.\nThe list contains 8 links", supplierNames.size() == 8);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Check the number of overflows search results
     */
    @Theory
    public void checkImageListQueryZeroingTest() {
	System.out.println("The test checkListQueryZeroingTest starts... ");
	try {
	    supplierNames = name.getLinksList(" ", 9);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method getLinksList");
	}
	System.out.println("Check the result on the absence of references");
	assertTrue("Test fails finished.\nThe list contains links", supplierNames.size() == 0);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Checking exception when receiving the input: Number of results
     */
    @Theory
    @Test(expected = IllegalArgumentException.class)
    public void checkImageListSizeNullTest(final Object... testData) {
	System.out.println(
		"The test checkListSizeNull starts...\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	name.getLinksList((String) testData[0], null);
	System.out.println("Test fails finished.\n");
    }

    /**
     * Checking exception when receiving the input: Object search
     */
    @Theory
    @Test(expected = IllegalArgumentException.class)
    public void checkImageListInquiryNullTest() {
	System.out.println(
		"The test checkListInquiryNull starts...\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	name.getLinksList(null, 3);
	System.out.println("Test fails finished.\n");
    }

}
