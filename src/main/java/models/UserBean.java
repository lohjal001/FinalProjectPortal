package models;

import java.io.Serializable;

//userbean represents the connector
public class UserBean implements Serializable {

    private USER_TYPE userType = USER_TYPE.student;

    private USER_PRIVILAGE userPrivilage = USER_PRIVILAGE.anonymous;

    private PRIVILAGE_TYPE privilageType = PRIVILAGE_TYPE.user;

    public PRIVILAGE_TYPE getPrivilageType() {
        return privilageType;
    }

    public void setPrivilageType(PRIVILAGE_TYPE privilageType) {
        this.privilageType = privilageType;
    }

    public USER_PRIVILAGE getUserPrivilage() {
        return userPrivilage;
    }

    public void setUserPrivilage(USER_PRIVILAGE userPrivilage) {
        this.userPrivilage = userPrivilage;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

    private String myVar = "";

    public UserBean(){}

    public String getMyVar() {
        return myVar;
    }

    public void setMyVar(String myVar) {
        this.myVar = myVar;
    }

    enum USER_TYPE{
        //vanligtvis all caps i enum men bör matcha databasen i detta fallet
        student,
        teacher
    }

    enum PRIVILAGE_TYPE{
        user,
        admin,
        superAdmin
    }

    enum USER_PRIVILAGE{
        anonymous,
        confirmed
    }
}
