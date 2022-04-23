/* Week 2 study guide - A Level exersises
Q1. Osmosis - addAdjacent()
Q2. addSquare()
*/

public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if(rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    public void addAdjacent() {
        // For each node, checks if the next node is same as
        // the current node, if yes then double the current node
        // and make it point to next's next element.
        // Repeat until no additions happened.

        boolean noAdds = false;
        while (!noAdds) {
            IntList p = this;
            noAdds = true;
            while (p.rest != null) {
                if(p.first == p.rest.first) {
                    p.first *= 2;
                    p.rest = p.rest.rest;
                    noAdds = false;
                }
                p = p.rest;
            }
        }
    }


    public void addSquare(int n) {
        // Squares the list with each addition.

        // // iterative
        // int size = this.size();
        // IntList curr = this;
        // for(int i = 0; i < size; i++) {
        //     if(curr.rest == null) {
        //         curr.rest = new IntList(n, null);
        //     }
        //     curr.rest = new IntList(curr.first * curr.first, curr.rest);
        //     curr = curr.rest.rest;
        // }

        // base case
        if(rest == null) {
            IntList newNode = new IntList(n, null);
            rest = new IntList(first * first, newNode);
            return;
        }
        rest = new IntList(first * first, rest);
        rest.rest.addSquare(n);
    }

    public void printList() {
        // print list starting from current node
        IntList p = this;
        while(p != null) {
            System.out.print(p.first + " -> ");
            p = p.rest;
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(2, null);
        L = new IntList(1, L);
        L.addSquare(5);
        L.printList();
    }
}