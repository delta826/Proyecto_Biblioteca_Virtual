
import java.util.*;

public class AVLTree {
    Node root;

    public AVLTree() {
        this.root = null;
    }
    
   
    private Boolean isBalanced(Node root){
        if (root==null)
            return true;
        if(balanceFactor(root)>1)
            return false;
        if(isBalanced(root.left))
            return isBalanced(root.right);
        return false;
    }
    public Boolean isBalanced(){
        return isBalanced(this.root);
    }
    private int balanceFactor(Node node){
        int b=0;
        if(node==null){
            b = 0;
        }else if(node.left !=null && node.right!=null){
            b = node.left.ht - node.right.ht;
        }else if(node.left==null && node.right!=null){
            b = -1 - node.right.ht;
        }else if(node.left!=null && node.right==null){
            b = node.left.ht + 1;
        }else if(node.left==null && node.right==null){
            b=0;
        }
        return Math.abs(b);
    }
    
    private int height(Node node){
        if(node==null) return 0;
        int height=0;
        if(node.left!=null || node.right!=null){
            if(node.left!=null){
                height=Math.max(height,height(node.left));
            }
            if(node.right!=null){
                height=Math.max(height,height(node.right));
            }
            height++;
        }
        node.ht=height;
        return height;
    }

    private Node rotateRight(Node root){
        Node fall=root.left.right;
        Node aux=root;
        //aux.left=null;
        root.left.right=aux;
        root=root.left;
        //if(fall!=null){
            root.right.left=fall;
        //}
        return root;
    }

    private Node rotateLeft(Node root){
        Node fall=root.right.left;
        Node aux=root;
        root.right.left = aux;
        root=root.right;
        root.left.right=fall;
        return root;
    }

    private Node rebalanceRight(Node root){
        Node left=root.left;
        if(left.left!=null&&left.right!=null){ //Si el izquierdo tiene dos hijos
            if(left.left.ht<left.right.ht){
                root.left=rotateLeft(root.left);
            }
        }else if(left.left==null&&left.right!=null){ //Si solo tiene hijo derecho
            root.left=rotateLeft(root.left);
        }
        root=rotateRight(root);
        return root;
    }

    private Node rebalanceLeft(Node root){
        Node right=root.right;
        if(right.left!=null&&right.right!=null){ //Si el derecho tiene dos hijos
            if(right.left.ht>right.right.ht){
                root.right=rotateRight(right);
            }    
        }else if(right.left!=null&&right.right==null){ //Si solo tiene hijo izquierdo
            root.right=rotateRight(right);
        }
        root=rotateLeft(root);
        return root;
    }

    private Node rebalance(Node root){
        if(balanceFactor(root)>1){
            //Si tiene dos hijos
            if(root.left!=null&&root.right!=null){
                if(root.right.ht>root.left.ht+1 ){
                    root = rebalanceLeft(root);
                }else if(root.left.ht>root.right.ht ){
                    root = rebalanceRight(root);
                }
            }
            //Si solo tiene hijo izquierdo
            else if(root.left!=null&&root.right==null ){
                root=rebalanceRight(root);
            }
            //Si solo tiene hijo derecho 
            else if(root.left==null&&root.right!=null ){
                root=rebalanceLeft(root);
            }
            height(root);
        }
        return root;
    }

    

    private Node minValueNode(Node node)  {  
        Node current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.left != null)  
        current = current.left;  
  
