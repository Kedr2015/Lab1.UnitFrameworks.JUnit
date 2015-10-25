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
    private final String nameObjectSearch;// Object search
    private final int numberResultsSearch;// Number of results
    WebSearch name = new WebSearch();
    File file = new File(Parh);

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
     * Constructor initialization parameter tests
     * 
     * @param testSubject
     *            - Object search
     * @param testCount
     *            - Number of results
     */
    public SaveFilesToDiskTest(final String testSubject, final int testCount) {
	this.nameObjectSearch = testSubject;
	this.numberResultsSearch = testCount;
    }

    /**
     * Input parameters for the test
     * 
     * @return List Object
     */
    @Parameters
    public static List<Object[]> isEmptyData() {
	return Arrays.asList(new Object[][] { { "giraffe", 8 }, { "Buffalo", 3 }, { "Buffalo", 0 }, { "", 0 },
		{ "", 1 }, { " ", 0 }, { "Buffalo", 9 } });
    }

    /**
     * Check the names of the stored files from search results
     */
    @Test
    public void namesSavedFilesTest() {
	System.out.println("Starting with the NamesSavedImageTest of the test parameters:\nSearch for \""
		+ nameObjectSearch + "\"\nThe amount of " + numberResultsSearch);
	int numberFilesInDirectory = 0;
	try {
	    name.saveFilesToDisk(nameObjectSearch, numberResultsSearch);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error method saveFilesToDisk\nWith the following parameters:\nSearch for \"" + nameObjectSearch
		    + "\"\nThe amount of " + numberResultsSearch);
	}
	try {
	    for (String item : name.getLinksList(nameObjectSearch, numberResultsSearch)) {
		for (File nameFileInDirectory : file.listFiles()) {
		    if (item.indexOf(nameFileInDirectory.getName()) >= 1) {
			numberFilesInDirectory++;
		    }
		}
	    }
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error method getLinksList\nWith the following parameters:\nSearch for \"" + nameObjectSearch
		    + "\"\nThe amount of " + numberResultsSearch);
	}
	assertEquals("Test fails finished.\nThe number of files in the directory are not the same search results ",
		file.listFiles().length, numberResultsSearch);
	assertEquals("Test fails finished.\nIn the catalog, not all the files " + numberResultsSearch,
		numberFilesInDirectory, numberResultsSearch);
	System.out.println("Test successfully finished.\n");
    }
}
