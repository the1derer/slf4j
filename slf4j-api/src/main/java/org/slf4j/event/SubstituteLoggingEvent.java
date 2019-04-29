package org.slf4j.event;

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

// Very Poor design choices used here,as all of fields are left uninitialized and we can't use @RequireNonNull on getter methods inherited from LoggingEvent, 
// without causing precondition errors in Logging event and we should not change behaviour of SuperClass.
@SuppressWarnings("nullness") // solving https://github.com/typetools/checker-framework/issues/2216 can potentialy eliminate use of this @SuppressWarnings
public class SubstituteLoggingEvent implements LoggingEvent { 

    @MonotonicNonNull Level level;
    @Nullable Marker marker;
    @MonotonicNonNull String loggerName;
    @MonotonicNonNull SubstituteLogger logger;
    @MonotonicNonNull String threadName;
    @MonotonicNonNull String message;
    @Nullable Object @Nullable [] argArray;
    long timeStamp;
    @Nullable Throwable throwable;

    @RequiresNonNull("level")
    public Level getLevel() {
        return level;
    }

    @EnsuresNonNull("level")
    public void setLevel(Level level) {
        this.level = level;
    }

    public @Nullable Marker getMarker() {
        return marker;
    }

    public void setMarker(@Nullable Marker marker) {
        this.marker = marker;
    }

    @RequiresNonNull("loggerName")
    public String getLoggerName() {
        return loggerName;
    }

    @EnsuresNonNull("loggerName")
    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public SubstituteLogger getLogger() {
        return logger;
    }

    @EnsuresNonNull("logger")
    public void setLogger(SubstituteLogger logger) {
        this.logger = logger;
    }

    @RequiresNonNull("message")
    public String getMessage() {
        return message;
    }

    @EnsuresNonNull("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public @Nullable Object @Nullable [] getArgumentArray() {
        return argArray;
    }

    public void setArgumentArray(@Nullable Object @Nullable [] argArray) {
        this.argArray = argArray;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @RequiresNonNull("threadName")
    public String getThreadName() {
        return threadName;
    }

    @EnsuresNonNull("threadName")
    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public @Nullable Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(@Nullable Throwable throwable) {
        this.throwable = throwable;
    }
}
