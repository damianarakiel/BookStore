package com.sda.hibernate.web;

import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = create();
        tomcat.start();
        tomcat.getServer().await();
    }

    private static Tomcat create() throws Exception {
        return EmbeddedTomcatFactory.create(8082);
    }
}
