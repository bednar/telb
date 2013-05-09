package com.github.bednar.telb.bindings;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import ognl.Ognl;
import ognl.OgnlException;
import org.apache.tapestry5.internal.bindings.AbstractBinding;
import org.apache.tapestry5.ioc.Location;
import org.apache.tapestry5.ioc.internal.util.TapestryException;
import org.apache.tapestry5.runtime.Component;

/**
 * @author Jakub Bednář (08/05/2013 3:25 PM)
 */
public class OgnlBinding extends AbstractBinding
{
    private final Object expression;
    private final Component target;
    private final Location location;

    public OgnlBinding(final @Nonnull Object expression, final @Nonnull Component target, final @Nullable Location location)
    {
        this.expression = expression;
        this.target = target;
        this.location = location;
    }

    @Override
    public Object get()
    {
        try
        {
            return Ognl.getValue(expression, Ognl.createDefaultContext(target), target);
        }
        catch (OgnlException e)
        {
            throw new TapestryException("Expresion of 'expression language binding' is not evaluatable.", location, e);
        }
    }

    @Override
    public boolean isInvariant()
    {
        return false;
    }
}