        return current;  
    }  
    
    private void preOrder(Node node,ArrayList<Document> a) { 
        if (node != null) { 
            a.add(node.val);
            preOrder(node.left,a); 
            preOrder(node.right,a); 
        } 
    }
    public ArrayList<Document> preOrder(){
        ArrayList<Document> a = new ArrayList<>();
        preOrder(this.root, a);
        return a;
    }
    
    private void postOrder(Node node, ArrayList<Document> a) { 
        if (node == null) 
            return; 
        postOrder(node.left,a); 
        postOrder(node.right,a); 
        a.add(node.val);
    } 
    public ArrayList<Document> postOrder(){
        ArrayList<Document> a = new ArrayList<>();
        postOrder(this.root, a);
        return a;
    }
    
    private void inOrder(Node node, ArrayList<Document> a) { 
        if (node == null) 
            return; 
        inOrder(node.left,a); 
        a.add(node.val);
        inOrder(node.right,a); 
    } 
    public ArrayList<Document> inOrder(){
        ArrayList<Document> a = new ArrayList<>();
        inOrder(this.root, a);
        return a;
    }
    
    private void printInorder(Node node){ 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.val.name + " "); 
        printInorder(node.right); 
    } 
    public void printInorder(){
        printInorder(this.root);
        System.out.println("");
    }

    private void printPreorder(Node node){ 
        if (node == null) 
            return; 
        System.out.print(node.val.name + " "); 
        printPreorder(node.left); 
        printPreorder(node.right); 
    }
    public void printPreorder(){
        printPreorder(this.root);
        System.out.println("");
    }
    
    private void printPostorder(Node node){ 
        if (node == null) 
            return; 
        printPostorder(node.left); 
        printPostorder(node.right); 
        System.out.print(node.val.name + " "); 
    }
    public void printPostorder(){
        printPostorder(this.root);
        System.out.println("");
    }
    
    private Node insert(Node root,Document val,VentanaAgregar v){
        if(val.name.compareToIgnoreCase(root.val.name)<0){
            if(root.left==null){
                root.left = new Node(val);
            }else{
                root.left = insert(root.left,val,v);
            }
            if(root.left.ht==root.ht) root.ht++;
            root = rebalance(root);
        }else if(val.name.compareToIgnoreCase(root.val.name)>0){
            if(root.right==null){
                root.right = new Node(val);
            }else{
                root.right = insert(root.right,val,v);
            }
            if(root.right.ht==root.ht) root.ht++;
            root =rebalance(root);
        }else if(val.name.equalsIgnoreCase(root.val.name)){
            if(val.autor.equalsIgnoreCase(root.val.autor)){
                if(v==null){
                    root.val.total++;
                    root.val.disponible++;
                }else{
                    AñadirRepetido a = new AñadirRepetido(v.padre, true, root);
                    a.setVisible(true);
                }
            }
        }
        return root;
    }
    public Node insert(Document val, VentanaAgregar v){
        if(this.root==null)
            this.root = new Node(val);
        else
            this.root =insert(this.root,val,v);
        return this.root;
    }

    private void search(String busqueda, Node root, ArrayList<Document> a){
        if(root==null){
            return;
        }
        if(root.val.name.toLowerCase().indexOf(busqueda.toLowerCase())==0){
            a.add(root.val);
            search(busqueda, root.left, a);
            search(busqueda, root.right, a);
        }else if(busqueda.compareToIgnoreCase(root.val.name)<0){
            search(busqueda, root.left, a);
        }else if(busqueda.compareToIgnoreCase(root.val.name)>0){
            search(busqueda, root.right, a);
        }
    }
    public ArrayList<Document> search(String busqueda){
        ArrayList<Document> a = new ArrayList<>();
        search(busqueda,this.root,a);
        return a;
    }
    
    private Node deleteNode(Node root, Document val){  
        if(val == this.root.val&&this.root.left==null&&this.root.right==null){
            this.root = null;
        }
        if (root == null)  
            return root;   
        if (val.name.compareToIgnoreCase(root.val.name)<0)  
            root.left = deleteNode(root.left, val);  
 
        else if (val.name.compareToIgnoreCase(root.val.name)>0)  
            root.right = deleteNode(root.right, val);  

        else{   
            if ((root.left == null) || (root.right == null)){  
                Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
                if (temp == null){  
                    temp = root;  
                    root = null;  
                }else 
                    root = temp;                                 
            }else{  
                Node temp = minValueNode(root.right);  
                root.val = temp.val;   
                root.right = deleteNode(root.right, temp.val);  
            }  
        }  
        if (root == null)  
            return root;  
        return root;
    } 
    public void delete(Document val){
        deleteNode(this.root, val);
        this.root=rebalance(this.root);
        height(this.root);
    }
    
    private Document find(String busqueda, Node root){
        if(root==null)
            return null;
        if(root.val.name.equalsIgnoreCase(busqueda)){
            return root.val;
        }else if(busqueda.compareToIgnoreCase(root.val.name)<0){
            return find(busqueda, root.left);
        }else if(busqueda.compareToIgnoreCase(root.val.name)>0){
            return find(busqueda, root.right);
        }
        return null;
    }
    public Document find(String busqueda){
        return find(busqueda.trim(),this.root);
    }
}

