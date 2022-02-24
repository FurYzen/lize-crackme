package eu.timebreaker.lize.crackme.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Logger {

    private String program;
    private boolean debugMode;

    public Logger(String program, boolean debugMode){
        this.program = program;
        this.debugMode = debugMode;
    }
    public Logger(String program){
        this(program, false);
    }

    public void log(LogType type, String message) {
        switch (type) {
            case INFORMATION:
                System.out.printf("[Logger/%s] [%s] %s%n", program, type.name(), message);
                break;
            case DEBUG:
                if(debugMode) System.out.printf("[Logger/%s] [%s] %s%n", program, type.name(), message);
                break;
            case ALERT:
                System.out.printf("\u001B[33m[Logger/%s] [%s] %s\u001B[0m%n", program, type.name(), message);
                break;
            case ERROR:
                System.err.printf("[Logger/%s] [%s] %s%n", program, type.name(), message);
                break;
        }
    }

    public void log(LogType type, String message, Object... args) {
        log(type, String.format(message, args));
    }

    public Logger setProgram(String program) {
        return new Logger(program, debugMode);
    }

    public enum LogType {
        INFORMATION, ALERT, ERROR, DEBUG
    }
}
