package com.alhous.ai.bootraining.dataview;

import java.util.ArrayList;
import java.util.List;

import com.alhous.ai.bootraining.iris.IrisRecord;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;

public class DatasetViewerImpl implements DatasetViewer {

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

}
