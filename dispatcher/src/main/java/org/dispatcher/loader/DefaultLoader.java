package org.dispatcher.loader;

import java.util.ArrayList;
import java.util.List;

public class DefaultLoader extends Loader
{

    @Override
    List<Object> loader()
    {
        List<Object> tasks = new ArrayList<Object>();

        return tasks;
    }

    @Override
    void markAsRunning(List<Object> obj)
    {
        // TODO Auto-generated method stub

    }

    @Override
    void revertAsToRun(List<Object> obj)
    {
        // TODO Auto-generated method stub

    }

}
