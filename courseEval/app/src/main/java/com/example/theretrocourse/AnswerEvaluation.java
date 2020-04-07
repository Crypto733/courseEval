package com.example.theretrocourse;

public class AnswerEvaluation {
    private String CourseID,BTH_mail,b1,b2,b3,b4,b5,comment;

    public AnswerEvaluation(String CourseID, String BTH_mail, String b1, String b2, String b3, String b4, String b5, String comment) {
        this.CourseID = CourseID;
        this.BTH_mail=BTH_mail;
        this.b1=b1;
        this.b2=b2;
        this.b3=b3;
        this.b4=b4;
        this.b5=b5;
        this.comment=comment;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getBTH_mail() {
        return BTH_mail;
    }

    public void setBTH_mail(String BTH_mail) {
        this.BTH_mail = BTH_mail;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    public String getB4() {
        return b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public String getB5() {
        return b5;
    }

    public void setB5(String b5) {
        this.b5 = b5;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "EvaluationResult{" +
                "CourseID='" + CourseID + '\'' +
                ", BTH_mail='" + BTH_mail + '\'' +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                ", b4='" + b4 + '\'' +
                ", b5='" + b5 + '\'' +
                ", comment='" + comment;
    }
}
