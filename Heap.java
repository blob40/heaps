public class Heap {

//the actual storage structure for your heap

private int[] arr;
public int lastThing = 0;

public Heap() {
arr = new int[100];
}

//pre condition: toAdd is not null and is an int
//post condition: toAdd is added to the heap and the heap is re-heapafied
public void add(int toAdd) {
    System.out.println("Adding " + toAdd);
         arr[lastThing] = toAdd;
         lastThing++;
         siftUp(lastThing - 1);
}

 

//remove the largest element of the heap (the root) and re-heapafy

//5 points

//pre condition: the heap is not empty
//post condition: the largest element of the heap is removed and the heap is re-heap
public void removeMax() {
    System.out.println("Removing " + arr[0]);
    arr[0] = arr[lastThing - 1];
    System.out.println("Putting " + arr[0] + " at the root");
    lastThing--;
    siftDown(0);
}

 

//this should check and alter the tree after an item is inserted

//3 points

//pre condition: index is the index of the item that was just added to the heap
//post condition: the heap is re-heapafied
private void siftUp(int index) {

    if (index == 0){
        return;
    }
    int parent = arr[(index - 1) / 2];
    int leftC = arr[((2*index) + 1)];
    int rightC = arr[((2*index) + 2)];
    int temp = arr[index];

    if (arr[index] > parent){
        System.out.println("Swapping " + arr[index] + " and " + parent);
        arr[index] = parent;
        arr[(index - 1) / 2] = temp;
        siftUp((index - 1) / 2);
    }
}

 

//this should check and alter the tree after an item is deleted.

//3 points

//pre condition: index is the index of the item that was just moved to the root of the heap
//post condition: the heap is re-heapafied
private void siftDown(int index) {
    System.out.println("Sifting down " + arr[index]);
   
    int parent = arr[(index - 1) / 2];
    int leftC = arr[((2*index) + 1)];
    int rightC = arr[((2*index) + 2)];

    if (arr[index] < leftC && leftC > rightC){
        System.out.println("Delete Swapping " + arr[index] + " and " + leftC);
        arr[index] = leftC;
        arr[((2*index) + 1)] = parent;
        siftDown(((2*index) + 1));
    } else if  (arr[index] < rightC && rightC > leftC){
        System.out.println("Delete Swapping " + arr[index] + " and " + rightC);
        arr[index] = rightC;
        arr[((2*index) + 2)] = parent;
        siftDown(((2*index) + 2));
    }
}



 

//4 points for syntax conventions.
//main method to test your heap
 public static void main(String[] args){
    int [] nums = {10, 6, 7, 1,2};
    Heap h = new Heap();
    for (int i = 0; i < nums.length; i++){
        h.add(nums[i]);
    }
    h.removeMax();
 }

}

