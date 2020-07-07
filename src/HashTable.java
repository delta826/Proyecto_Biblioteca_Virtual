

import java.util.*;

/**
 *
 * @author Lenovo
 */
public class HashTable {
    
    private ArrayList<User> table[];
    private final int TAM = 30;
    
    public HashTable(){
        this.table = new ArrayList[TAM];
        for(int i=0; i<TAM; i++){
            this.table[i] = new ArrayList<>();
        }
    }
    
    public int HashFunction(String username){
        char[] parts = username.toCharArray();
        int key=0;
        for(int i=0;i<parts.length; i++){
            key = key + (int)parts[i];
        }
        key = ((key*34+2)%(TAM*3))/3;
        return key;
    }

    public void insert(User usuario){
        int key = HashFunction(usuario.username);
        this.table[key].add(usuario);
    }
    
    public User find(User usuario){
        int key = HashFunction(usuario.username);
        ArrayList<User> a = this.table[key];
        for(int i=0; i<a.size(); i++){
            if(a.get(i).username.equalsIgnoreCase(usuario.username)){
                if(a.get(i).password.equals(usuario.password))
                    return a.get(i);
                else
                    return null;
            }
        }
        return null;
    }
    
    public boolean findUser(String username){
        int key = HashFunction(username);
        ArrayList<User> a = this.table[key];
        for(int i=0; i<a.size(); i++){
            if(a.get(i).username.equalsIgnoreCase(username)){
                return true;
            }
        }
        return false;
    }
    
}
