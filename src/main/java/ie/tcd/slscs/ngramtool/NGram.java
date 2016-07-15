package ie.tcd.slscs.ngramtool;

/*
 * ngramstat.hpp  -  Implements Nagao 1994 N-gram extraction algorithm (unicode
 * version)
 *
 * This class implements Nagao 1994's N-gram extraction algorithm (with minor
 * improvements). All the Characters are encoded in unicode (uchar_t)
 * internally so we can handle oriental languages like Chinese and Japanese
 * gracefully.
 *
 * Copyright (C) 2002 by Zhang Le <ejoy@users.sourceforge.net>
 * Begin       : 30-Oct-2002
 * Last Change : 22-Apr-2004.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
public class NGram {
    String text;
    int count;

    public NGram(String t, int c) {
        text = t;
        count = c;
    }
    public int getCount() {
        return count;
    }
    public String getText() {
        return text;
    }
    public void setCount(int c) {
        count = c;
    }
}