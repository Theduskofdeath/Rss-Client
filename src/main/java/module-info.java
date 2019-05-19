module rssclient
{
    requires javafx.controls;
    requires javafx.fxml;
    requires vertx.core;
    requires org.json;
    requires spring.web;
    requires gson;

    opens com.jd.rss to javafx.fxml;
    exports com.jd.rss;
}