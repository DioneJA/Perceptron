package neuralNetworks;

import entities.Pregnant;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class SinglePerceptron {
    private Double[] weights = new Double[6];
    private Double n = 0.1;
    private int BIAS = -1;
    public void initializeWeights() {
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            this.weights[i] = rand.nextDouble(1);
            if(i%2==0){
                this.weights[i]*=-1;
            }
        }
    }
    public int functionOfAtivation(double result){
        if(result<5.19893){
            return 1;
        } else if (result>=5.19893&&result<5.20236) {
            return 2;
        }else if(result>=5.20236){
            return 3;
        }
        return 0;
    }
    public void trainingPhase(List<Pregnant> pregnantList) {
        this.initializeWeights();
        int epoch = 0;
        boolean error = false;
        Double result = 0d;
        int y = 0;
        do {
            error = false;
            for (Pregnant x : pregnantList) {
                result += weights[0] * x.getAge();
                result += weights[1] * x.getSystolicBP();
                result += weights[2] * x.getDiastolicBP();
                result += weights[3] * x.getBs();
                result += weights[4] * x.getBodyTemp();
                result += weights[5] * x.getHeartRate();
                result -= BIAS;

                y = this.functionOfAtivation(result);

                if (y != x.getRiskLevel()) {
                    weights[0] = weights[0] + n * (x.getRiskLevel() - y) * x.getAge();
                    weights[1] = weights[1] + n * (x.getRiskLevel() - y) * x.getSystolicBP();
                    weights[2] = weights[2] + n * (x.getRiskLevel() - y) * x.getDiastolicBP();
                    weights[3] = weights[3] + n * (x.getRiskLevel() - y) * x.getBs();
                    weights[4] = weights[4] + n * (x.getRiskLevel() - y) * x.getBodyTemp();
                    weights[5] = weights[5] + n * (x.getRiskLevel() - y) * x.getHeartRate();
                    error = true;
                }
            }
            epoch++;
        } while (error && epoch < 1000);
    }

    public int operationPhase(Pregnant pregnant) {
        float result = 0;
        result += weights[0] * pregnant.getAge();
        result += weights[1] * pregnant.getSystolicBP();
        result += weights[2] * pregnant.getDiastolicBP();
        result += weights[3] * pregnant.getBs();
        result += weights[4] * pregnant.getBodyTemp();
        result += weights[5] * pregnant.getHeartRate();
        result -= BIAS;

       return functionOfAtivation(result);
    }
}
