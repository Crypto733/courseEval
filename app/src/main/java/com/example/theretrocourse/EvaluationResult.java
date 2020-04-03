package com.example.theretrocourse;

public class EvaluationResult {
    private String CourseID,BTH_mail,b1,b2,b3,b4,b5,comment_1,comment_2,comment_3,comment_4,comment_5;

    public EvaluationResult(String CourseID, String BTH_mail, String b1, String b2,
                            String b3, String b4, String b5,
                            String comment_1, String comment_2, String comment_3,
                            String comment_4, String comment_5) {
        this.CourseID = CourseID;
        this.BTH_mail=BTH_mail;
        this.b1=b1;
        this.b2=b2;
        this.b3=b3;
        this.b4=b4;
        this.b5=b5;
        this.comment_1=comment_1;
        this.comment_2=comment_2;
        this.comment_3=comment_3;
        this.comment_4=comment_4;
        this.comment_5=comment_5;
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

    public String getComment_1() {
        return comment_1;
    }

    public void setComment_1(String comment_1) {
        this.comment_1 = comment_1;
    }

    public String getComment_2() {
        return comment_2;
    }

    public void setComment_2(String comment_2) {
        this.comment_2 = comment_2;
    }

    public String getComment_3() {
        return comment_3;
    }

    public void setComment_3(String comment_3) {
        this.comment_3 = comment_3;
    }

    public String getComment_4() {
        return comment_4;
    }

    public void setComment_4(String comment_4) {
        this.comment_4 = comment_4;
    }

    public String getComment_5() {
        return comment_5;
    }

    public void setComment_5(String comment_5) {
        this.comment_5 = comment_5;
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
                ", comment_1='" + comment_1 + '\'' +
                ", comment_2='" + comment_2 + '\'' +
                ", comment_3='" + comment_3 + '\'' +
                ", comment_4='" + comment_4 + '\'' +
                ", comment_5='" + comment_5 + '\'' +
                '}';
    }
}
