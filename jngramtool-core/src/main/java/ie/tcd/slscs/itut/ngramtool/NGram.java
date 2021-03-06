package ie.tcd.slscs.itut.ngramtool;

/*
 * Copyright (C) 2002 by Zhang Le <ejoy@users.sourceforge.net>
 * Copyright 2016 Jim O'Regan <jaoregan@tcd.ie>
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

/**
 * This class implements Nagao 1994's N-gram extraction algorithm (with minor
 * improvements). All the characters are encoded in unicode
 * internally so we can handle oriental languages like Chinese and Japanese
 * gracefully.
 *
 */
public class NGram {
    String text;
    int count;
    private String[] tokens;
    private int arity;

    public NGram(String t, int c) {
        text = t;
        count = c;
        tokens = t.split(" ");
        arity = tokens.length;
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
    public String toString() {
        String out = "\"";
        out += getText();
        out += ',';
        out += getCount();
        out += '"';
        return out;
    }

    public int getArity() {
        return arity;
    }

    public String[] getTokens() {
        return tokens;
    }
    public String getFirst() {
        return tokens[0];
    }
    public String getLast() {
        return tokens[arity-1];
    }
    public String getToken(int idx) {
        return tokens[idx];
    }
}
