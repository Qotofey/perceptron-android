package ru.qotofey.perceptron.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.qotofey.perceptron.net.rest.model.response.Answer;
import ru.qotofey.perceptron.net.rest.model.response.Question;

public class SampleStorage {
    protected final String TAG = this.getClass().getName();

    private List<Sample> mSampleList;

    public SampleStorage(List<Sample> sampleList) {
        mSampleList = sampleList;
    }

    public SampleStorage() {
        mSampleList = new ArrayList<>();
    }

    public SampleStorage insertAnswerList(List<Answer> answerList) {
        mSampleList.clear();
        for (Answer answer : answerList) {
            boolean isExist = false;
            for (Sample sample : mSampleList) {
                if (sample.getAnswer().id.equals(answer.id)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) mSampleList.add(new Sample(answer));
        }
        return this;
    }

    private Sample mSample;

    public void addSample(Sample sample) {
        mSampleList.add(sample);
    }

    public SampleStorage insertQuestionList(List<Question> questionList) {
        for (Sample sample : mSampleList) {
            sample.distribute(questionList);
        }
        return this;
    }

    public List<Sample> getSampleList() {
        return mSampleList;
    }

    public void setSampleList(List<Sample> sampleList) {
        mSampleList = sampleList;
    }

    public Sample getSample(UUID id) {
        for (Sample sample : mSampleList) {
            Log.i(TAG, "Аргумент ID: " + id);
            Log.i(TAG, "ID выбокри: " + sample.getId());
            if (sample.getId().equals(id)) {
                return sample;
            }
        }
        return null;
    }

    public AnswerListObserver answerListObserver = new AnswerListObserver();
    public QuestionListObserver questionListObserver = new QuestionListObserver();
    public AnswerObserver answerObserver = new AnswerObserver();
    public QuestionObserver questionObserver = new QuestionObserver();

    public class AnswerListObserver implements Observer<List<Answer>> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<Answer> answerList) {
            SampleStorage.this.insertAnswerList(answerList);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onComplete() {

        }

    }
    public class AnswerObserver implements Observer<Answer> {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Answer answer) {
            mSample = new Sample(answer);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onComplete() {

        }
    }

    public class QuestionListObserver implements Observer<List<Question>> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<Question> questionList) {
            SampleStorage.this.insertQuestionList(questionList);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onComplete() {

        }
    }
    public class QuestionObserver implements Observer<Question> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Question question) {
            mSample.setQuestion(question);
            mSampleList.add(mSample);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onComplete() {

        }
    }

}
