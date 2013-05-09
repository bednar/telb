package com.github.bednar.telb.bindings;

import javax.annotation.Nonnull;

import org.apache.tapestry5.Binding;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ioc.Location;
import org.apache.tapestry5.services.BindingFactory;
import org.apache.tapestry5.services.BindingSource;

/**
 * @author Jakub Bednář (08/05/2013 3:32 PM)
 */
public class ELBindingFactory implements BindingFactory
{
    private final String defaultEL;
    private final BindingSource bindingSource;

    public ELBindingFactory(final @Nonnull String defaultEL, final @Nonnull BindingSource bindingSource)
    {
        this.defaultEL = defaultEL;
        this.bindingSource = bindingSource;
    }

    @Override
    public Binding newBinding(final String description,
                              final ComponentResources container,
                              final ComponentResources component,
                              final String expression,
                              final Location location)
    {
        return bindingSource.newBinding(description, container, component, defaultEL, expression, location);
    }
}
