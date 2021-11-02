package org.ict.replyprj.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReplyList {

    @SerializedName("example")
    @Expose
    private List<Example> example;

    public List<Example> getExample(){
        return example;
    }

    public void setExample(List<Example> example){
        this.example = example;
    }
}
