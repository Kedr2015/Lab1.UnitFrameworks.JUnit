package getLinksListExclusionsTest;

import org.junit.Test;

import com.epam.searcher.googlesearch.ImageSearch;
import com.epam.searcher.googlesearch.WebSearch;

public class GetLinksListSearchExcludingTest {
    WebSearch nameWebSearch = new WebSearch();
    ImageSearch nameImageSearch = new ImageSearch();

    /**
     * Checking exception Image Search when receiving the input: Number of
     * results
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkImageListSizeNullTest() {
	System.out.println(
		"The test checkImageListSizeNullTest starts...\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	nameImageSearch.getLinksList("Slon", null);

	System.out.println("Test fails finished. Exclusions IllegalArgumentException It does not appear\n");
    }

    /**
     * Checking exception Image Search when receiving the input: Object search
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkImageListInquiryNullTest() {
	System.out.println(
		"The test checkImageListInquiryNullTest starts...\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	nameImageSearch.getLinksList(null, 3);
	System.out.println("Test fails finished. Exclusions IllegalArgumentException It does not appear\n");
    }

    /**
     * Checking exception Web Search when receiving the input: Number of results
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkWebListSizeNullTest() {
	System.out.println(
		"The test checkWebListSizeNullTest starts...\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	nameWebSearch.getLinksList("Slon", null);

	System.out.println("Test fails finished. Exclusions IllegalArgumentException It does not appear\n");
    }

    /**
     * Checking exception Web Search when receiving the input: Object search
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkWebListInquiryNullTest() {
	System.out.println(
		"The test checkWebListInquiryNullTest starts...\nChecking exclusion if during the test will be the exclusion of its work completed successfully ");
	nameWebSearch.getLinksList(null, 3);
	System.out.println("Test fails finished. Exclusions IllegalArgumentException It does not appear\n");
    }

}
