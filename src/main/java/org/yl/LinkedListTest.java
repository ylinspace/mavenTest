package org.yl;

/**
 * Created by yang on 2017/2/21.
 */
public class LinkedListTest {

    static class Node{
        Object data;
        Node next;
        public Node(Object data){
            this.data = data;
        }
    }

    public static Node reverse(Node head){
        Node front = null;
        Node next = null;
        Node tmp = head;

        while(tmp != null){
            next = tmp.next;
            tmp.next = front;

            front = tmp;
            tmp = next;
        }

        return front;
    }

    public static void main(String [] args){

        Node head = new Node("节点"+0);
        Node tmp = head;

        for(int i = 1;i< 10;i++){
            tmp.next = new Node("节点"+i);
            tmp = tmp.next;
        }

        Node node = head;
        while(node !=null){
            System.out.println(node.data);
            node = node.next;
        }

        Node newNode = reverse(head);
        System.out.println("逆转后的链表");
        tmp = newNode;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}
