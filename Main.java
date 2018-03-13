package jug;

public class Main {
    public static void main(String[] args) {
        State.set_parameters(8, 6, 2); //cap1, cap2, target

        State initialState = new State(0, 0); //jug1, jug2
        Node solution = Node.BFS(initialState); //return the node which reached goal state

        solution.print_soln();


    }
}
