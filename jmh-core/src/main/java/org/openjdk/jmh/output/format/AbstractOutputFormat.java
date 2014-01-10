/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.openjdk.jmh.output.format;

import org.openjdk.jmh.runner.options.VerboseMode;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractOutputFormat implements OutputFormat {

    /** Verbose-mode? */
    final VerboseMode verbose;
    /** PrintStream to use */
    final PrintStream out;

    public AbstractOutputFormat(PrintStream out, VerboseMode verbose) {
        this.out = out;
        this.verbose = verbose;
    }

    @Override
    public void println(String s) {
        out.println(s);
    }

    @Override
    public void flush() {
        out.flush();
    }

    @Override
    public void verbosePrintln(String s) {
        if (verbose == VerboseMode.Extra) {
            out.println(s);
        }
    }

    @Override
    public void write(int b) {
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        out.write(b);
    }

    @Override
    public void close() {
        // do nothing
    }

    @Override
    public void exception(Throwable ex) {
        Logger.getAnonymousLogger().log(Level.SEVERE, ex.getMessage(), ex);
    }

}
