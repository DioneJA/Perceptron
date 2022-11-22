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
        ListSeparator ls = new ListSeparator(pregnantList);

        List<Pregnant> testList = ls.getTestList();
        List<Pregnant> trainingList = ls.getTrainingList();

        System.out.println("SIZE NORMAL : " + pregnantList.size());
        System.out.println("SIZE TESTE : " + testList.size());
        System.out.println("SIZE TREINAMENTO : " + trainingList.size());

        SinglePerceptron singlePerceptron = new SinglePerceptron();
        singlePerceptron.trainingPhase(trainingList);

        Pregnant test = new Pregnant(45,120,95,6.1,98,66,1);
        System.out.println("AQUI" + singlePerceptron.operationPhase(test));
        sc.close();
    }
}
