package com.example.collegeapp_studentfaculty.ui.InterviewExperince;

public class InterviewExperienceModel {
    private String heading;
    private String body;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    private String batch;
    private String dept;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    private String userName;
    private String userPic;
    private String interviewExpPic;
    public InterviewExperienceModel(String heading, String body, String userPic, String noticePic, String noticeId) {
        this.heading = heading;
        this.body = body;
        this.userPic = userPic;
        this.interviewExpPic = noticePic;
        NoticeId = noticeId;
    }

    public String getInterviewExpPic() {
        return interviewExpPic;
    }

    public void setInterviewExpPic(String noticePic) {
        this.interviewExpPic = noticePic;
    }



    public InterviewExperienceModel(String heading, String body, String noticeId, String userPic) {
        this.heading = heading;
        this.body = body;
        NoticeId = noticeId;
        this.userPic = userPic;
    }
    public InterviewExperienceModel() {
    }


    public String getNoticeId() {
        return NoticeId;
    }

    public void setNoticeId(String noticeId) {
        NoticeId = noticeId;
    }

    private String NoticeId;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }


}
