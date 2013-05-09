package com.github.bednar.telb;

import org.apache.tapestry5.dom.Element;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jakub Bednář (09/05/2013 3:01 PM)
 */
public class MvelTest extends AbstractUnitTest
{
    @Test
    public void hasMvelCurrentTime()
    {
        Element currentTime = page.getRenderedDocument().getElementById("mvel-current-time");

        Assert.assertNotNull(currentTime);
    }

    @Test
    public void mvelCurrentTimeValue()
    {
        Element currentTime = page.getRenderedDocument().getElementById("mvel-current-time");

        Assert.assertTrue(beforeRenderTime.compareTo(Long.valueOf(currentTime.getChildMarkup())) <= 0);
    }

    @Test
    public void hasMvelIntegerAdd()
    {
        Element integerAdd = page.getRenderedDocument().getElementById("mvel-integer-add");

        Assert.assertNotNull(integerAdd);
    }

    @Test
    public void mvelIntegerAddValue()
    {
        Element integerAdd = page.getRenderedDocument().getElementById("mvel-integer-add");

        Assert.assertEquals("6", integerAdd.getChildMarkup());
    }
}
