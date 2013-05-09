package com.github.bednar.telb;

import com.github.bednar.telb.pages.Index;
import org.apache.tapestry5.internal.test.TestableResponse;
import org.apache.tapestry5.test.PageTester;
import org.junit.BeforeClass;

/**
 * @author Jakub Bednář (09/05/2013 2:31 PM)
 */
public abstract class AbstractUnitTest
{
    protected static PageTester tester;
    protected static TestableResponse page;

    protected static Long beforeRenderTime;

    @BeforeClass
    public static void initPageTester()
    {
        tester = new PageTester("com.github.bednar.telb", "App", "src/main/webapp");

        beforeRenderTime = System.currentTimeMillis();

        page = tester.renderPageAndReturnResponse(Index.class.getSimpleName());
    }
}
