public class ArrayList<T> implements List<T>
{
    T[] arr;
    int size;

    public ArrayList()
    {
        arr = (T[]) new Object[10];
        size = 0;
    }

    public void add(T item)
    {
        if(size == arr.length)
        {
            growArray();
        }

        arr[size++] = item;
    }

    public void add(int pos, T item)
    {
        if(pos < 0 || pos > size)
        {
            System.out.println("[The position is out of bounds]");
        }
        else
        {
            if(size == arr.length)
            {
                growArray();
            }
//          Shifts the array after the position to the right
            for(int i = size; i > pos; i--)
            {
                arr[i] = arr[i - 1];
            }

            arr[pos] = item;
            size++;
        }
    }

    public T get(int pos)
    {
        if(pos < 0 || pos >= size)
        {
            System.out.println("[The position is out of bounds]");
            return null;
        }

        return arr[pos];
    }

    public T remove(int pos)
    {
        if(pos < 0 || pos >= size)
        {
            System.out.println("[The position is out of bounds]");
            return null;
        }
//      Saves the value of the removed item
        T delt = arr[pos];
//      Shifts the remainder of the array to the left
        for(int i = pos; i < size - 1; i++)
        {
            arr[i] = arr[i + 1];
        }

        size--;
        return delt;
    }

    public int size()
    {
        return size;
    }

    private void growArray()
    {
        T[] copy = (T[]) new Object[arr.length * 2];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        arr = copy;
    }

    public String toString()
    {
        String list = "[";
        for(int i = 0; i < size; i++)
        {
            list += arr[i];
            if(i != size - 1)
            {
                list += ", ";
            }
        }
        return list + "]";
    }
}
