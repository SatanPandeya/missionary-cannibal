package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 12/30/2015.
 */
public class State {
    int missionaries;
    int cannibals;
    int boat;

    State parent;
    List <State> children = new ArrayList<State>();
//    List<xClass> mysclass = new ArrayList<xClass>();
//    myclass.add(new xClass());
//    myclass.add(new xClass());
//    mainList.get(3);

    State(int missionaries, int cannibals, int boat){
        this.missionaries = missionaries;
        this.cannibals = cannibals;
        this.boat = boat;
    }

    void display() {
        System.out.println(missionaries + " " + cannibals + " " + boat);
    }

    boolean is_equal(State state) {
        if (state.missionaries == missionaries && state.cannibals == cannibals && state.boat == boat) {
            return true;
        } else {
            return false;
        }
    }
}
