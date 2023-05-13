package com.example.projectspring.services.loggers;


import java.time.LocalDate;

public class LoggerImplStd implements Logger{
    @Override
    public void info(Object toLog) {

        System.out.println(
                LocalDate.now()
                + " "
                + LoggerLevel.INFO.getLabel()
                + " "
                + toLog
        );
    }

    @Override
    public void debug(Object toLog) {
        System.out.println(
                LocalDate.now()
                + " "
                + LoggerLevel.DEBUG.getLabel()
                + " "
                + LoggerLevel.DEBUG.getCode()
                + " "
                + toLog
        );
    }

    @Override
    public void trace(Object toLog) {
        System.out.println(
                LocalDate.now()
                + " "
                + LoggerLevel.TRACE.getLabel()
                + " "
                + LoggerLevel.TRACE.getCode()
                + " "
                + toLog
        );
    }

    @Override
    public void error(Object toLog) {
        System.out.println(
                LocalDate.now()
                + " "
                + LoggerLevel.ERROR.getLabel()
                + LoggerLevel.ERROR.getCode()
                + " "
                + toLog
        );
    }
}
