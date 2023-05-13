package com.example.projectspring.services.loggers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LoggerImplFile implements Logger{

    private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
        File log = new File("log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void info(Object toLog) {
        logInformation(toLog, LoggerLevel.INFO);
    }

    @Override
    public void debug(Object toLog) {
        logInformation(toLog, LoggerLevel.DEBUG);
    }

    @Override
    public void trace(Object toLog) {
        logInformation(toLog, LoggerLevel.TRACE);
    }

    @Override
    public void error(Object toLog) {
        logInformation(toLog, LoggerLevel.ERROR);
    }
}
