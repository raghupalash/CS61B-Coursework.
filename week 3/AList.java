public class AList {
    int[] array;
    int size;

    AList() {
        array = new int[100];
    }

    AList(int a) {
        array = new int[100];
        array[0] = a;
        size++;
    }

    AList(int[] a) {
        array = new int[100];
        System.arraycopy(a, 0, array, 0, a.length);
        size += a.length;
    }

    public int get(int i) {
        return array[i];
    }

    public int getLast() {
        return array[size - 1];
    }

    public void removeLast() {
        array[size - 1] = 0;
        size -= 1;
        if(size == array.length / 4) {
            int[] newArray = new int[size / 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public void addLast(int i) {
        if(size == array.length) {
            int[] newArray = new int[size * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = i;
        size += 1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args){
        AList list = new AList(3);
        list.addLast(1);
        list.addLast(6);
        list.addLast(75);
        System.out.print(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
