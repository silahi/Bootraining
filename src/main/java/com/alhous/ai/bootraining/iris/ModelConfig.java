package com.alhous.ai.bootraining.iris;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;

public interface ModelConfig {
    public void setMomentum(double p);

    public void setLearningRate(double alphe);

    public MultiLayerNetwork getModel();
}
