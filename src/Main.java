public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(10);
        myList.add(100);
        myList.add(2);
        myList.add(1);
        for(int i = 0; i<myList.size();i++)
            System.out.print(myList.get(i)+" ");
        System.out.println();
        MyArrayList.bubbleSort(myList);
        for(int i = 0; i<myList.size();i++)
            System.out.print(myList.get(i)+" ");
    }
}
