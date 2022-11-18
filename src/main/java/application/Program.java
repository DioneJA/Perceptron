package application;

import data.FileReader;
import entities.PregnantWoman;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<PregnantWoman> pregnantWomanList = new ArrayList<PregnantWoman>();

        System.out.println("Digite o caminho do arquivo: ");

        FileReader fileReader = new FileReader("C:\\Users\\bruno\\Downloads\\Maternal Health Risk Data Set.csv");

        pregnantWomanList = fileReader.uploadedData();
        Collections.sort(pregnantWomanList);
        pregnantWomanList.forEach(System.out::println);
        sc.close();
    }
}
