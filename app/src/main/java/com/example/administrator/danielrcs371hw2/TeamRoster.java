package com.example.administrator.danielrcs371hw2;

import android.app.Activity;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;



/**
 * Created by rothschi18 on 9/19/2015.
 */
public class TeamRoster {
    protected HashMap<String, PlayerStats> teamPlayers;
    protected String teamName;
    protected ImageView teamImage;
    protected Integer resource;
    // protected HashMap<ImageButton, PlayerStats> Team;

    public TeamRoster(String teamName, Integer resource)
    {
        this.teamName=teamName;

        this.resource=resource;
        teamPlayers = new HashMap<String, PlayerStats>();

    }

    public TeamRoster(){}

    public void incrementWins()
    {
        for(String key: teamPlayers.keySet())
        {
            teamPlayers.get(key).setGamesWon(1);
        }
    }

    public void incrementGoals()
    {
        int counter = 4;
        for(String key: teamPlayers.keySet())
        {
            teamPlayers.get(key).incrementGoals(counter%2);
            counter++;

        }
    }






    public void clearPlayers(ImageButton[] buttons)
    {
        //If their are no players on the team, reset all images to blank
        if (teamPlayers.size() == 0) {
            for (int i = 0; i < 15; i++) {
                teamImage.setImageResource(R.mipmap.blankteam);
                buttons[i].setVisibility(View.INVISIBLE);

            }

        }
    }

    public PlayerStats returnPlayer(View view)
    {
        PlayerStats player = new PlayerStats();

        for(String key: teamPlayers.keySet()){
            if(view.getResources()==teamPlayers.get(key).playerImage.getResources())
            {
                player = teamPlayers.get(key);
            }
        }
        return player;
    }


    //now display the images for each player
    public void showPlayers(ImageButton[] buttons)
    {
        int counter = 0;

        for(String key: teamPlayers.keySet())
        {
            buttons[counter].setVisibility(View.VISIBLE);
            buttons[counter].setBackground(teamPlayers.get(key).playerImage.getDrawable());
            if(counter<buttons.length)
                counter++;
        }
        for(int i = counter; i<buttons.length-1; i++)
            buttons[i].setBackgroundResource(R.mipmap.blankteam);



    }

    public void showPlayers(Button[] buttons)
    {
        int counter = 0;
        for(String key: teamPlayers.keySet())
        {
            buttons[counter].setVisibility(View.VISIBLE);
            buttons[counter].setText(teamPlayers.get(key).fullName);
            if(counter<buttons.length-1)
                counter++;
        }
        for(int i = counter+1; i<buttons.length-1; i++)
            buttons[i].setBackgroundResource(R.mipmap.blankteam);
    }

    public void addPlayer(PlayerStats player)
    {
        String key = player.fullName;

        if(teamPlayers.containsKey(key))
        {
            return;
        }

        teamPlayers.put(key, player);

    }

    public String getTeamName()
    {
        return teamName;
    }

    public void addPlayerToTeam(PlayerStats player)
    {

    }
}