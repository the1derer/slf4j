package org.slf4j.jul;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.framework.qual.EnsuresQualifier;
import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.helpers.BasicMDCAdapter;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

@SuppressWarnings("nullness") // Suppressing "Precondition must be no stronger than in superclass"
public class JULServiceProvider implements SLF4JServiceProvider {

	/**
	 * Declare the version of the SLF4J API this implementation is compiled
	 * against. The value of this field is modified with each major release.
	 */
	// to avoid constant folding by the compiler, this field must *not* be final
	public static String REQUESTED_API_VERSION = "1.8.99"; // !final

	private @MonotonicNonNull ILoggerFactory loggerFactory;
	private @MonotonicNonNull IMarkerFactory markerFactory;
	private @MonotonicNonNull MDCAdapter mdcAdapter;

	@RequiresNonNull("loggerFactory")
	public ILoggerFactory getLoggerFactory() {
		return loggerFactory;
	}

	@RequiresNonNull("markerFactory")
	public IMarkerFactory getMarkerFactory() {
		return markerFactory;
	}

	@RequiresNonNull("mdcAdapter")
	public MDCAdapter getMDCAdapter() {
		return mdcAdapter;
	}

	public String getRequesteApiVersion() {
		return REQUESTED_API_VERSION;
	}

    @EnsuresQualifier(expression = "loggerFactory", qualifier = NonNull.class)
    @EnsuresQualifier(expression = "markerFactory", qualifier = NonNull.class)
    @EnsuresQualifier(expression = "mdcAdapter", qualifier = NonNull.class)
	public void initialize() {
		loggerFactory = new JDK14LoggerFactory();
		markerFactory = new BasicMarkerFactory();
		mdcAdapter = new BasicMDCAdapter();
	}
}
