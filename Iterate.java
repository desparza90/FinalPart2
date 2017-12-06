/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2finalit;

/**
 *
 * @author despa
 */
public class Iterate<T>{
    
    private Node<T> node;
    private int num;
    private int numE;
    private Node<T> front;
    private Node<T> back;
    
    public Iterate(){
        node = new Node();
        num = 0;
        numE = 0;
    }
    
    public void add(T a){
        if(num == 0)
            {
                Node node = new Node();
                node.data = a;
                node.next = null;
                front = node;
                back = node;
                num++;
            }
            else{
                Node oldN = back;
                back = new Node();
                back.data = a;
                oldN.next = back;
                num++;
            
        
            }
    }
    
    public boolean hasNext(){
            return !(front == back);
    }
    public T next(){
        Node temp = new Node();
        T d = temp.data;
        temp.data = node.data;
        numE++;
        return d;
    }
    public void remove(){
        Node.data = null;
    }
    
}
