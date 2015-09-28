package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;


public class EditTeam extends ActionBarActivity {

    public Button[] teamButtons;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);
        teamButtons = new Button[15];
        teamButtons[0]=(Button)this.findViewById(R.id.EditTeam1);
        teamButtons[1]=(Button)this.findViewById(R.id.EditTeam2);
        teamButtons[2]=(Button)this.findViewById(R.id.EditTeam3);
        teamButtons[3]=(Button)this.findViewById(R.id.EditTeam4);
        teamButtons[4]=(Button)this.findViewById(R.id.EditTeam5);
        teamButtons[5]=(Button)this.findViewById(R.id.EditTeam6);
        teamButtons[6]=(Button)this.findViewById(R.id.EditTeam7);
        teamButtons[7]=(Button)this.findViewById(R.id.EditTeam8);
        teamButtons[8]=(Button)this.findViewById(R.id.EditTeam9);
        teamButtons[9]=(Button)this.findViewById(R.id.EditTeam10);
        teamButtons[10]=(Button)this.findViewById(R.id.EditTeam11);
        teamButtons[11]=(Button)this.findViewById(R.id.EditTeam12);
        teamButtons[12]=(Button)this.findViewById(R.id.EditTeam13);
        teamButtons[13]=(Button)this.findViewById(R.id.EditTeam14);
        teamButtons[14]=(Button)this.findViewById(R.id.EditTeam15);
        MainActivity.TeamData.viewTeams(this, teamButtons);





    }
    /*
    * Method: createPlayer
    * Purpose: Recieves input from text fields on the screen and creates a player with the given values
     */
    public void createPlayer(View view)
    {
        Integer[] playerImages = {R.mipmap.player1, R.mipmap.player2, R.mipmap.player3, R.mipmap.player4, R.mipmap.player5, R.mipmap.player6,
                                 R.mipmap.player7, R.mipmap.player8, R.mipmap.player9, R.mipmap.player10};
        ImageButton[] imageButtons = {(ImageButton)this.findViewById(R.id.playerImage1),
                (ImageButton)this.findViewById(R.id.playerImage2),
                (ImageButton)this.findViewById(R.id.playerImage3),
                (ImageButton)this.findViewById(R.id.playerImage4),
                (ImageButton)this.findViewById(R.id.playerImage5),
                (ImageButton)this.findViewById(R.id.playerImage6),
                (ImageButton)this.findViewById(R.id.playerImage7),
                (ImageButton)this.findViewById(R.id.playerImage8),
                (ImageButton)this.findViewById(R.id.playerImage9),
                (ImageButton)this.findViewById(R.id.playerImage10)};
        int counter = 0;
        for(int i  = 0; i<10; i++) {
            if (imageButtons[i].getId() == view.getId())
            {
                counter = i;
                Log.i("SETTING IMAGE", "SETTING IMAGE" +""+i+" : "+counter);

            }

        }




        //find all the edit text fields within the edit team view
        EditText firstName = (EditText)this.findViewById(R.id.firstName);
        EditText lastName  = (EditText)this.findViewById(R.id.newLastName);
        EditText teamName  = (EditText)this.findViewById(R.id.teamName);
        EditText strength = (EditText)this.findViewById(R.id.strength);
        String key = firstName + " " + lastName;
        ImageView playerImage = new ImageView(this);
        playerImage.setImageResource(playerImages[counter]);

        PlayerStats newPlayer = new PlayerStats(0, Integer.parseInt(strength.getText().toString()), 0, firstName.getText().toString(), lastName.getText().toString(), playerImage, teamName.getText().toString());
        for(String team: MainActivity.TeamData.rosterDatabase.keySet())
        {

            if(team.equals(teamName.getText().toString()))
            {
                Log.i("MATCHING TEAMS", "");
                MainActivity.TeamData.rosterDatabase.get(team).addPlayer(newPlayer);
            }
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_team, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
