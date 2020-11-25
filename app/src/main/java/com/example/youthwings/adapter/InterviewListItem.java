package com.example.youthwings.adapter;

public class InterviewListItem {

    private String interviewTitle;
    private int interview_response;

    public InterviewListItem(String interviewTitle, int interview_response) {
        this.interviewTitle = interviewTitle;
        this.interview_response = interview_response;
    }

    public String getInterviewTitle() {
        return interviewTitle;
    }

    public void setInterviewTitle(String interviewTitle) {
        this.interviewTitle = interviewTitle;
    }

    public int getInterview_response() {
        return interview_response;
    }

    public void setInterview_response(int interview_response) {
        this.interview_response = interview_response;
    }

}
