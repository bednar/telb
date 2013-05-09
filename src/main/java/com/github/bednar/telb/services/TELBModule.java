package com.github.bednar.telb.services;

import javax.annotation.Nonnull;

import com.github.bednar.telb.bindings.ELBindingFactory;
import com.github.bednar.telb.bindings.MvelBindingFactory;
import com.github.bednar.telb.bindings.OgnlBindingFactory;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.BindingFactory;
import org.apache.tapestry5.services.BindingSource;

/**
 * @author Jakub Bednář (08/05/2013 1:31 PM)
 */
public class TELBModule
{
    /**
     * @param configuration for register default expression language binding
     */
    public void contributeApplicationDefaults(final @Nonnull MappedConfiguration<String, String> configuration)
    {
        configuration.add(TELBConstants.DEFAULT_EL_SYMBOL, TELBConstants.OGNL);
    }

    /**
     * @param configuration for register expression language binding
     * @param defaultEL     default expression language prefix
     * @param bindingSource for generic 'el' prefix
     */
    public static void contributeBindingSource(final @Nonnull MappedConfiguration<String, BindingFactory> configuration,
                                               final @Nonnull @Symbol(TELBConstants.DEFAULT_EL_SYMBOL) String defaultEL,
                                               final @Nonnull BindingSource bindingSource)
    {
        configuration.add(TELBConstants.EXPRESSION_LANGUAGE, new ELBindingFactory(defaultEL, bindingSource));
        configuration.add(TELBConstants.OGNL, new OgnlBindingFactory());
        configuration.add(TELBConstants.MVEL, new MvelBindingFactory());
    }
}
