package epam.varchenko.nikita.imageSearch;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.epam.searcher.googlesearch.ImageSearch;

/**
 * The class is used to test the method saveFilesToDisk search image Search
 * 
 * @author Nikita_Varchenko
 *
 */
@RunWith(Parameterized.class)
public class SaveImageToDiskTest {

    private static final String Parh = "C:\\temp\\img\\";// Path file storage
    private final String testSubject;// Object search
    private final int testCount;// Number of results
    ImageSearch name = new ImageSearch();
    File file = new File(Parh);

    
    /**
     * Cleaning Search Folders
     * 
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
    public SaveImageToDiskTest(final String testSubject, final int testCount) {
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
	return Arrays.asList(new Object[][] { { "Slon", 4 }, { "Buffalo", 3 } });
    }

   

    /**
     * Check the names of the stored files from search results
     */
    @Test
    public void TestNamesSavedImage() {
	System.out.println("The test TestNamesSavedImage starts... ");
	int counter = 0;
	name.saveFilesToDisk(testSubject, testCount);
	for (String item : name.getLinksList(testSubject, testCount)) {
	    for (File nameFile : file.listFiles()) {
		if (item.indexOf(nameFile.getName()) >= 1) {
		    counter++;
		}
	    }
	}
	assertTrue("The number of files in the directory are not the same search results", counter == testCount);
	System.out.println("Test finished");
	System.out.println("There is a clean folder storage");
	System.out.println("");
	//DelFiles();
    }

    /**
     * The test checks the number of files in the folder search
     * 
     */
    @Test
    public void TestCountSavedImage() {
	System.out.println("The test TestCountSavedImage starts... ");
	name.saveFilesToDisk(testSubject, testCount);
	System.out.println("There is the same number of check downloaded files: " + file.listFiles().length
		+ ", with initial data: " + testCount);
	assertTrue("The number of files in the directory are not the same search results",
		file.listFiles().length == testCount);
	System.out.println("Test finished");
	System.out.println("There is a clean folder storage");
	System.out.println("");
	//DelFiles();
    }

    /**
     * Check the query with zero results
     */
    @Test
    public void TestZeroSavedImage() {
	System.out.println("The test TestZeroSavedImage starts... ");
	name.saveFilesToDisk(testSubject, 0);
	System.out.println("There is the same number of check downloaded files: " + file.listFiles().length
		+ ", with initial data: 0");
	assertTrue("The number of files in the directory are not the same search results",
		file.listFiles().length == 0);
	System.out.println("Test finished");
	System.out.println("There is a clean folder storage");
	System.out.println("");
	//DelFiles();
    }

}