package data;

import entities.Pregnant;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class FileReader {
    private String path;

    public FileReader(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Pregnant> uploadedData() {
        try {
            List<Pregnant> pregnantList = new ArrayList<Pregnant>();
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(this.path));
            String line = bufferedReader.readLine();
            String[] assistent;
            String age = "";
            int cont = 0;
            while (line != null) {
                if (cont != 0) {
                    assistent = line.split(",");
                    age = assistent[0];
                    if (assistent[6].equals("low risk")) {
                        assistent[6] = "1";
                    } else if (assistent[6].equals("mid risk")) {
                        assistent[6] = "2";
                    } else {
                        assistent[6] = "3";
                    }

                    Pregnant pregnant = new Pregnant();

                    pregnant.setAge(Integer.parseInt(age));
                    pregnant.setSystolicBP(Double.parseDouble(assistent[1]));
                    pregnant.setDiastolicBP(Double.parseDouble(assistent[2]));
                    pregnant.setBs(Double.parseDouble(assistent[3]));
                    pregnant.setBodyTemp(Double.parseDouble(assistent[4]));
                    pregnant.setHeartRate(Double.parseDouble(assistent[5]));
                    pregnant.setRiskLevel(Integer.parseInt(assistent[6]));
                    pregnantList.add(pregnant);
                } else {
                    cont++;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            return pregnantList;
        } catch (Exception e) {
            System.out.println("Error! Error in file reading, caused by: " + e.getMessage());
            return null;
        }
    }
}
