package application;

import data.FileReader;
import entities.Pregnant;
import neuralNetworks.SinglePerceptron;
import services.ListSeparator;

import javax.swing.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pregnant> pregnantList = new ArrayList<Pregnant>();

        System.out.print("Digite o caminho do arquivo: ");
        //C:\Users\bruno\Documents\MaternalHealthRiskDataSet.csv
        String path = sc.next();
        FileReader fileReader = new FileReader(path);

        pregnantList = fileReader.uploadedData();
        Collections.sort(pregnantList);
        for(int i=0;i<10;i++){
            ListSeparator ls = new ListSeparator(pregnantList);

            List<Pregnant> testList = ls.getTestList();
            List<Pregnant> trainingList = ls.getTrainingList();

            SinglePerceptron singlePerceptron = new SinglePerceptron();
            singlePerceptron.trainingPhase(trainingList);

            double acurace = 0;
            int hit=0;
            for(Pregnant pregnant: testList){
                int assistent = singlePerceptron.operationPhase(pregnant);
                if(assistent == pregnant.getRiskLevel()){
                    hit++;
                }
            }
            acurace = (hit*100)/testList.size();
            System.out.println("\nEPOCH : 1000");
            System.out.println("ACURACE : " +acurace + "%\n");
        }
        sc.close();
    }
}
