package com.alhous.ai.bootraining;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.alhous.ai.bootraining.dataview.DatasetViewer;
import com.alhous.ai.bootraining.dataview.DatasetViewerImpl;
import com.alhous.ai.bootraining.iris.IrisRecord;
import com.alhous.ai.bootraining.iris.IrisService;
import com.alhous.ai.bootraining.iris.IrisServiceImpl;
import com.alhous.ai.bootraining.iris.ModelConfig;
import com.alhous.ai.bootraining.iris.ModelConfigImpl;
import com.alhous.ai.bootraining.iris.Reporter;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.junit.jupiter.api.Test;
import org.nd4j.linalg.api.iter.INDArrayIterator;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootrainingApplicationTests {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	void contextLoads() {
	}

	@Test
	void toIrisdataset() {
		File file = new File("C:/deeplearning4j-tutorials/data/iris-pro.csv");
		RecordReader reader = new CSVRecordReader(',');
		try {
			reader.initialize(new FileSplit(file));
		} catch (Exception e) {
		}

		IrisService service = new IrisServiceImpl();
		DataSetIterator iterator = new RecordReaderDataSetIterator(reader, 150, 4, 3);

		DataSet dataset = service.normilize(0, 1, iterator);
		dataset.shuffle(100);
		SplitTestAndTrain split = service.split(0.80, dataset);
		DataSet testSet = split.getTest();
		DataSet trainSet = split.getTrain();

		ModelConfig mc = new ModelConfigImpl();
		MultiLayerNetwork model = mc.getModel();
		Reporter repo = service.train(model, trainSet, testSet, 1000);
		// 5.1,3.5,1.4,0.2
		INDArray v = Nd4j.create(new double[][] { { 5.1, 3.5, 1.4, 0.2 } });
		int[] res = model.predict(v);
		log.info(repo.toString());
		log.info("Prediction : " + Arrays.toString(res));
	}

}
