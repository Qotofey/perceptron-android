package ru.qotofey.perceptron.view;

import ru.qotofey.perceptron.model.Sample;

public interface SampleView extends BaseView {

    void renderSample(Sample sample);
}
