package com.example.githubuserscanner;

/**
 * Represents a GitHub user with basic profile information.
 */
public class User {

    private int id;
    private String login;
    private int public_repos;
    private int followers;
    private int following;

    /**
     * Gets the ID of the user.
     *
     * @return the user ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the user ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the login name of the user.
     *
     * @return the user's login name
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login name of the user.
     *
     * @param login the login name to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the number of public repositories for the user.
     *
     * @return the number of public repositories
     */
    public int getNumberOfRepositories() {
        return public_repos;
    }

    /**
     * Sets the number of public repositories for the user.
     *
     * @param public_repos the number of public repositories to set
     */
    public void setNumberOfRepositories(int public_repos) {
        this.public_repos = public_repos;
    }

    /**
     * Gets the number of followers of the user.
     *
     * @return the number of followers
     */
    public int getNumberOfFollowers() {
        return followers;
    }

    /**
     * Sets the number of followers for the user.
     *
     * @param followers the number of followers to set
     */
    public void setNumberOfFollowers(int followers) {
        this.followers = followers;
    }

    /**
     * Gets the number of users the user is following.
     *
     * @return the number of users being followed
     */
    public int getNumberOfFollowings() {
        return following;
    }

    /**
     * Sets the number of users the user is following.
     *
     * @param following the number of users being followed to set
     */
    public void setNumberOfFollowings(int following) {
        this.following = following;
    }
}
