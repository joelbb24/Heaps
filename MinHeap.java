import java.lang.*;

public class MinHeap
{
    int[] arr;
    int size;
    int capacity;

    MinHeap(int c)
    {
        arr = new int[c];
        size = 0;
        capacity = c;
    }

    int left(int i) { return (2*i+1);}
    int right(int i) {return (2*i+2);}
    int parent(int i) {return (i-1)/2;}
    
    void insert(int elem)
    {
        if(size==capacity) return;
        size++;
        arr[size-1] = elem;
        for(int i= size -1; i != 0 && arr[parent(i)]>arr[i];i--)
        {
            swap(arr[i], arr[parent(i)]);
            i = parent(i);
        }
    }

    void heapify(int i)
    {
        int lt = left(i), rt = right(i);
        int smallest = i;
        if(lt<size && arr[lt] < arr[i])
            smallest = lt;
        if(rt<size && arr[rt]<arr[smallest])
            smallest = rt;
        if(smallest !=i)
        {
            swap(arr[i], arr[smallest]);
            heapify(smallest);
        }
    }

    void swap(int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    int extractMin()
    {
        if(size==0)
            return Integer.MAX_VALUE;

        if(size == 1)
        {
            size--;
            return arr[0];
        }

        swap(arr[0], arr[size - 1]);
        size--;
        heapify(0);
        return arr[size];
    }
    
    public static void main(String [] args)
    {
        MinHeap h = new MinHeap(11);
        h.insert(3);
        h.insert(1);
        h.insert(15);
        h.insert(20);
        System.out.println(h.extractMin());
    }
}
