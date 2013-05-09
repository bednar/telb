package com.github.bednar.telb.bindings;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.tapestry5.Binding;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ioc.Location;
import org.apache.tapestry5.ioc.internal.util.TapestryException;
import org.apache.tapestry5.runtime.Component;
import org.apache.tapestry5.services.BindingFactory;
import org.mvel2.MVEL;

/**
 * @author Jakub Bednář (09/05/2013 2:07 PM)
 */
public class MvelBindingFactory implements BindingFactory
{
    private final ConcurrentHashMap<String, Object> parsedExpression = new ConcurrentHashMap<String, Object>();

    @Override
    public Binding newBinding(final String description,
                              final ComponentResources container,
                              final ComponentResources component,
                              final String expression,
                              final Location location)
    {
        if (expression == null || expression.isEmpty())
        {
            throw new TapestryException("Expresion of 'expression language binding' cannot be empty.", location, null);
        }

        Object parsed;
        if (parsedExpression.containsKey(expression))
        {
            parsed = parsedExpression.get(expression);
        }
        else
        {
            parsed = MVEL.compileExpression(expression);

            parsedExpression.putIfAbsent(expression, parsed);
        }

        Component target = container.getComponent();

        return new MvelBinding(parsed, target);
    }
}
