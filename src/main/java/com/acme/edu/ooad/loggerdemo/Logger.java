package com.acme.edu.ooad.loggerdemo;

public class Logger {
    private LoggerSaver saver = new ConsoleSaver();

    public void log(LoggerMessage message) {
        if (!message.filter()) { //Impl: content, severity, ...
            saver.save(message); //Impl: console, file, ...
        }
    }
}
