package com.example.youthwings;

public class MainEmploymentListViewItem {

    String classification;
    String commutitle;
    String mtime;

    public MainEmploymentListViewItem(String classification, String commutitle, String mtime){
        this.classification = classification;
        this.commutitle = commutitle;
        this.mtime = mtime;
    }

    //변수에 접근
    public String getClassification(){
        return classification;
    }

    public void setClassification(){
        this.classification = classification;
    }

    public String getCommutitle(){
        return commutitle;
    }

    public void setCommutitle(){
        this.commutitle = commutitle;
    }

    public String getMtime(){
        return mtime;
    }

    public void setMtime(){
        this.mtime = mtime;
    }

}
