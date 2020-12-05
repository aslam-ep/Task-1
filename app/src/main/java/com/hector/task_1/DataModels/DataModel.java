package com.hector.task_1.DataModels;

public class DataModel {
    public String repository_url, state;
    public long id;
    public UserDataModel user;

    public DataModel(){
    }

    public DataModel(String repository_url, String state, long id, UserDataModel user) {
        this.repository_url = repository_url;
        this.state = state;
        this.id = id;
        this.user = user;
    }
}
