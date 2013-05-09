package com.github.bednar.telb.bindings;

import java.util.concurrent.ConcurrentHashMap;

import ognl.Ognl;
import ognl.OgnlException;
import org.apache.tapestry5.Binding;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ioc.Location;
import org.apache.tapestry5.ioc.internal.util.TapestryException;
import org.apache.tapestry5.runtime.Component;
import org.apache.tapestry5.services.BindingFactory;

/**
 * @author Jakub Bednář (09/05/2013 1:45 PM)
 */
public class OgnlBindingFactory implements BindingFactory
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
            try
            {
                parsed = Ognl.parseExpression(expression);

                parsedExpression.putIfAbsent(expression, parsed);
            }
            catch (OgnlException e)
            {
                throw new TapestryException("Expresion of 'expression language binding' is not parsable.", location, e);
            }
        }

        Component target = container.getComponent();

        return new OgnlBinding(parsed, target, location);
    }
}
