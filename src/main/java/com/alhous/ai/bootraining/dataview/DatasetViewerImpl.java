package com.alhous.ai.bootraining.dataview;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.alhous.ai.bootraining.iris.IrisRecord;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.springframework.stereotype.Service;

@Service
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

    @Override
    public DataSetIterator irisIterator() {
        File file = new File("C:/deeplearning4j-tutorials/data/iris-pro.csv");
        RecordReader reader = new CSVRecordReader(',');
        try {
            reader.initialize(new FileSplit(file));
        } catch (Exception e) {
        }
        DataSetIterator iterator = new RecordReaderDataSetIterator(reader, 150, 4, 3);
        return iterator;
    }

    @Override
    public List<IrisRecord> iridData(DataSetIterator iterator) {
        return toIrisRecords(iterator.next());
    }

}
