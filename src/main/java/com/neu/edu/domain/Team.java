package com.neu.edu.domain;

import java.util.List;

public class Team {

    private final String id;
    private final String name;
    private final String country;
    private final TeamInfo teamInfo;
    private final List<Player> players;

    public Team(String id, String name, String country, TeamInfo teamInfo, List<Player> players) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.teamInfo = teamInfo;
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public TeamInfo getTeamInfo() {
        return teamInfo;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
