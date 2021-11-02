package org.ict.replyprj.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("rno")
    @Expose
    private Integer rno;
    @SerializedName("bno")
    @Expose
    private Integer bno;
    @SerializedName("reply")
    @Expose
    private String reply;
    @SerializedName("replyer")
    @Expose
    private String replyer;
    @SerializedName("replydate")
    @Expose
    private Long replydate;
    @SerializedName("updatedate")
    @Expose
    private Long updatedate;

    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getReplyer() {
        return replyer;
    }

    public void setReplyer(String replyer) {
        this.replyer = replyer;
    }

    public Long getReplydate() {
        return replydate;
    }

    public void setReplydate(Long replydate) {
        this.replydate = replydate;
    }

    public Long getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Long updatedate) {
        this.updatedate = updatedate;
    }

}
