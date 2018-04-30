package kashika.jain.sjsu.edu.heartprediction;

import android.content.Context;
import android.content.SharedPreferences;

class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }
    public void storeUserData(User user){
        SharedPreferences.Editor spEdiitor = userLocalDatabase.edit();
        spEdiitor.putString("name", user.name);
        spEdiitor.putString("age", user.age);
        spEdiitor.putString("sex", user.sex);
        spEdiitor.putString("username", user.username);
        spEdiitor.putString("passwrd", user.passwrd);
        spEdiitor.commit();
    }

    public User getLoggedInUser(){
        String name = userLocalDatabase.getString("name","");
        String age = userLocalDatabase.getString("age","");
        String sex = userLocalDatabase.getString("sex", "");
        String username = userLocalDatabase.getString("username", "");
        String passwrd = userLocalDatabase.getString("passwrd", "");

        User storedUser = new User(name, age, sex, username, passwrd);
        return storedUser;
    }
    public void setUserLoggedIn (boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){

        if (userLocalDatabase.getBoolean("LoggedIn",false ) == true){
            return true;
        }
        else {
            return false;
        }
    }
    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
