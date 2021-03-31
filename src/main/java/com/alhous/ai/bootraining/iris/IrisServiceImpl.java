package com.alhous.ai.bootraining.iris;

import java.util.ArrayList;
import java.util.List;

import org.deeplearning4j.datasets.iterator.impl.ListDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.evaluation.classification.Evaluation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerMinMaxScaler;

public class IrisServiceImpl implements IrisService {

    @Override
    public List<IrisRecord> toIrisRecords(DataSet dataset) {
        List<IrisRecord> records = new ArrayList<>();
        for (int i = 0; i < dataset.numExamples(); i++) {
            DataSet ds = dataset.get(i);
            IrisRecord record = new IrisRecord();
            INDArray array = ds.getFeatures();
            record.setSepalLength(array.getDouble(0, 0));
            record.setSepalWidth(array.getDouble(0, 1));
            record.setPetalLength(array.getDouble(0, 2));
            record.setPetalWidth(array.getDouble(0, 3));
            record.setSpece(ds.outcome());
            records.add(record);
        }
        return records;
    }

    @Override
    public SplitTestAndTrain split(double trainPercentage, DataSet dataset) {
        SplitTestAndTrain split = dataset.splitTestAndTrain(trainPercentage);
        return split;
    }

    @Override
    public DataSet normilize(double min, double max, DataSetIterator iterator) {
        NormalizerMinMaxScaler normalizer = new NormalizerMinMaxScaler(min, max);
        normalizer.fit(iterator);
        iterator.setPreProcessor(normalizer);        
        return iterator.next();
    }

    @Override
    public Reporter train(MultiLayerNetwork model, DataSet trainSet, DataSet testSet, int numEpock) {
        Reporter reporter = new Reporter();
        for (int i = 0; i < numEpock; i++) {
            model.fit(trainSet);
        }
        reporter.setF1Score(model.f1Score(testSet));
        List<DataSet> list = testSet.asList();
        DataSetIterator testIterator = new ListDataSetIterator<>(list);
        Evaluation eval = model.evaluate(testIterator);
        reporter.setAccuracy(eval.accuracy());
        reporter.setPrecision(eval.precision());
        reporter.setRecall(eval.recall());    
        return reporter;
    }

}
