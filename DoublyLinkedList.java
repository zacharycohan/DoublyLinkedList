/**
 *
 * A data structure where nodes point to another node and so on
 */
public class DoublyLinkedList<E> {
    private Node head,tail;
    private int size;

    private static class Node<E> {
        
        Node next;
        Node prev;
        E data;
        public Node(E data) 
        {
            this.data = data;
            next = null;
            prev = null;
        }
        
        public String toString()
        {
            return ("prev: "+prev.data.toString()+",data: "+data.toString()+", next: "+next.data.toString());
            
        }
    }
    
    public DoublyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void add(E e, int index)
    {
        int i;
        Node a,b,n;
        if(index == 0)addToHead(e);
        else if(index == size-1)addToTail(e);
        else if(size-index>size/2)
        {
            i = 0;
            a = head;
            while(i != index-1)
            {
                a = a.next;
                i++;
            }
            b = a.next;
            n = new Node(e);
            n.next = b;
            b.prev = n;
            n.prev = a;
            a.next = n;
             size++;
            //System.out.println(a.data);
            
        }
        else
        {
            i = size-1;
            a = tail;
            while(i != index)
            {
                a = a.prev;
                i--;
            }
            b = a.prev;
            n = new Node(e);
            n.prev = b;
            b.next = n;
            n.next = a;
            a.prev = n;
             size++;
        } 
       
    }
    
    public boolean contains(E e)
    {
        Node ptr = head;
        while(ptr != null)
        {
            if(ptr.data.equals(e))
            {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
    
    public void addToTail(E e)
    {
        Node ptr;
        if(size == 0){
            head = new Node(e);size++;
            tail = head;
            
        }
        else{
            ptr = tail;
            tail = new Node(e);size++;
            tail.prev = ptr;
            ptr.next = tail;
            
        }
    }
    
    public void addToHead(E e)
    {
        Node ptr;
        if(size == 0){
            head = new Node(e);size++;
            tail = head;
        }
        else if(size == 1){
            ptr = head;
            head = new Node(e);size++;
            head.next = tail;
            tail.prev = head;
            
        }
        else{
            
            ptr = head;
            head = new Node(e);
            ptr.prev = head;
            head.next = ptr;
            
            
            size++;
            return;
        }       
    }
    
    public E get(int location){
        if(location>= size)return null;
        Node ptr;
        if(size-location < size/2){
            ptr = tail;
            int index;
            for(index = size-1;index!=location;index--)
            {
                ptr = ptr.prev;
            }
        }
        else{
            ptr = head;
            int index;
            for(index = 0;index!=location;index++)
            {
                ptr = ptr.next;
            }
        }
        return (E)ptr.data;
    }
    
    public E remove(int index)
    {
        if(index >= size)return null;
        int i;
        Node a,b,n = null;
        if(index == 0)return removeHead();
        else if(index == size-1)return removeTail();
        else if(size-index>size/2)
        {
            i = 0;
            a = head;
            while(i != index-1)
            {
                a = a.next;
                i++;
            }
            //System.out.println(a.data);
            b = a.next.next;
            //System.out.println(b.data);
            n = a.next;
            a.next = b;
            b.prev = a;
            //System.out.println(a.data);
            size--;
            
        }
        else
        {
            i = size-1;
            a = tail;
            while(i != index+1)
            {
                a = a.prev;
                i--;
            }
            b = a.prev.prev;
            n = a.prev;
            //System.out.println(b.data+" "+n.data+" "+a.data);
            a.prev = b;
            b.next = a;
            size--;
        }  
        return (E)n.data;
    }
    
    public E removeHead()
    {
        Node ptr = head;
        head = ptr.next;
        head.prev = null;
        size--;
        return (E)ptr.data;
    }
    
    public E getHead()
    {
        return (E)head.data;
    }
    
    public E removeTail()
    {
        Node ptr = tail;
        tail = ptr.prev;
        tail.next = null;
        size--;
        return (E)ptr.data;
    }
    
    public E getTail()
    {
        return (E)tail.data;
    }
    
    
    
    public String toString()
    {
        String s = "";
        Node ptr = head;
        while(ptr.next != null)
        {
            s += ("("+ptr.data.toString()+") -> ");
            ptr = ptr.next;
        }
        s += ("("+ptr.data.toString()+")");
        return s;
    }
    
    public static void main(String[] args){
        DoublyLinkedList<Integer> d = new DoublyLinkedList();
        d.addToTail(1);
        System.out.println(d.toString()+", size = "+d.size);
        d.addToTail(2);
        System.out.println(d.toString()+", size = "+d.size);
        d.addToHead(3);
        System.out.println(d.toString()+", size = "+d.size);
        d.addToTail(4);
        System.out.println(d.toString()+", size = "+d.size);
//        System.out.println(d.getTail());
//        System.out.println(d.getHead());
//        System.out.println(d.get(1));
//        System.out.println(d.get(3));
        d.addToTail(5);
         System.out.println(d.toString()+", size = "+d.size);
        d.addToTail(6);
         System.out.println(d.toString()+", size = "+d.size);
        d.addToTail(7);
         System.out.println(d.toString()+", size = "+d.size);
        d.addToHead(8);
         System.out.println(d.toString()+", size = "+d.size);
        d.addToHead(9);
        System.out.println(d.toString()+", size = "+d.size);
        d.add(10, 4);
        System.out.println(d.toString()+", size = "+d.size);
        d.removeHead();
       System.out.println(d.toString()+", size = "+d.size);
        d.removeTail();
        System.out.println(d.toString()+", size = "+d.size);
        d.add(13, 5);
        System.out.println(d.toString()+", size = "+d.size+" added 13");
        d.add(14, 6);
        System.out.println(d.toString()+", size = "+d.size+" added 14");
//        System.out.println(d.contains(14));
//        System.out.println(d.contains(4));
//        System.out.println(d.contains(3));
//        System.out.println(d.contains(32));
        System.out.println(d.toString()+", size = "+d.size+" no change");
        d.remove(3);
        System.out.println(d.toString()+", size = "+d.size+" removed index 3");        
        d.remove(8);
        System.out.println(d.toString()+", size = "+d.size+" removed index 8");        
        
        
    }
    
}
