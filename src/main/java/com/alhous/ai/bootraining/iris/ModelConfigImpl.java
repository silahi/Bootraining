package com.alhous.ai.bootraining.iris;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Nesterovs;

public class ModelConfigImpl implements ModelConfig {
    private double momentum = 0.1;
    private double learningRate = 0.9;

    @Override
    public void setMomentum(double p) {
        momentum = p;
    }

    @Override
    public void setLearningRate(double alpha) {
        learningRate = alpha;
    }

    @Override
    public MultiLayerNetwork getModel() {
        OutputLayer outputLayer = new OutputLayer.Builder().nIn(4).nOut(3).activation(Activation.SOFTMAX)
                .weightInit(WeightInit.XAVIER).build();

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder().seed(123).weightInit(WeightInit.XAVIER)
                .updater(new Nesterovs(learningRate, momentum))
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT).list().layer(outputLayer).build();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        return model;
    }

}
