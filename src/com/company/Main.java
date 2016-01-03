package  com.company;



public class Main {
    static State initial_state = new State(3, 3, 0);
    static State final_state = new State(0, 0, 1);

    static Solver solver;

    public static void main(String[] args){
//        launch(args);

        solver = new Solver(initial_state, final_state);
        solver.solve();
        solver.display();
    }

}
