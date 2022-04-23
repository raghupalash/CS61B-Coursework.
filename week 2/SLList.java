public class SLList {
    private static class IntNode {
        private int item;
        private IntNode next;
        IntNode(int x, IntNode n) {
            item = x;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList ok = new SLList(10);
        ok.addFirst(11);
        ok.addFirst(13);
        System.out.println(ok.getFirst());
    }
}