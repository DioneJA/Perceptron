package data;

import entities.PregnantWoman;

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

    public List<PregnantWoman> uploadedData(){
        try{
            List<PregnantWoman> pregnantWomanList = new ArrayList<PregnantWoman>();
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(this.path));
            String line = bufferedReader.readLine();
            String[] assistent = line.split(",");
            String age = "";
            for(int i=1;i<assistent[0].length();i++){
                age+= assistent[0].charAt(i);
            }
            while(line!=null){
                if(assistent[6].equals("low risk")){
                    assistent[6] = "1";
                }else if(assistent[6].equals("mid risk")){
                    assistent[6] = "2";
                }else {
                    assistent[6] = "3";
                }

                PregnantWoman pregnantWoman = new PregnantWoman();

                pregnantWoman.setAge(Integer.parseInt(age));
                pregnantWoman.setSystolicBP(Double.parseDouble(assistent[1]));
                pregnantWoman.setDiastolicBP(Double.parseDouble(assistent[2]));
                pregnantWoman.setBs(Double.parseDouble(assistent[3]));
                pregnantWoman.setBodyTemp(Double.parseDouble(assistent[4]));
                pregnantWoman.setHeartRate(Double.parseDouble(assistent[5]));
                pregnantWoman.setRiskLevel(Integer.parseInt(assistent[6]));
                pregnantWomanList.add(pregnantWoman);
                line = bufferedReader.readLine();
                if(line!=null){
                    assistent = line.split(",");
                    age = assistent[0];
                }
            }
            bufferedReader.close();
            return pregnantWomanList;
        }catch (Exception e){
            System.out.println("Error! Error in file reading, caused by: " + e.getMessage());
            return null;
        }
    }
}
