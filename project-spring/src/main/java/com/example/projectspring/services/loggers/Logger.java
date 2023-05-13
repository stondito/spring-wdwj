package com.example.projectspring.services.loggers;

public interface Logger {

    void info(Object toLog);

    void debug(Object toLog);

    void trace(Object toLog);

    void error(Object toLog);
}
