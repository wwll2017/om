package org.dispatcher.loader;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DefaultLoader extends Loader
{
    private final Logger LOG = Logger.getLogger(this.getClass());

    @Override
    List<Object> loader()
    {
        LOG.debug("DefaultLoader loader");
        List<Object> tasks = new ArrayList<Object>();

        return tasks;
    }

    @Override
    void markAsRunning(List<Object> obj)
    {
        LOG.debug("DefaultLoader markAsRunning");

    }

    @Override
    void revertAsToRun(List<Object> obj)
    {
        LOG.debug("DefaultLoader revertAsToRun");

    }

}
