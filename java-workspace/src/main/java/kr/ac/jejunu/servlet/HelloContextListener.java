package kr.ac.jejunu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by SeungChan on 2017-05-19.
 */
@WebListener
public class HelloContextListener implements ServletContextListener{

    private static Logger logger = LoggerFactory.getLogger(HelloContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("***************  context init *************");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("***************  context destroy *************");
    }
}