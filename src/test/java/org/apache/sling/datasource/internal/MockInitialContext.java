package org.apache.sling.datasource.internal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MockInitialContext extends InitialContext {

    public Map<String, Object> map = new HashMap<String, Object>();

    public MockInitialContext() throws NamingException {
        super();
    }

    @Override
    public Object lookup(String name) throws NamingException {
        if (name == null) {
            return null;
        }

        return map.get(name);
    }
}
