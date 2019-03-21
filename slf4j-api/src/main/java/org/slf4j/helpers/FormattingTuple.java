/**
 * Copyright (c) 2004-2011 QOS.ch
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.slf4j.helpers;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Holds the results of formatting done by {@link MessageFormatter}.
 * 
 * @author Joern Huxhorn
 */
public class FormattingTuple {

    static public FormattingTuple NULL = new FormattingTuple(null);

    private @Nullable String message;
    private @Nullable Throwable throwable;
    private @Nullable Object @Nullable [] argArray;

    public FormattingTuple(@Nullable String message) {
        this(message, null, null);
    }

    public FormattingTuple(@Nullable String message,@Nullable Object @Nullable [] argArray,@Nullable Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
        this.argArray = argArray;
    }

    public @Nullable String getMessage() {
        return message;
    }

    public @Nullable Object @Nullable [] getArgArray() {
        return argArray;
    }

    public @Nullable Throwable getThrowable() {
        return throwable;
    }

}
