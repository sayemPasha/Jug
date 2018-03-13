package jug;

public class State {
    static int capacity1, capacity2, target;
    int jug1, jug2;

    public State(int jug1, int jug2) {
        // super();
        this.jug1 = jug1;
        this.jug2 = jug2;
    }

    public static void set_parameters(int cap1, int cap2, int t) {
        capacity1 = cap1;
        capacity2 = cap2;
        target = t;
    }

    State fill_1() {
        if(jug1 == capacity1)
            return  null;

        return new State(capacity1, jug2);
    }

    State fill_2() {
        if(jug2 == capacity2)
            return  null;

        return new State(jug1, capacity2);
    }

    State empty_1() {
        if(jug1 == 0)
            return  null;

        return new State(0, jug2);
    }

    State empty_2() {
        if(jug2 == 0)
            return  null;

        return new State(jug1, 0);
    }

    State transfer12() {
        if(jug1 == 0)
            return  null;

        int amount = Math.min(jug1, capacity2 - jug2);

        return new State(jug1 - amount, jug2 + amount);
    }

    State transfer21() {
        if(jug2 == 0)
            return  null;

        int amount = Math.min(jug2, capacity1 - jug1);

        return new State(jug1 + amount, jug2 - amount);
    }

    boolean goal_test() {
        return jug1 == target || jug2 == target;
    }

    public String toString() {
        return "( " + jug1 + ", " + jug2 + " )";
    }
}
