package com.github.bednar.telb.services;

import javax.annotation.Nonnull;
import java.io.IOException;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;

@SubModule(TELBModule.class)
public class AppModule
{
    public static void bind(final @Nonnull ServiceBinder binder)
    {
    }

    public static void contributeApplicationDefaults(final @Nonnull MappedConfiguration<String, Object> configuration)
    {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.PRODUCTION_MODE, false);
    }

    public RequestFilter buildTimingFilter(final @Nonnull Logger log)
    {
        return new RequestFilter()
        {
            public boolean service(final @Nonnull Request request,
                                   final @Nonnull Response response,
                                   final @Nonnull RequestHandler handler) throws IOException
            {
                long startTime = System.currentTimeMillis();

                try
                {
                    return handler.service(request, response);
                }
                finally
                {
                    long elapsed = System.currentTimeMillis() - startTime;

                    log.info(String.format("Request time: %d ms", elapsed));
                }
            }
        };
    }

    public void contributeRequestHandler(final @Nonnull OrderedConfiguration<RequestFilter> configuration,
                                         final @Nonnull @Local RequestFilter filter)
    {
        configuration.add("Timing", filter);
    }
}
