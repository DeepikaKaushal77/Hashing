/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashnlinkedlist;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class HashnLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Linked List
//        LinkedNode head=new LinkedNode();
//        LinkedNode.AddNode(head, 10);
//        LinkedNode.AddNode(head, 20);
//        LinkedNode.AddNode(head, 30);
//        LinkedNode.AddAfter(head,20,40);
//        LinkedNode.Delete(head, 10);
//        LinkedNode.PrintAll(head);
        
        //Hashing
        new Hashing(10);
        //linear probing
        Hashing.InsertLinearProb(20);
        Hashing.InsertLinearProb(2);
        Hashing.InsertLinearProb(12);
        Hashing.InsertLinearProb(15);
        Hashing.InsertLinearProb(13);
        Hashing.InsertLinearProb(3);
        Hashing.InsertLinearProb(23);
        Hashing.InsertLinearProb(11);
        Hashing.InsertLinearProb(14);
        Hashing.InsertLinearProb(1);
        Hashing.ShowHash();
        Hashing.DeleteLP(14);
        Hashing.ShowHash();
        //Separate chaining
//        Hashing.InsertSeparateChain(12);
//        Hashing.InsertSeparateChain(13);
//        Hashing.InsertSeparateChain(2);
//        Hashing.InsertSeparateChain(10);
//        Hashing.InsertSeparateChain(20);
//        Hashing.InsertSeparateChain(40);
//        Hashing.ShowHash();
    }
    public static class LinkedNode{
        public Integer data;
        public LinkedNode next;

        public LinkedNode() {
            this.data=null;
            this.next=null;
        }
        public LinkedNode(int data){
            this.data=data;
            this.next=null;
        }
        
        public static void AddNode(LinkedNode head, int data){
            LinkedNode node=new LinkedNode( data);
            if(head.data==null)
                head.data=data;
            else{
                while(head.next!=null)
                    head=head.next;
                head.next=node;
            }
        }
        public static void AddAfter(LinkedNode head,int after,int data){
            LinkedNode node=new LinkedNode( data);
            while(head.data!=after && head.next!=null)
                head=head.next;
            if(head.data==after) {
                if(head.next==null)
                    head.next=node;
                else{
                    node.data=head.next.data;
                    node.next=head.next.next;
                    head.next.data=data;
                    head.next.next=node;
                }
            }
            else if(head.data!=after && head.next==null){
                System.out.println("no element " +after+ " found");
                       
            }
        }
        
        public static void PrintAll(LinkedNode head){
            while(head!=null){
                System.out.println(head.data);
                head=head.next;
            }
                
        }
        
        public static void Delete(LinkedNode head,int data){
            if(head.data==data){
                head.data=head.next.data;
                head.next=head.next.next;
            }
            else{
                while(head.next.data!=data && head.next.next!=null)
                head=head.next;
            if(head.next.next==null && head.next.data!=data)
                System.out.println("No data found..");
            else if(head.next.data==data){
                if(head.next.next==null)
                    head.next=null;
                else{
                    head.next=head.next.next;
                }
            }
            }   
            
                
        }
    }
    public static class Hashing{
        public static ArrayList<Integer> Hash;
        public static ArrayList<LinkedNode> HashLl;
        public static int size;
         
        public Hashing(int size){
            Hash=new ArrayList<Integer>(size);
            HashLl=new ArrayList<LinkedNode>(size);
            this.size=size;
            for(int i=0;i<size;i++){
                Hash.add(null);
                HashLl.add(null);
            }
        }
        
        public static void InsertLinearProb(int val){
            int Index=val%size;
            while(Hash.get(Index)!=null)
            {
                if(Index<size-1)
                    Index++;
                else
                    Index=0;
            }
            Hash.set(Index, val);
        }
        
        public static void DeleteLP(int val){
            int Index=val%size;
            while(Hash.get(Index)!=val){
                if(Index<size-1)
                    Index++;
                else
                    Index=0;
            }
            Hash.set(Index, null);
        }
        
        public static void InsertSeparateChain(int val){
            int Index=val%size;
            LinkedNode head=new LinkedNode(val);
            
            if(HashLl.get(Index)==null)
                HashLl.set(Index,head);
            else{
                HashLl.get(Index).AddNode(HashLl.get(Index), val);
//                while(HashLl.get(Index).next!=null){
//                    HashLl.get(Index).next=HashLl.get(Index).next.next;
//                }
//                HashLl.get(Index).next=head;
            }
        }
        public static void ShowHash(){
            for(int i=0;i<size;i++){
                System.out.println(Hash.get(i));
//                while(HashLl.get(i)!=null){
//                    System.out.println(HashLl.get(i).data);
//                    HashLl.set(i,HashLl.get(i).next);
//                }
            }
                
            
        }
        
    }
    
    
    
}
