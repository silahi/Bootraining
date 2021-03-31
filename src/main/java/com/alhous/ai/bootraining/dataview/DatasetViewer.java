package com.alhous.ai.bootraining.dataview;

import java.util.List;

import com.alhous.ai.bootraining.iris.IrisRecord;

import org.nd4j.linalg.dataset.DataSet;

public interface DatasetViewer {
    public List<IrisRecord> toIrisRecords(DataSet dataset);
}
