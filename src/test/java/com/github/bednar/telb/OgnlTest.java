package com.github.bednar.telb;

import org.apache.tapestry5.dom.Element;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jakub Bednář (09/05/2013 3:00 PM)
 */
public class OgnlTest extends AbstractUnitTest
{
    @Test
    public void hasOgnlCurrentTime()
    {
        Element currentTime = page.getRenderedDocument().getElementById("ognl-current-time");

        Assert.assertNotNull(currentTime);
    }

    @Test
    public void ognlCurrentTimeValue()
    {
        Element currentTime = page.getRenderedDocument().getElementById("ognl-current-time");

        Assert.assertTrue(beforeRenderTime.compareTo(Long.valueOf(currentTime.getChildMarkup())) <= 0);
    }

    @Test
    public void hasOgnlIntegerAdd()
    {
        Element integerAdd = page.getRenderedDocument().getElementById("ognl-integer-add");

        Assert.assertNotNull(integerAdd);
    }

    @Test
    public void ognlIntegerAddValue()
    {
        Element integerAdd = page.getRenderedDocument().getElementById("ognl-integer-add");

        Assert.assertEquals("6", integerAdd.getChildMarkup());
    }
}
