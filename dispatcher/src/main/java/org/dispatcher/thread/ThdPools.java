package org.dispatcher.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.dispatcher.loader.Loader;

public class ThdPools
{
    private static ThdPools inst;
    private static ThreadGroup thdgrp = new ThreadGroup("Dispatcher thread");
    private static AtomicInteger counts = new AtomicInteger(1);

    private static Map<String, Object> loadMap = new HashMap<String, Object>()
            {
        {
            put("atp", 1);
            put("tpc", 2);
        }
            };

            static
            {
                synchronized (counts)
                {
                    inst = new ThdPools();
                }
            }

    static
            {

    }

            private ThdPools()
            {
            }

            public static ThdPools getInsance()
            {
                return inst;
            }

            public Thread initLoader()
            {
                Loader loader = (Loader) loadMap.get("");

                return getLoader(loader);
            }

            //只运行一个线程
            public Thread getLoader(Loader loader)
            {
                if (counts.get() <= 1)
                {
                    counts.getAndIncrement();
                    return new Thread(thdgrp, loader, "loader");
                }
                else
                {
                    return null;
                }
            }

}
