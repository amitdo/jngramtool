package ie.tcd.slscs.itut.bundles;

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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.tcd.slscs.itut.bundles.Utils;
import ie.tcd.slscs.itut.bundles.SketchEngineFile;

/**
 * Simple container for the collection of files in a Sketch Engine exported corpus.
 * @author jaoregan
 *
 */
public class SketchEngineCorpus {
    List<SketchEngineFile> files;

    SketchEngineCorpus() {
        files = new ArrayList<SketchEngineFile>();
    }
    public void add(SketchEngineFile f) {
        files.add(f);
    }
    public Map<String, String> getIDtoFilenameMap() {
        HashMap<String, String> out = new HashMap<String, String>();
        for (SketchEngineFile file : files) {
            out.put(file.getId(), file.getFilename());
        }
        return out;
    }
}
