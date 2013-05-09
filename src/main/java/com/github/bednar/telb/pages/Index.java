package com.github.bednar.telb.pages;

import javax.annotation.Nonnull;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;

/**
 * @author Jakub Bednář (08/05/2013 2:37 PM)
 */
public class Index
{
    @Property
    private String testingString;

    @SetupRender
    void initValues()
    {
        testingString = "property value";
    }

    @Nonnull
    public Integer getTestingInteger()
    {
        return 5;
    }
}
