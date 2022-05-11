package org.apache.sling.datasource.internal;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import java.util.Hashtable;

public class MockInitialContextFactory implements InitialContextFactory {

    private static final ThreadLocal<Context> currentContext = new ThreadLocal<>();

    @Override
    public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
        return currentContext.get();
    }

    public static void setCurrentContext(Context context) {
        currentContext.set(context);
    }

    public static void clearCurrentContext() {
        currentContext.remove();
    }
}
