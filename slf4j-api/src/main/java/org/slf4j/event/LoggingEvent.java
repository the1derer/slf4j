package org.slf4j.event;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.PolyNull;
import org.slf4j.Marker;

/**
 * 
 * @author ceki
 * @since 1.7.15
 */
public interface LoggingEvent {

    Level getLevel();

    @Nullable Marker getMarker();

    String getLoggerName();

    String getMessage();

    String getThreadName();

    @PolyNull Object @PolyNull [] getArgumentArray();

    long getTimeStamp();

    @Nullable Throwable getThrowable();

}
