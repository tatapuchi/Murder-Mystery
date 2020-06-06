package com.mygdx.game.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DialogueList {



    public DialogueList(){
        //Ethan First dialogue


    }

    public static ArrayList getEthanDialogue1() {
        ArrayList<String> EthanDialogue1 = new ArrayList<String>();
        EthanDialogue1.add("Hi there, My name is Ethan, what brings you to this unsuspicious and" +
                "completly normal train?");
        EthanDialogue1.add("On my way to a hackathon");
        EthanDialogue1.add("Great, So am I! I've been looking for a team member!");
        EthanDialogue1.add("Care to join the team?");
        EthanDialogue1.add("Only if we name ourselves the eggz");
        EthanDialogue1.add("Yas!");
        return EthanDialogue1;
    }
}
