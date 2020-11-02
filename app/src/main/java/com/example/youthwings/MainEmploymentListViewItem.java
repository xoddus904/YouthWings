package com.example.youthwings;

public class MainEmploymentListViewItem {

    private String classification;
    private String commutitle;
    private String mtime;

    public MainEmploymentListViewItem(String classification, String commutitle, String mtime){
        this.classification = classification;
        this.commutitle = commutitle;
        this.mtime = mtime;
    }

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
