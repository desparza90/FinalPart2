package finalpart2;

import java.util.Iterator;

/*************************************************************************
  Winter 2017 CS 240 Programming Exam : Person

 Author: Daniel Esparza      

 Dependencies: Stack, Queue, Dictionary

 Description:  Models a person, a list of messages that they can
               read, and a list of their friends, so that when you
               post a message, all your friends can read it too.

**************************************************************************/

public class Person { 
    private String name;
    private DictionaryHashTable fl;
    private NodeStack msg;
    private NodeStack msg2;
    private NodeStack msg3;
    private int friendsize = 0;
    private Person p;


    // Create a new Person with this name.
    public Person(String name) {
        this.name = name;
        fl = new DictionaryHashTable();
        msg = new NodeStack();
        msg2 = new NodeStack();
        msg3 = new NodeStack();
        
    }

    // Make these two people become friends with each other.
    // Throw an exception if you try to meet yourself.
    // We are allowed to assume we didn't meet this person yet.
    public void meet(Person otherPerson) {
        if(otherPerson == this)
        {
            throw new RuntimeException();
        }
        fl.add(friendsize++, otherPerson);
        otherPerson.fl.add(otherPerson.friendsize++, this);
    }

    // Are these two people friends?
    // Throw an exception if you ask about knowing yourself.
    public boolean knows(Person otherPerson) {
        if(otherPerson == this)
        {
            throw new RuntimeException();
        }
        for(int i = 0; i <= friendsize; i++){
            if(otherPerson == fl.getValue(i))
                return true;
        }
        return false;
    }

    // Post a message to my list and the lists of all my friends
    public void post(String message) {
        msg.push(message);
        msg2.push(message);
        Iterator<Person> friend = fl.getValueIterator();
        while(friend.hasNext()){
            Person p = friend.next();
            p.msg.push(message);
            p.msg2.push(message);
        }
    }

    // Print a header, then all messages this Person can read, newest first
    public void listMessages() {
        System.out.println("== The wall of " + this.name + " ==");
        System.out.println(msg.pop());
        while(!msg2.isEmpty())
        {
            msg3.push(msg2.pop());
        }
        while(!msg3.isEmpty())
        {
            String mes = (String) msg3.pop();
            msg.push(mes);
            msg2.push(mes);
        }
    }
}