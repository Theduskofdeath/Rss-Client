module rss.client2.main
{
    requires javafx.controls;
    requires javafx.fxml;
    requires vertx.core;
    requires org.json;
    requires spring.web;
    requires gson;
    requires java.prefs;
    requires java.sql;

    opens com.jd.rss to javafx.fxml;
    opens com.jd.rss.controllers to javafx.fxml;
    opens com.jd.rss.module.user to gson;
    exports com.jd.rss;
}