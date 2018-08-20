package com.neu.edu.domain;

public class TeamInfo {

    private final String league;
    private final int standing;
    private final String nickname;
    private final String anthem;

    public TeamInfo(String league, int standing, String nickname, String anthem) {
        this.league = league;
        this.standing = standing;
        this.nickname = nickname;
        this.anthem = anthem;
    }

    public String getLeague() {
        return league;
    }

    public int getStanding() {
        return standing;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAnthem() {
        return anthem;
    }
}
