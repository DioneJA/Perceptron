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
            this.weights[i] = Math.abs(rand.nextDouble(1));
            System.out.print("Pesos: " + weights[i]);
        }

    }
    public int functionOfAtivation(Pregnant x){
        double result = (weights[0] * x.getAge() + weights[1] * x.getSystolicBP() - BIAS)
        + (weights[2] * x.getDiastolicBP() -BIAS)
        + (weights[3] * x.getBs()-BIAS)
        + (weights[4] * x.getBodyTemp() -BIAS)
        + (weights[5] * x.getHeartRate()-BIAS);
        if(result>0){
            return 1;
        } else if (result<0) {
            return 2;
        }else{
            return 3;
        }
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

                y = this.functionOfAtivation(x);

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
            System.out.println(epoch);
        } while (error && epoch < 100);
    }

    public int operationPhase(Pregnant pregnant) {
        float result = 0;
        int y = 0;
        result += weights[0] * pregnant.getAge();
        result += weights[1] * pregnant.getSystolicBP();
        result += weights[2] * pregnant.getDiastolicBP();
        result += weights[3] * pregnant.getBs();
        result += weights[4] * pregnant.getBodyTemp();
        result += weights[5] * pregnant.getHeartRate();

        if (result > 0) {
            y = 1;
        } else if (result < 0) {
            y = 2;
        }else{
            y=3;
        }
       return y;
    }
}
