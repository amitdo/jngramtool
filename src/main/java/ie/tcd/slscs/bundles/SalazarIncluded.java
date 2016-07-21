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
import ie.tcd.slscs.kfclone.StringUtils;
import ie.tcd.slscs.ngramtool.NGram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This classifier checks if an n-gram is present in the list of
 * included items from Salazar 2011, Appendix 3.
 * This classifier is extended to normalise digits; for the unmodified
 * implementation, see #SalazarIncludedOriginal
 *
 * <pre>
 * @phdthesis{salazar2011lexical,
 * title={Lexical bundles in scientific English: A corpus-based study of native and non-native writing},
 * author={Salazar, Danica Joy Lorenzo},
 * year={2011},
 * school={Universitat de Barcelona}
 * }
 * </pre>
 */
public class SalazarIncluded implements Classifier {
    private List<String> ngrams;
    public SalazarIncluded() {
        ngrams = new ArrayList<String>();
        initNGrams();
    }
    void initNGrams() {
        ngrams.add("the presence of");
        ngrams.add("data not shown");
        ngrams.add("in the presence of");
        ngrams.add("the absence of");
        ngrams.add("in the absence of");
        ngrams.add("as well as");
        ngrams.add("the number of");
        ngrams.add("the effect of");
        ngrams.add("as described previously");
        ngrams.add("the ability of");
        ngrams.add("as described in");
        ngrams.add("shown in figure");
        ngrams.add("been shown to");
        ngrams.add("the addition of");
        ngrams.add("is required for");
        ngrams.add("was used to");
        ngrams.add("in response to");
        ngrams.add("a number of");
        ngrams.add("results not shown");
        ngrams.add("the effects of");
        ngrams.add("the level of");
        ngrams.add("it is possible");
        ngrams.add("to determine whether");
        ngrams.add("the role of");
        ngrams.add("the fact that");
        ngrams.add("has been shown");
        ngrams.add("is consistent with");
        ngrams.add("in addition to");
        ngrams.add("the amount of");
        ngrams.add("the formation of");
        ngrams.add("in this study");
        ngrams.add("it is possible that");
        ngrams.add("at room temperature");
        ngrams.add("the activity of");
        ngrams.add("was added to");
        ngrams.add("the possibility that");
        ngrams.add("the rate of");
        ngrams.add("the basis of");
        ngrams.add("for review see");
        ngrams.add("were incubated with");
        ngrams.add("we found that");
        ngrams.add("on the basis of");
        ngrams.add("in order to");
        ngrams.add("have shown that");
        ngrams.add("the present study");
        ngrams.add("was determined by");
        ngrams.add("shown to be");
        ngrams.add("were carried out");
        ngrams.add("in the same");
        ngrams.add("as shown in");
        ngrams.add("an increase in");
        ngrams.add("are shown in");
        ngrams.add("the use of");
        ngrams.add("in the present");
        ngrams.add("a variety of");
        ngrams.add("the identity of");
        ngrams.add("the bottom of");
        ngrams.add("the product of");
        ngrams.add("were washed twice with");
        ngrams.add("for their ability to");
        ngrams.add("data not shown in");
        ngrams.add("little is known");
        ngrams.add("essentially as described");
        ngrams.add("may contribute to");
        ngrams.add("has been observed");
        ngrams.add("was assessed by");
        ngrams.add("was replaced with");
        ngrams.add("is mediated by");
        ngrams.add("were prepared as");
        ngrams.add("in this experiment");
        ngrams.add("for up to");
        ngrams.add("were fixed in");
        ngrams.add("is known to");
        ngrams.add("in this region");
        ngrams.add("the tip of");
        ngrams.add("is found in");
        ngrams.add("to the left");
        ngrams.add("the analysis of");
        ngrams.add("at room temperature for");
        ngrams.add("to be required for");
        ngrams.add("carried out as");
        ngrams.add("carried out with");
        ngrams.add("can be seen");
        ngrams.add("as judged by");
        ngrams.add("have been found");
        ngrams.add("is supported by");
        ngrams.add("only a small");
        ngrams.add("large number of");
        ngrams.add("be able to");
        ngrams.add("is not known");
        ngrams.add("were identified by");
        ngrams.add("was performed with");
        ngrams.add("was required for");
        ngrams.add("a portion of");
        ngrams.add("the course of");
        ngrams.add("the same as");
        ngrams.add("a loss of");
        ngrams.add("the time of");
        ngrams.add("little is known about");
        ngrams.add("would be expected to");
        ngrams.add("these data indicate that");
        ngrams.add("carried out using");
        ngrams.add("with the exception of");
        ngrams.add("could be detected");
        ngrams.add("activity was measured");
        ngrams.add("in conjunction with");
        ngrams.add("were transferred to");
        ngrams.add("are known to");
        ngrams.add("were detected by");
        ngrams.add("in contrast with");
        ngrams.add("the majority of");
        ngrams.add("were used to");
        ngrams.add("see materials and methods");
        ngrams.add("no effect on");
        ngrams.add("in contrast to");
        ngrams.add("has been shown to");
        ngrams.add("as described above");
        ngrams.add("similar to that");
        ngrams.add("a role in");
        ngrams.add("likely to be");
        ngrams.add("the results of");
        ngrams.add("was carried out");
        ngrams.add("the production of");
        ngrams.add("we show that");
        ngrams.add("are consistent with");
        ngrams.add("is shown in");
        ngrams.add("the loss of");
        ngrams.add("this suggests that");
        ngrams.add("a role for");
        ngrams.add("results suggest that");
        ngrams.add("in the case of");
        ngrams.add("were treated with");
        ngrams.add("the function of");
        ngrams.add("the localization of");
        ngrams.add("were obtained from");
        ngrams.add("in figure #");
        ngrams.add("the position of");
        ngrams.add("the levels of");
        ngrams.add("a series of");
        ngrams.add("in the present study");
        ngrams.add("by the addition of");
        ngrams.add("are required for");
        ngrams.add("found to be");
        ngrams.add("the ability to");
        ngrams.add("was found to");
        ngrams.add("by use of");
        ngrams.add("was used as");
        ngrams.add("the accumulation of");
        ngrams.add("had no effect");
        ngrams.add("appear to be");
        ngrams.add("it is likely");
        ngrams.add("appears to be");
        ngrams.add("the observation that");
        ngrams.add("a total of");
        ngrams.add("the structure of");
        ngrams.add("as described by");
        ngrams.add("have been identified");
        ngrams.add("these results suggest");
        ngrams.add("were determined by");
        ngrams.add("by addition of");
        ngrams.add("the requirement for");
        ngrams.add("the result of");
        ngrams.add("with respect to");
        ngrams.add("were grown in");
        ngrams.add("the control of");
        ngrams.add("have been shown to");
        ngrams.add("is essential for");
        ngrams.add("the percentage of");
        ngrams.add("as shown in figure");
        ngrams.add("we conclude that");
        ngrams.add("were incubated for");
        ngrams.add("the distribution of");
        ngrams.add("of the total");
        ngrams.add("had no effect on");
        ngrams.add("their ability to");
        ngrams.add("is likely to");
        ngrams.add("the positions of");
        ngrams.add("the surface of");
        ngrams.add("these results suggest that");
        ngrams.add("we have shown");
        ngrams.add("in table #");
        ngrams.add("in a similar");
        ngrams.add("it should be noted that");
        ngrams.add("performed as described previously");
        ngrams.add("it is not clear");
        ngrams.add("is not required for");
        ngrams.add("has been implicated");
        ngrams.add("are shown in figure");
        ngrams.add("together these results");
        ngrams.add("in some cases");
        ngrams.add("was purchased from");
        ngrams.add("with the use of");
        ngrams.add("is an important");
        ngrams.add("by the presence of");
        ngrams.add("to be determined");
        ngrams.add("a set of");
        ngrams.add("was present in");
        ngrams.add("in support of");
        ngrams.add("a fraction of");
        ngrams.add("expressed as a percentage of");
        ngrams.add("results are consistent with");
        ngrams.add("this is consistent with");
        ngrams.add("significantly different from");
        ngrams.add("extracts were prepared");
        ngrams.add("carried out in");
        ngrams.add("we have identified");
        ngrams.add("see table #");
        ngrams.add("can be used");
        ngrams.add("used to determine");
        ngrams.add("small number of");
        ngrams.add("in this report");
        ngrams.add("was prepared from");
        ngrams.add("the notion that");
        ngrams.add("was subjected to");
        ngrams.add("an average of");
        ngrams.add("are associated with");
        ngrams.add("are representative of");
        ngrams.add("was prepared by");
        ngrams.add("in the dark");
        ngrams.add("was found in");
        ngrams.add("the range of");
        ngrams.add("the products of");
        ngrams.add("are likely to be");
        ngrams.add("a large number of");
        ngrams.add("previous studies have");
        ngrams.add("does not contain");
        ngrams.add("results demonstrate that");
        ngrams.add("was supported by");
        ngrams.add("is based on");
        ngrams.add("the indicated times");
        ngrams.add("in a number of");
        ngrams.add("is unlikely to");
        ngrams.add("as measured by");
        ngrams.add("not due to");
        ngrams.add("by treatment with");
        ngrams.add("to demonstrate that");
        ngrams.add("also observed in");
        ngrams.add("the conclusion that");
        ngrams.add("on the surface");
        ngrams.add("was performed in");
        ngrams.add("were detected in");
        ngrams.add("a change in");
        ngrams.add("in fig #");
        ngrams.add("the efficiency of");
        ngrams.add("the behavior of");
        ngrams.add("the isolation of");
        ngrams.add("the detection of");
        ngrams.add("in the top");
        ngrams.add("here we show that");
        ngrams.add("an important role in");
        ngrams.add("not appear to be");
        ngrams.add("we were unable to");
        ngrams.add("the sequence of");
        ngrams.add("performed as described");
        ngrams.add("the hypothesis that");
        ngrams.add("in figure #");
        ngrams.add("a function of");
        ngrams.add("it is likely that");
        ngrams.add("a result of");
        ngrams.add("the end of");
        ngrams.add("as previously described");
        ngrams.add("the method of");
        ngrams.add("the interaction of");
        ngrams.add("the development of");
        ngrams.add("not appear to");
        ngrams.add("was obtained from");
        ngrams.add("be involved in");
        ngrams.add("in this case");
        ngrams.add("as a result");
        ngrams.add("is associated with");
        ngrams.add("the existence of");
        ngrams.add("at the same");
        ngrams.add("the nature of");
        ngrams.add("the size of");
        ngrams.add("in the absence or presence of");
        ngrams.add("data suggest that");
        ngrams.add("its ability to");
        ngrams.add("similar to those");
        ngrams.add("is present in");
        ngrams.add("the lack of");
        ngrams.add("has been proposed");
        ngrams.add("the extent of");
        ngrams.add("were subjected to");
        ngrams.add("consistent with this");
        ngrams.add("to interact with");
        ngrams.add("high levels of");
        ngrams.add("in combination with");
        ngrams.add("is involved in");
        ngrams.add("was used for");
        ngrams.add("were purchased from");
        ngrams.add("were separated by");
        ngrams.add("the location of");
        ngrams.add("is dependent on");
        ngrams.add("results were obtained");
        ngrams.add("in the regulation of");
        ngrams.add("are likely to");
        ngrams.add("a consequence of");
        ngrams.add("has been reported");
        ngrams.add("to determine if");
        ngrams.add("results indicate that");
        ngrams.add("was confirmed by");
        ngrams.add("was performed on");
        ngrams.add("be due to");
        ngrams.add("as determined by");
        ngrams.add("are involved in");
        ngrams.add("were found to");
        ngrams.add("on the other hand");
        ngrams.add("were unable to");
        ngrams.add("be required for");
        ngrams.add("to test this");
        ngrams.add("the identification of");
        ngrams.add("was shown to");
        ngrams.add("as a function of");
        ngrams.add("have been described");
        ngrams.add("similar to that of");
        ngrams.add("a defect in");
        ngrams.add("taken together these");
        ngrams.add("is thought to");
        ngrams.add("the interaction between");
        ngrams.add("in these experiments");
        ngrams.add("were used in");
        ngrams.add("these data suggest");
        ngrams.add("referred to as");
        ngrams.add("it is important to");
        ngrams.add("for reviews see");
        ngrams.add("as a consequence of");
        ngrams.add("carried out at");
        ngrams.add("summarized in table");
        ngrams.add("it is clear");
        ngrams.add("we have found");
        ngrams.add("unlikely to be");
        ngrams.add("been proposed to");
        ngrams.add("important role in");
        ngrams.add("we have used");
        ngrams.add("the same time");
        ngrams.add("were exposed to");
        ngrams.add("was analyzed by");
        ngrams.add("model in which");
        ngrams.add("been observed in");
        ngrams.add("in comparison with");
        ngrams.add("are similar to");
        ngrams.add("are indicated in");
        ngrams.add("a combination of");
        ngrams.add("as shown by");
        ngrams.add("in the bottom");
        ngrams.add("the interaction with");
        ngrams.add("the release of");
        ngrams.add("the introduction of");
        ngrams.add("in the control");
        ngrams.add("in the region");
        ngrams.add("it has been suggested");
        ngrams.add("at a density of");
        ngrams.add("increasing amounts of");
        ngrams.add("together these data");
        ngrams.add("high degree of");
        ngrams.add("as opposed to");
        ngrams.add("it appears that");
        ngrams.add("activity was determined");
        ngrams.add("be important for");
        ngrams.add("to account for");
        ngrams.add("were removed by");
        ngrams.add("the results presented");
        ngrams.add("the difference between");
        ngrams.add("is composed of");
        ngrams.add("a requirement for");
        ngrams.add("was associated with");
        ngrams.add("was due to");
        ngrams.add("the results obtained");
        ngrams.add("were obtained with");
        ngrams.add("are found in");
        ngrams.add("at the time");
        ngrams.add("the intensity of");
        ngrams.add("were present in");
        ngrams.add("a family of");
        ngrams.add("the value of");
        ngrams.add("the study of");
        ngrams.add("several lines of evidence");
        ngrams.add("remains to be determined");
        ngrams.add("a wide range of");
        ngrams.add("were prepared as described");
        ngrams.add("to be involved in");
        ngrams.add("medium supplemented with");
        ngrams.add("shown in figure #");
        ngrams.add("has been demonstrated");
        ngrams.add("by the fact that");
        ngrams.add("it is unlikely");
        ngrams.add("a previous study");
        ngrams.add("be the result of");
        ngrams.add("been proposed that");
        ngrams.add("for the production of");
        ngrams.add("to associate with");
        ngrams.add("also required for");
        ngrams.add("predicted to be");
        ngrams.add("to act as");
        ngrams.add("be expected to");
        ngrams.add("were able to");
        ngrams.add("a range of");
        ngrams.add("the ratio of");
        ngrams.add("the increase in");
        ngrams.add("to the same");
        ngrams.add("the site of");
        ngrams.add("in the materials and methods section");
        ngrams.add("play a role");
        ngrams.add("been implicated in");
        ngrams.add("low levels of");
        ngrams.add("was measured by");
        ngrams.add("was performed as");
        ngrams.add("is indicated by");
        ngrams.add("as a control");
        ngrams.add("was detected in");
        ngrams.add("the degree of");
        ngrams.add("in figure #");
        ngrams.add("the action of");
        ngrams.add("the length of");
        ngrams.add("in the presence or absence of");
        ngrams.add("as a result of");
        ngrams.add("has been described");
        ngrams.add("were isolated from");
        ngrams.add("are indicated by");
        ngrams.add("a subset of");
        ngrams.add("shown in table");
        ngrams.add("the mechanism of");
        ngrams.add("did not affect");
        ngrams.add("has been suggested");
        ngrams.add("under the control of");
        ngrams.add("thought to be");
        ngrams.add("was performed using");
        ngrams.add("similar results were");
        ngrams.add("were grown at");
        ngrams.add("for the presence of");
        ngrams.add("were generated by");
        ngrams.add("were performed as");
        ngrams.add("were tested for");
        ngrams.add("in figure #");
        ngrams.add("the difference in");
        ngrams.add("the region of");
        ngrams.add("play a role in");
        ngrams.add("used in this study");
        ngrams.add("we have shown that");
        ngrams.add("does not require");
        ngrams.add("was found to be");
        ngrams.add("results show that");
        ngrams.add("are expressed as");
        ngrams.add("to confirm that");
        ngrams.add("was isolated from");
        ngrams.add("were analyzed by");
        ngrams.add("were added to");
        ngrams.add("are present in");
        ngrams.add("were used for");
        ngrams.add("is similar to");
        ngrams.add("these data suggest that");
        ngrams.add("would be expected");
        ngrams.add("we propose that");
        ngrams.add("we find that");
        ngrams.add("experiments were performed");
        ngrams.add("remains to be");
        ngrams.add("were analysed by");
        ngrams.add("the relationship between");
        ngrams.add("was detected by");
        ngrams.add("a decrease in");
        ngrams.add("were performed in");
        ngrams.add("the frequency of");
        ngrams.add("prepared as described");
        ngrams.add("mechanism by which");
        ngrams.add("we suggest that");
        ngrams.add("was not detected");
        ngrams.add("of a number of");
        ngrams.add("to note that");
        ngrams.add("also present in");
        ngrams.add("was performed by");
        ngrams.add("be required to");
        ngrams.add("been used to");
        ngrams.add("are shown as");
        ngrams.add("the remainder of");
        ngrams.add("in this model");
        ngrams.add("the organization of");
        ngrams.add("this region of");
        ngrams.add("a deletion of");
        ngrams.add("the reduction in");
        ngrams.add("of a large");
        ngrams.add("taken together these results");
        ngrams.add("closely related to");
        ngrams.add("been shown previously");
        ngrams.add("been identified as");
        ngrams.add("its interaction with");
        ngrams.add("have demonstrated that");
        ngrams.add("were separated on");
        ngrams.add("this work was");
        ngrams.add("to ensure that");
        ngrams.add("were collected from");
        ngrams.add("this indicates that");
        ngrams.add("other members of");
        ngrams.add("two types of");
        ngrams.add("are unable to");
        ngrams.add("is difficult to");
        ngrams.add("is caused by");
        ngrams.add("is localized to");
        ngrams.add("in this process");
        ngrams.add("were washed with");
        ngrams.add("the inability of");
        ngrams.add("the yield of");
        ngrams.add("the combination of");
        ngrams.add("the top of");
        ngrams.add("according to the manufacturer's instructions");
        ngrams.add("it has been proposed that");
        ngrams.add("carried out as described");
        ngrams.add("were washed three times");
        ngrams.add("an equal volume of");
        ngrams.add("has been implicated in");
        ngrams.add("under the same conditions");
        ngrams.add("we asked whether");
        ngrams.add("is thought to be");
        ngrams.add("an equal volume");
        ngrams.add("at the same time");
        ngrams.add("as well as in");
        ngrams.add("did not appear");
        ngrams.add("is a member of");
        ngrams.add("equal volume of");
        ngrams.add("be explained by");
        ngrams.add("may be due");
        ngrams.add("there are several");
        ngrams.add("consistent with previous");
        ngrams.add("used to amplify");
        ngrams.add("on the surface of");
        ngrams.add("has been used");
        ngrams.add("used to identify");
        ngrams.add("at the level of");
        ngrams.add("be responsible for");
        ngrams.add("no evidence for");
        ngrams.add("have suggested that");
        ngrams.add("very similar to");
        ngrams.add("by virtue of");
        ngrams.add("to address this");
        ngrams.add("total number of");
        ngrams.add("are essential for");
        ngrams.add("have found that");
        ngrams.add("were stained with");
        ngrams.add("known to be");
        ngrams.add("is sufficient to");
        ngrams.add("the onset of");
        ngrams.add("the importance of");
        ngrams.add("data indicate that");
        ngrams.add("a gift from");
        ngrams.add("were prepared from");
        ngrams.add("not required for");
        ngrams.add("is able to");
        ngrams.add("were used as");
        ngrams.add("a percentage of");
        ngrams.add("the context of");
        ngrams.add("the process of");
        ngrams.add("under these conditions");
        ngrams.add("in all cases");
        ngrams.add("in this paper");
        ngrams.add("is not required");
        ngrams.add("a member of");
        ngrams.add("were performed with");
        ngrams.add("a model for");
        ngrams.add("the fraction of");
        ngrams.add("studies have shown that");
        ngrams.add("is likely to be");
        ngrams.add("as a percentage of");
        ngrams.add("were performed using");
        ngrams.add("as compared with");
        ngrams.add("was able to");
        ngrams.add("has shown that");
        ngrams.add("in terms of");
        ngrams.add("is required to");
        ngrams.add("the appearance of");
        ngrams.add("the proportion of");
        ngrams.add("has been shown to be");
        ngrams.add("similar results were obtained");
        ngrams.add("in this study we");
        ngrams.add("on ice for");
        ngrams.add("appeared to be");
        ngrams.add("we demonstrate that");
        ngrams.add("for an additional");
        ngrams.add("is necessary for");
        ngrams.add("with the exception");
        ngrams.add("were resuspended in");
        ngrams.add("the idea that");
        ngrams.add("on the left");
        ngrams.add("by the method");
        ngrams.add("the evolution of");
        ngrams.add("at the indicated");
        ngrams.add("the assembly of");
        ngrams.add("described in the experimental section");
        ngrams.add("in the experimental section");
        ngrams.add("an important role");
        ngrams.add("shown in figure #");
        ngrams.add("was generated by");
        ngrams.add("was obtained by");
        ngrams.add("were obtained by");
        ngrams.add("the timing of");
        ngrams.add("be used to");
        ngrams.add("is independent of");
        ngrams.add("was observed in");
        ngrams.add("the stability of");
        ngrams.add("the activities of");
        ngrams.add("as described in the experimental section");
        ngrams.add("as described in materials and methods");
        ngrams.add("it should be noted");
        ngrams.add("in the present study we");
        ngrams.add("according to the manufacturer's");
        ngrams.add("little or no");
        ngrams.add("been described previously");
        ngrams.add("is shown in figure");
        ngrams.add("by the method of");
        ngrams.add("been found to");
        ngrams.add("in the formation of");
        ngrams.add("was determined as");
        ngrams.add("alone or in");
        ngrams.add("in a manner");
        ngrams.add("described in figure");
        ngrams.add("at the surface");
        ngrams.add("are described in");
        ngrams.add("in the upper");
        ngrams.add("a comparison of");
        ngrams.add("in a total");
        ngrams.add("was used in");
        ngrams.add("the differences in");
        ngrams.add("the association of");
        ngrams.add("the possibility of");
        ngrams.add("it has been shown that");
        ngrams.add("these results are consistent with");
        ngrams.add("at a flow rate of");
        ngrams.add("it seems likely that");
        ngrams.add("to test this hypothesis");
        ngrams.add("have been identified in");
        ngrams.add("shown in figure #");
        ngrams.add("exclude the possibility");
        ngrams.add("at various times");
        ngrams.add("we tested whether");
        ngrams.add("was introduced into");
        ngrams.add("this implies that");
        ngrams.add("total volume of");
        ngrams.add("are summarized in");
        ngrams.add("results are expressed");
        ngrams.add("were as follows");
        ngrams.add("be caused by");
        ngrams.add("was based on");
        ngrams.add("see figure #");
        ngrams.add("in the production of");
        ngrams.add("see figure #");
        ngrams.add("were allowed to");
        ngrams.add("suggesting that this");
        ngrams.add("was unable to");
        ngrams.add("were made by");
        ngrams.add("was induced by");
        ngrams.add("was examined by");
        ngrams.add("it was shown");
        ngrams.add("is predicted to");
        ngrams.add("as seen in");
        ngrams.add("as part of");
        ngrams.add("to that seen");
        ngrams.add("the rest of");
        ngrams.add("to show that");
        ngrams.add("in figure #");
        ngrams.add("to the right");
        ngrams.add("to that observed");
        ngrams.add("at the site");
        ngrams.add("the rates of");
        ngrams.add("the average of");
        ngrams.add("as in figure");
        ngrams.add("of the indicated");
        ngrams.add("tested for their ability to");
        ngrams.add("were carried out at");
        ngrams.add("did not appear to");
        ngrams.add("has been suggested that");
        ngrams.add("which is consistent with");
        ngrams.add("are shown in table");
        ngrams.add("that are required for");
        ngrams.add("have been implicated");
        ngrams.add("were found to be");
        ngrams.add("an essential role");
        ngrams.add("the total number of");
        ngrams.add("in support of this");
        ngrams.add("in the vicinity of");
        ngrams.add("as reported previously");
        ngrams.add("when compared with");
        ngrams.add("was digested with");
        ngrams.add("as a consequence");
        ngrams.add("in each case");
        ngrams.add("was purified from");
        ngrams.add("is due to");
        ngrams.add("shown in fig");
        ngrams.add("in table #");
        ngrams.add("a component of");
        ngrams.add("a response to");
        ngrams.add("it has been shown");
        ngrams.add("in the context of");
        ngrams.add("are thought to");
        ngrams.add("in agreement with");
        ngrams.add("is responsible for");
        ngrams.add("were prepared by");
        ngrams.add("to be required");
        ngrams.add("a mixture of");
        ngrams.add("the generation of");
        ngrams.add("the pattern of");
        ngrams.add("does not appear to");
        ngrams.add("was performed as described");
        ngrams.add("the manufacturer's instructions");
        ngrams.add("have been reported");
        ngrams.add("at the end of");
        ngrams.add("analysis was performed");
        ngrams.add("expected to be");
        ngrams.add("possibility is that");
        ngrams.add("is important for");
        ngrams.add("be detected in");
        ngrams.add("were grown to");
        ngrams.add("the finding that");
        ngrams.add("a reduction in");
        ngrams.add("these results indicate that");
        ngrams.add("were performed as described");
        ngrams.add("kindly provided by");
        ngrams.add("does not affect");
        ngrams.add("is known about");
        ngrams.add("can be detected");
        ngrams.add("to test whether");
        ngrams.add("in accordance with");
        ngrams.add("lines of evidence");
        ngrams.add("been reported to");
        ngrams.add("been identified in");
        ngrams.add("a density of");
        ngrams.add("to distinguish between");
        ngrams.add("a critical role");
        ngrams.add("consistent with our");
        ngrams.add("at the surface of");
        ngrams.add("compared with control");
        ngrams.add("in concert with");
        ngrams.add("a small number");
        ngrams.add("is also possible");
        ngrams.add("was dependent on");
        ngrams.add("would result in");
        ngrams.add("are responsible for");
        ngrams.add("was dissolved in");
        ngrams.add("the present work");
        ngrams.add("were processed for");
        ngrams.add("was determined using");
        ngrams.add("was mixed with");
        ngrams.add("at this time");
        ngrams.add("is subject to");
        ngrams.add("in the amount of");
        ngrams.add("be consistent with");
        ngrams.add("shown previously that");
        ngrams.add("be associated with");
        ngrams.add("are able to");
        ngrams.add("is sensitive to");
        ngrams.add("were treated for");
        ngrams.add("was resuspended in");
        ngrams.add("as indicated by");
        ngrams.add("is capable of");
        ngrams.add("in the number of");
        ngrams.add("not result in");
        ngrams.add("as a model");
        ngrams.add("in table #");
        ngrams.add("as described for");
        ngrams.add("were washed in");
        ngrams.add("this type of");
        ngrams.add("were obtained in");
        ngrams.add("the question of");
        ngrams.add("was similar to");
        ngrams.add("the beginning of");
        ngrams.add("the significance of");
        ngrams.add("the removal of");
        ngrams.add("the incorporation of");
        ngrams.add("the origin of");
        ngrams.add("with the following");
        ngrams.add("the properties of");
        ngrams.add("the growth of");
    }
    public String classify(NGram n) {
        if(ngrams.contains(n.getText())) {
            return "Included";
        } else {
            return "Unknown";
        }
    }

    public void filterList(List<NGram> l) {
        Iterator<NGram> it = l.iterator();
        while(it.hasNext()) {
            NGram cur = it.next();
            if(ngrams.contains(StringUtils.replaceAllNumbers(cur.getText()))) {
                it.remove();
            }
        }
    }
}
