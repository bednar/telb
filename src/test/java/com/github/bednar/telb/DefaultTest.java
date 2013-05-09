package com.github.bednar.telb;

import org.apache.tapestry5.dom.Element;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jakub Bednář (09/05/2013 2:29 PM)
 */
public class DefaultTest extends AbstractUnitTest
{
    @Test
    public void hasGenericCurrentTime()
    {
        Element currentTime = page.getRenderedDocument().getElementById("generic-current-time");

        Assert.assertNotNull(currentTime);
    }

    @Test
    public void genericCurrentTimeValue()
    {
        Element currentTime = page.getRenderedDocument().getElementById("generic-current-time");

        Assert.assertTrue(beforeRenderTime.compareTo(Long.valueOf(currentTime.getChildMarkup())) <= 0);
    }

    @Test
    public void hasGenericIntegerAdd()
    {
        Element integerAdd = page.getRenderedDocument().getElementById("generic-integer-add");

        Assert.assertNotNull(integerAdd);
    }

    @Test
    public void genericIntegerAddValue()
    {
        Element integerAdd = page.getRenderedDocument().getElementById("generic-integer-add");

        Assert.assertEquals("6", integerAdd.getChildMarkup());
    }
}
