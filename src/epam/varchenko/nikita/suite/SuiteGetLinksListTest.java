package epam.varchenko.nikita.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ epam.varchenko.nikita.imageSearch.GetLinksListTest.class,
	epam.varchenko.nikita.webSearch.GetLinksListTest.class, })
@RunWith(Suite.class)
public class SuiteGetLinksListTest {

}
