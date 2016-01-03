package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Hp on 12/30/2015.
 */
public class Solver {
    State initial_state;
    State final_state;
//    List<State> states = new ArrayList<State>();
//    List<State> states = new ArrayList<State>();


    LinkedList<State> states = new LinkedList<State>();  // nahereko
    LinkedList<State> ref_states = new LinkedList<State>();  // nahereko

    State current_state;


    Solver (State initial_state, State final_state) {
        this.initial_state= initial_state;
        this.final_state = final_state;
        states.add(initial_state);
    }

    void solve() {
        boolean found = false;
        while (!states.isEmpty() && found == false) {
            current_state = states.remove();

            current_state.display();
            if (current_state.is_equal(final_state)) {
                System.out.println("FOUND");
                display_answer();
            }

            move(1, 0);
            move(2, 0);
            move(0, 1);
            move(0, 2);
            move(1, 1);
            ref_states.add(current_state);
        }

        //current_state.display();
    }

    private void move(int move_missionaries, int move_cannibals) {
        int new_cannibals, new_missionaries, other_cannibals, other_missionaries;

        if (current_state.boat == 0) {
            new_missionaries = current_state.missionaries - move_missionaries;
            new_cannibals = current_state.cannibals - move_cannibals;
        } else {
            new_missionaries = current_state.missionaries + move_missionaries;
            new_cannibals = current_state.cannibals + move_cannibals;
        }

        other_cannibals = initial_state.cannibals - new_cannibals;
        other_missionaries = initial_state.missionaries - new_missionaries;

        if (new_missionaries >= 0 && new_cannibals >= 0 && new_cannibals <= initial_state.cannibals && new_missionaries <= initial_state.missionaries &&
        (new_cannibals <= new_missionaries || new_missionaries == 0) && (other_cannibals <= other_missionaries || other_missionaries == 0)) {
            State next_state = new State(new_missionaries, new_cannibals, (current_state.boat + 1) % 2);

            current_state.children.add(next_state);
            next_state.parent = current_state;
            if (!has_state(next_state)) {
                states.add(next_state);
            }
        }

    }

    private boolean has_state(State state) {
        for (int i = 0; i < states.size(); i++) {
            if (state.is_equal(states.get(i))) {
                return true;
            }
        }
        for (int i = 0; i < ref_states.size(); i++) {
            if (state.is_equal(ref_states.get(i))) {
                return true;
            }
        }
        return false;
    }

    void display() {

    }

    void display_answer() {
        State current = current_state;
        System.out.println("-------------------");
        do {
            current.display();
            current = current.parent;
        } while (current != null);
        System.out.println("-------------------");
    }
}
