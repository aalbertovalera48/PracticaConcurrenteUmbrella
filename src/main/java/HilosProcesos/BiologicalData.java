package HilosProcesos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BiologicalData {
    private String id;
    private String gender;
    private int age;
    private int heightCm;
    private int weightKg;
    private int waistCm;
    private double eyesightLeft;
    private double eyesightRight;
    private double hearingLeft;
    private double hearingRight;
    private int systolic;
    private int relaxation;
    private double fastingBloodSugar;
    private double cholesterol;
    private double triglyceride;
    private double hdl;
    private double ldl;
    private double hemoglobin;
    private double urineProtein;
    private double serumCreatinine;
    private double ast;
    private double alt;
    private double gtp;
    private boolean oralHealth;
    private boolean dentalCaries;
    private boolean tartar;
    private boolean smoking;

    public BiologicalData(String id, String gender, int age, int heightCm, int weightKg, int waistCm, double eyesightLeft, double eyesightRight, double hearingLeft, double hearingRight, int systolic, int relaxation, double fastingBloodSugar, double cholesterol, double triglyceride, double hdl, double ldl, double hemoglobin, double urineProtein, double serumCreatinine, double ast, double alt, double gtp, boolean oralHealth, boolean dentalCaries, boolean tartar, boolean smoking) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.waistCm = waistCm;
        this.eyesightLeft = eyesightLeft;
        this.eyesightRight = eyesightRight;
        this.hearingLeft = hearingLeft;
        this.hearingRight = hearingRight;
        this.systolic = systolic;
        this.relaxation = relaxation;
        this.fastingBloodSugar = fastingBloodSugar;
        this.cholesterol = cholesterol;
        this.triglyceride = triglyceride;
        this.hdl = hdl;
        this.ldl = ldl;
        this.hemoglobin = hemoglobin;
        this.urineProtein = urineProtein;
        this.serumCreatinine = serumCreatinine;
        this.ast = ast;
        this.alt = alt;
        this.gtp = gtp;
        this.oralHealth = oralHealth;
        this.dentalCaries = dentalCaries;
        this.tartar = tartar;
        this.smoking = smoking;
    }
}



