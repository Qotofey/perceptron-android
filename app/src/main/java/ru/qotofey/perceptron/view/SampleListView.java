package ru.qotofey.perceptron.view;

import java.util.List;

import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.net.rest.model.response.Question;

public interface SampleListView extends BaseView {

    void renderSampleList(List<Sample> sampleList);
    void viewSample(Sample sample);

}
