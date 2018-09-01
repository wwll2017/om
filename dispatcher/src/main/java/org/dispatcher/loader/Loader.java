package org.dispatcher.loader;

import java.util.List;

import org.apache.log4j.Logger;
import org.dispatcher.dispatchers.Dispatcher;

public abstract class Loader implements Runnable
{
    private final Logger LOG = Logger.getLogger(this.getClass());

    private Dispatcher dispacth;

    abstract List<Object> loader();

    abstract void markAsRunning(List<Object> obj);

    abstract void revertAsToRun(List<Object> obj);

    public void run()
    {
        LOG.debug("Loader init.");

        while (true)
        {
            LOG.debug("Loader running start.");

            try
            {
                Thread.sleep(60 * 1000L);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }

            List<Object> obj = loader();

            markAsRunning(obj);

            int retCode = dispacth.dispatch(obj);

            if (retCode == 1)
            {
                revertAsToRun(obj);
            }

            LOG.debug("Loader running end.");
        }

    }
}
