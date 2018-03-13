package jug;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    State state;
    Node parent;
    int pathCost;

    public Node(State state, Node parent, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.pathCost = pathCost;
    }


    public static Node BFS(State initial)
    {
        Queue<Node> Q = new LinkedList<Node>();

        Q.add(new Node(initial, null, 0));

        while(!Q.isEmpty())
        {
            Node front = Q.poll();

            //System.out.println(front.state);

            if(front.state.goal_test())
                return front;

            State successor;

            successor = front.state.empty_1();
            if(successor != null)
                Q.add(new Node(successor, front, front.pathCost + 1));

            successor = front.state.empty_2();
            if(successor != null)
                Q.add(new Node(successor, front, front.pathCost + 1));

            successor = front.state.fill_1();
            if(successor != null)
                Q.add(new Node(successor, front, front.pathCost + 1));

            successor = front.state.fill_2();
            if(successor != null)
                Q.add(new Node(successor, front, front.pathCost + 1));

            successor = front.state.transfer12();
            if(successor != null)
                Q.add(new Node(successor, front, front.pathCost + 1));

            successor = front.state.transfer21();
            if(successor != null)
                Q.add(new Node(successor, front, front.pathCost + 1));
        }

        return null;
    }

    public  void print_soln()
    {
        Node temp = parent;
        System.out.println(state);

        while(temp.parent != null){
            System.out.println(temp.state);
            temp = temp.parent;
        }
        System.out.println(temp.state);

    }

}
