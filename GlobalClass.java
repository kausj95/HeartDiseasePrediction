package kashika.jain.sjsu.edu.heartprediction;

import android.app.Application;

public class GlobalClass extends Application{

    private String username;
    private String age;
    private String sex;
    private String chestpain;
    private String restbp;
    private String cholesterol;
    private String fbs;
    private String restecg;
    private String heartrate;
    private String exang;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setChestpain(String chestpain) {
        this.chestpain = chestpain;
    }

    public void setRestbp(String restbp) {
        this.restbp = restbp;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public void setFbs(String fbs) {
        this.fbs = fbs;
    }

    public void setRestecg(String restecg) {
        this.restecg = restecg;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate;
    }

    public void setExang(String exang) {
        this.exang = exang;
    }

    public String getUsername() {
        return username;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getChestpain() {
        return chestpain;
    }

    public String getRestbp() {
        return restbp;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public String getFbs() {
        return fbs;
    }

    public String getRestecg() {
        return restecg;
    }

    public String getHeartrate() {
        return heartrate;
    }

    public String getExang() {
        return exang;
    }
}
