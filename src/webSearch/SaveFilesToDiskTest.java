package webSearch;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.epam.searcher.googlesearch.WebSearch;

/**
 * The class is used to test the method saveFilesToDisk search web Search
 * 
 * @author Nikita_Varchenko
 *
 */
@RunWith(Parameterized.class)
public class SaveFilesToDiskTest {

    private static final String Parh = "C:\\temp\\web\\";// Path file storage
    private final String testSubject;// Object search
    private final int testCount;// Number of results
    WebSearch name = new WebSearch();
    File file = new File(Parh);

    /**
     * Constructor initialization parameter tests
     * 
     * @param testSubject
     *            - Object search
     * @param testCount
     *            - Number of results
     */
    public SaveFilesToDiskTest(final String testSubject, final int testCount) {
	this.testSubject = testSubject;
	this.testCount = testCount;
    }

    /**
     * Input parameters for the test
     * 
     * @return List Object
     */
    @Parameters
    public static List<Object[]> isEmptyData() {
	return Arrays.asList(new Object[][] { { "giraffe", 3 }, { "Buffalo", 4 }

	});
    }

    /**
     * Clears folders, before running the test
     */
    @Before
    public void DelFiles() {
	for (File dirDel : new File(Parh).listFiles())
	    if (dirDel.isFile()) {
		dirDel.delete();
	    }
    }

    /**
     * Check the names of the stored files from search results
     */
    @Test
    public void NamesSavedWebTest() {
	System.out.println("The test NamesSavedImageTest starts... ");
	int counter = 0;
	try {
	    name.saveFilesToDisk(testSubject, testCount);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method saveFilesToDisk");
	}
	try {
	    for (String item : name.getLinksList(testSubject, testCount)) {
		for (File nameFile : file.listFiles()) {
		    if (item.indexOf(nameFile.getName()) >= 1) {
			counter++;
		    }
		}
	    }
	} catch (ArithmeticException e) {
	    fail("Fatal error when performing the method getLinksList");
	}
	assertTrue("Test fails finished.\nThe number of files in the directory " + counter
		+ ", are not the same search results " + testCount, counter == testCount);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * The test checks the number of files in the folder search
     * 
     */
    @Test
    public void CountSavedWebTest() {
	System.out.println("The test CountSavedImageTest starts... ");
	try {
	    name.saveFilesToDisk(testSubject, testCount);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method saveFilesToDisk");
	}
	System.out.println("There is the same number of check downloaded files: " + file.listFiles().length
		+ ", with initial data: " + testCount);
	assertTrue("Test fails finished.\nThe number of files in the directory are not the same search results",
		file.listFiles().length == testCount);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Check the query with zero results
     */
    @Test
    public void TestZeroSavedWeb() {
	System.out.println("The test TestZeroSavedImage starts... ");
	try {
	    name.saveFilesToDisk(testSubject, 0);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error when performing the method saveFilesToDisk");
	}
	System.out.println("There is the same number of check downloaded files: " + file.listFiles().length
		+ ", with initial data: 0");
	assertTrue("Test fails finished.\nThe number of files in the directory are not the same search results",
		file.listFiles().length == 0);
	System.out.println("Test successfully finished.\n");
    }

}
