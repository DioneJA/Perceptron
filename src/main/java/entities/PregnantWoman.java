package entities;

public class PregnantWoman implements Comparable<PregnantWoman>{

    private int age;
    private double systolicBP; //pressão arterial mais alta
    private double diastolicBP; //pressão arterial mais baixa
    private double bs;
    private double bodyTemp;
    private double heartRate; // Frequencia cardíaca
    private int riskLevel;

    public PregnantWoman(){
    }

    public PregnantWoman(int age, double systolicBP, double diastolicBP, double bs, double bodyTemp, double heartRate, int riskLevel) {
        this.age = age;
        this.systolicBP = systolicBP;
        this.diastolicBP = diastolicBP;
        this.bs = bs;
        this.bodyTemp = bodyTemp;
        this.heartRate = heartRate;
        this.riskLevel = riskLevel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSystolicBP() {
        return systolicBP;
    }

    public void setSystolicBP(double systolicBP) {
        this.systolicBP = systolicBP;
    }

    public double getDiastolicBP() {
        return diastolicBP;
    }

    public void setDiastolicBP(double diastolicBP) {
        this.diastolicBP = diastolicBP;
    }

    public double getBs() {
        return bs;
    }

    public void setBs(double bs) {
        this.bs = bs;
    }

    public double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Override
    public String toString() {
        return "PregnantWoman{" +
                "age=" + age +
                ", systolicBP=" + systolicBP +
                ", diastolicBP=" + diastolicBP +
                ", bs=" + bs +
                ", bodyTemp=" + bodyTemp +
                ", heartRate=" + heartRate +
                ", riskLevel='" + riskLevel + '\'' +
                '}';
    }

    @Override
    public int compareTo(PregnantWoman o) {
        if(getRiskLevel()==o.getRiskLevel()){
            return 0;
        }else if(getRiskLevel()>o.getRiskLevel()){
            return 1;
        }else{
            return -1;
        }
    }
}
