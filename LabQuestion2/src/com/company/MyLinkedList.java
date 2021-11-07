package com.company;

public class MyLinkedList {
    Node head;
    Node tail;

    public MyLinkedList(){
        head = null;
        tail = null;
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(isNotNull()){
            //dolu anlamında
            tail.next = newNode;
            tail = newNode;

        }else{
            //boş anlamında
            head = newNode;
            tail = newNode;
        }
    }

    public void delete(int data){
        if (isNotNull()){
            if (head == tail){
                if (head.data == data){
                    head = null;
                    tail = null;
                }
            }
            else {
                Node pointer1 = null;
                Node pointer2 = head;
                while (pointer2 !=null){
                    if (pointer2.data == data){
                        if (head == pointer2){
                            //sadece baştakiyse sil
                            head = pointer2.next;
                            pointer2.next = null;
                            pointer2 = head;
                        }
                        else{
                            //sadece sondakiyse sil
                            if (pointer2 == tail){
                                tail=pointer1;
                                pointer1.next = null;
                                pointer2 = null;
                            }
                            //sadece ortadakiyse sil
                            else {
                                Node pointer3 = pointer2.next;
                                pointer2.next = null;
                                pointer1.next = pointer3;
                                pointer2 = pointer3;
                            }
                        }
                    }
                    else {
                        //Elaman silinmiyorsa güncelle
                        pointer1 = pointer2;
                        pointer2 = pointer2.next;
                    }
                }

            }
        }
    }

    public void addAt(int data,int position){
        Node newNode = new Node(2);
        if (isNotNull()){
            if (position == 0){
                newNode.next = head;
                head = newNode;
            }
            else {
                Node pointer1 = null;
                Node pointer2 = head;
                int index = 0;
                while (pointer2 != null && index<position){
                    pointer1 = pointer2;
                    pointer2 = pointer2.next;
                    index++;
                }
                if (pointer2 == null){
                    tail.next = newNode;
                    tail = newNode;
                }
                else{
                    newNode.next = pointer2;
                    pointer1.next = newNode;
                }
            }

        }
        else {
            head = newNode;
            tail = newNode;
        }


    }

    public void printList(){
        Node pointer = head;

        while (pointer != null){
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }


    public boolean isNotNull(){
        if(head != null){
            return true;
        }else{
            return false;
        }
    }
}
