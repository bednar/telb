package com.github.bednar.telb.bindings;

import javax.annotation.Nonnull;

import org.apache.tapestry5.internal.bindings.AbstractBinding;
import org.apache.tapestry5.runtime.Component;
import org.mvel2.MVEL;

/**
 * @author Jakub Bednář (09/05/2013 2:14 PM)
 */
public class MvelBinding extends AbstractBinding
{
    private final Object expression;
    private final Component target;

    public MvelBinding(final @Nonnull Object expression, final @Nonnull Component target)
    {
        this.expression = expression;
        this.target = target;
    }

    @Override
    public Object get()
    {
        return MVEL.executeExpression(expression, target);
    }

    @Override
    public boolean isInvariant()
    {
        return false;
    }
}
