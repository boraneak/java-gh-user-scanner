package com.example.githubuserscanner;

public class User {

    private int id;
    private String login;
    private int public_repos;
    private int followers;
    private int following;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNumberOfRepositories() {
        return public_repos;
    }

    public void setNumberOfRepositories(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getNumberOfFollowers() {
        return followers;
    }

    public void setNumberOfFollowers(int followers) {
        this.followers = followers;
    }

    public int getNumberOfFollowings() {
        return following;
    }
    
    public void setNumberOfFollowings(int following) {
        this.following = following;
    }
}
