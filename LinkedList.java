public class LinkedList<T> implements List<T>
{
    int size;
    Node head;

    public LinkedList()
    {
        size = 0;
        head = new Node();
    }

    public class Node
    {
        T data;
        Node next;

        public void setData(T item)
        {
            data = item;
        }
//      tsugi is "next" in Japanese
        public void setNext(Node tsugi)
        {
            next = tsugi;
        }

        public T getData()
        {
            return data;
        }

        public Node getNext()
        {
            return next;
        }
    }

    public void add(T item)
    {
        if(size == 0)
        {
            head.setData(item);
        }
        else
        {
            Node next = new Node();
            next.setData(item);
            Node previous = head;
            while(previous.getNext() != null)
            {
                previous = previous.getNext();
            }

            previous.setNext(next);
        }

        size++;
    }

    public void add(int pos, T item)
    {
        if(pos < 0 || pos > size)
        {
            System.out.println("[That position is out of bounds]");
        }
        else
        {
            Node next = new Node();
            next.setData(item);

            if(pos == 0)
            {
                next.setNext(head);
                head = next;
            }
            else
            {
                Node previous = head;
                for(int i = 0; i < pos - 1; i++)
                {
                    previous = previous.getNext();
                }

                next.setNext(previous.getNext());
                previous.setNext(next);
            }

            size++;
        }
    }

    public T get(int pos)
    {
        if(pos < 0 || pos > size)
        {
            System.out.println("[That position is out of bounds]");
            return null;
        }

        Node current = head;
        for(int i = 0; i < pos; i++)
        {
            current = current.getNext();
        }


        return current.getData();
    }

    public T remove(int pos)
    {
        if(pos < 0 || pos > size)
        {
            System.out.println("[That position is out of bounds]");
            return null;
        }

        Node delt = head;
        if(pos == 0)
        {
            head = head.getNext();
        }
        else
        {
            Node previous = head;
            for(int i = 0; i < pos - 1; i++)
            {
                previous = previous.getNext();
            }

            delt = previous.getNext();
            previous.setNext(delt.getNext());
        }

        size--;
        return delt.getData();
    }

    public int size()
    {
        return size;
    }

    public String toString()
    {
        String list = "[";
        Node current = head;
        for(int i = 0; i < size; i++)
        {
            list += current.getData();
            if(i != size - 1)
            {
                list += ", ";
            }
            current = current.getNext();
        }
        return list + "]";
    }
}
