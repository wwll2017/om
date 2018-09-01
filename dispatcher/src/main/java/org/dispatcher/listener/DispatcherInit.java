package org.dispatcher.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.dispatcher.thread.ThdPools;

public class DispatcherInit implements ServletContextListener
{
    private final Logger LOG = Logger.getLogger(this.getClass());
    private static Thread loader = null;

    public void contextDestroyed(ServletContextEvent arg0)
    {
        LOG.error("DispatcherInit contextDestroyed.");

        if (loader != null)
        {
            loader.stop();
        }

    }

    public void contextInitialized(ServletContextEvent arg0)
    {
        LOG.error("DispatcherInit contextInitialized.");

        loader = ThdPools.getInsance().initLoader();

        if (loader != null)
        {
            loader.start();
        }
    }

}
