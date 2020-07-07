

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class MyStack {
    private ArrayList<Document> pila;
    public int size;
    
    public MyStack(){
        this.pila = new ArrayList<>();
        this.size = 0;
        
    }
    public MyStack(ArrayList<Document> pila){
        this.pila = pila;
        this.size = pila.size();
    }
    
    public void push(Document d){
        pila.add(d);
        this.size++;
    }
    
    public Document pop(){
        this.size--;
        return pila.remove(pila.size()-1);
    }
    
    public ArrayList<Document> popAll(){
        ArrayList<Document> a = new ArrayList<>();
        int n = size;
        for(int i=0; i<n; i++){
            a.add(this.pop());
        }
        return a;
    }
    
}
