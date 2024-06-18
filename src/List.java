import java.util.Scanner;

public class List {
    private ListNode first;
    private int size;

    public List() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index, int size) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("index=" + index + " size=" + size);
        }
    }

    public int get(int index) {
        checkIndex(index, size);
        ListNode p = first;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.data;
    }

    public int set(int index, int item) {
        checkIndex(index, size);
        ListNode p = first;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        int value = p.data;
        p.data = item;
        return value;
    }

    public void addFirst(int item) {
        ListNode temp = new ListNode(item);
        first.next = first;
        first = temp;
        size++;
    }

    public void addLast(int item) {
        ListNode temp = new ListNode(item);
        if (first == null) {
            first = temp;
        } else {
            ListNode p = first;
            while (p.next != null) {
                p = p.next;
            }
            p.next = temp;
        }
        size++;
    }

    public void add(int item) {
        addLast(item);
    }

    public void add(int index, int item) {
        checkIndex(index, size);
        ListNode temp = new ListNode(item);
        if (index == 0) {
            first.next = first;
            first = temp;
        } else {
            ListNode p = first;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            temp.next = p.next;
            p.next = temp;
        }
        size++;
    }

    public static List readList() {
        List list = new List();
        java.util.Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer number, negative or zero to quit: ");
        int n = input.nextInt();
        while (n > 0) {
            list.add(n);
            System.out.print("Enter an integer number, negative or zero to quit: ");
            n = input.nextInt();
        }
        return list;
    }

    public static List createList(int... args) {
        List lst = new List();
        for (int i = 0; i < args.length; i++) {
            lst.add(args[i]);
        }
        return lst;
    }

    public int removeFirst() {
        if (first == null) {
            throw new EmptyListException("list is empty");
        }
        int value = first.data;
        first = first.next;
        size--;
        return value;
    }

    public int removeLast() {
        if (first == null) {
            throw new EmptyListException("list is empty");
        }
        int item;
        if (first.next == null) {
            item = first.data;
            first = null;
        } else {
            ListNode p = first;
            while (p.next.next != null) {
                p = p.next;
            }
            item = p.next.data;
            p.next = null;
        }
        size--;
        return item;
    }


    public int remove(int index) {
        checkIndex(index, size);
        if (first == null) {
            throw new EmptyListException("list is empty");
        }
        if (index == 0) {
            return removeFirst();
        }
        ListNode p = first;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        int item = p.next.data;
        p.next = p.next.next;
        size--;
        return item;
    }

    public void printList() {
        ListNode p = first;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public void recursivePrintList() {
        printList(first);
    }

    private void printList(ListNode p) {
        if (p != null) {
            System.out.println(p.data);
            printList(p.next);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        ListNode p = first;
        while (p != null) {
            s.append(p.data);
            if (p.next != null) {
                s.append(", ");
            }
            p = p.next;
        }
        s.append("]");
        return s.toString();
    }

    public boolean contains(int item) {
        ListNode p = first;
        while (p != null) {
            if (p.data == item) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public int indexOf(int item) {
        ListNode p = first;
        int currIndex = 0;
        while (p != null) {
            if (p.data == item) {
                return currIndex;
            }
            p = p.next;
            currIndex++;
        }
        return -1;
    }

    public void concat(List other) {
        if (other.first == null) {
            return;
        }
        ListNode p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = other.first;
        size += other.size();
    }

    public List invertList() {
        ListNode p = first;
        ListNode q = null;
        ListNode r;
        while (p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        first = q;
        return this;
    }

    private int sum(ListNode p) {
        if (p == null) {
            return 0;
        }
        return p.data + sum(p.next);
    }

    public int sum() {
        return sum(first);
    }

    public int delete(int item) {
        if (first == null) {
            throw new EmptyListException("list is empty");
        }
        int prevItem;
        if (first.data == item) {
            prevItem = first.data;
            first = first.next;
            size--;
            return prevItem;
        }
        ListNode p = first;
        while (p.next != null) {
            if (p.next.data == item) {
                prevItem = p.next.data;
                p.next = p.next.next;
                size--;
                return prevItem;
            }
            p = p.next;
        }
        return -1;
    }

    public int removeALl(int item) {
        if (first == null) {
            throw new EmptyListException("list is empty");
        }
        int counter = 0;
        if (first.data == item) {
            first = first.next;
            counter++;
        }
        ListNode p = first;
        while (p != null && p.next != null) {
            if (p.next.data == item) {
                p.next = p.next.next;
                counter++;
            } else {
                p = p.next;
            }
        }
        size -= counter;
        return counter == 0 ? -1 : counter;
    }

    public int total() {
        if (first == null) return 0;
        int counter = 0;
        ListNode p = first;
        while (p != null) {
            counter++;
            p = p.next;
        }
        return counter;
    }

    public boolean equals(List other) {
        if (this.size != other.size) return false;

        ListNode p = this.first;
        ListNode q = other.first;
        while (p != null) {
            if (p.data != q.data) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
