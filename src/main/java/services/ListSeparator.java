package services;

import entities.Pregnant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListSeparator {
    private List<Pregnant> pregnantList;
    private List<Pregnant> lowRisk;
    private List<Pregnant> mediumRisk;
    private List<Pregnant> highRisk;

    public ListSeparator(List<Pregnant> pregnantList) {
        this.pregnantList = pregnantList;
        this.lowRisk = this.pregnantList.stream()
                .filter(entry -> entry.getRiskLevel() == 1)
                .collect(Collectors.toList());
        this.mediumRisk = this.pregnantList.stream()
                .filter(entry -> entry.getRiskLevel() == 2)
                .collect(Collectors.toList());
        this.highRisk = this.pregnantList.stream()
                .filter(entry -> entry.getRiskLevel() == 3)
                .collect(Collectors.toList());
    }

    public List<Pregnant> getTestList() {
        List<Pregnant> testList = new ArrayList<>();
        int counter = 0;
        int lowRiskSize = lowRisk.size();
        int mediumRiskSize = mediumRisk.size();
        int highRiskSize = highRisk.size();
        Random rand = new Random();
        while (counter < Math.floor(lowRiskSize * 0.3)) {
            int random = rand.nextInt(lowRisk.size());
            testList.add(lowRisk.get(random));
            lowRisk.remove(random);
            counter++;
        }
        counter = 0;
        while (counter < Math.floor(mediumRiskSize * 0.3)) {
            int random = rand.nextInt(mediumRisk.size());
            testList.add(mediumRisk.get(random));
            mediumRisk.remove(random);
            counter++;
        }
        counter = 0;
        while (counter < Math.floor(highRiskSize * 0.3)) {
            int random = rand.nextInt(highRisk.size());
            testList.add(highRisk.get(random));
            highRisk.remove(random);
            counter++;
        }
        return testList;
    }

    public List<Pregnant> getTrainingList() {
        List<Pregnant> trainingList = new ArrayList<>();
        trainingList.addAll(lowRisk);
        trainingList.addAll(mediumRisk);
        trainingList.addAll(highRisk);
        return trainingList;
    }
}
