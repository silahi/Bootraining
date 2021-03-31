package com.alhous.ai.bootraining.dataview;

import java.util.List;

import com.alhous.ai.bootraining.iris.IrisRecord;

import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

public interface DatasetViewer {
    public List<IrisRecord> toIrisRecords(DataSet dataset);

    public List<IrisRecord> iridData(DataSetIterator iterator);

    public DataSetIterator irisIterator();
}
