package phonestation.bean;

public class User {
    private String login;
    private String password;
    private boolean baseFunctions;
    private boolean customAlarm;
    private boolean ipPhone;
    private boolean hideNumber;

    public String GetLogin(){
        return login;
    }
    public  void SetLogin(String login){
        this.login = login;
    }

    public String GetPassword(){
        return password;
    }
    public  void SetPassword(String password){
        this.password = password;
    }

    public boolean GetBaseFunctions(){
        return baseFunctions;
    }
    public  void SetBaseFunctions(boolean baseFunctions){
        this.baseFunctions = baseFunctions;
    }

    public boolean GetipPhone(){
        return ipPhone;
    }
    public  void SetipPhone(boolean ipPhone){
        this.ipPhone = ipPhone;
    }

    public boolean GetCustomAlarm(){
        return customAlarm;
    }
    public  void SetCustomAlarm(boolean customAlarm){
        this.customAlarm = customAlarm;
    }

    public boolean GetHideNumber(){ return hideNumber; }
    public  void SetHideNumber(boolean hideNumber){ this.hideNumber = hideNumber; }
}
