package com.alhous.ai.bootraining.iris;

import java.util.List;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

public interface IrisService {
    public List<IrisRecord> toIrisRecords(DataSet dataset);

    public SplitTestAndTrain split(double trainPercentage, DataSet dataSet);

    public DataSet normilize(double min, double max, DataSetIterator iterator);

    public Reporter train(MultiLayerNetwork model, DataSet trainSet, DataSet testSet, int numEpock);
    
}
