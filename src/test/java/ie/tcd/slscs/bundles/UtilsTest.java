package ie.tcd.slscs.bundles;

/*
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
import ie.tcd.slscs.ngramtool.NGram;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UtilsTest {
    @Test
    public void joinTest() throws Exception {
        List<String> inp = new ArrayList<String>();
        inp.add("this");
        inp.add("is");
        inp.add("a");
        inp.add("test");

        String exp = "this is a test";
        String out = Utils.join(inp, " ");
        assertEquals(exp, out);
    }

    @Test
    public void testTrim() throws Exception {
        String inp = "    test   ";
        String exp = "test";
        String out = Utils.trim(inp);
        assertEquals(exp, out);
        String inp1 = "    test";
        String exp1 = "test";
        String out1 = Utils.trim(inp1);
        assertEquals(exp1, out1);
    }

    @Test
    public void testGetSubSentences() throws Exception {
        List<String> inp = new ArrayList<String>();
        inp.add("one sentence, which has (among others); a few n-grams");
        inp.add("and another; this also has a few");
        List<String> exp = new ArrayList<String>();
        exp.add("one sentence");
        exp.add("which has");
        exp.add("among others");
        exp.add("a few n-grams");
        exp.add("and another");
        exp.add("this also has a few");
        List<String> out = Utils.getSubSentences(inp, ",;()");
        assertEquals(exp.toString(), out.toString());
    }

    @Test
    public void testAddOrIncrement() throws Exception {
        Map<String, Integer> inp = new HashMap<String, Integer>();
        Map<String, Integer> exp = new HashMap<String, Integer>();
        inp.put("test", 2);
        Utils.addOrIncrement(inp, "test");
        Utils.addOrIncrement(inp, "new");
        exp.put("test", 3);
        exp.put("new", 1);
        assertEquals(inp, exp);
    }
}
