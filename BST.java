public class BST<T>{
    protected BSTNode root;

    /* Find */
    public boolean find(Comparable value){
        return find(root, value);
    }

    private boolean find(BSTNode node, Comparable value){
        if(node==null){
            return false;
        }
        //check for match
        if (node.data.compareTo(value)==0) {
            return true;
        }
      	
      	//if value is less go to the left
      	//if value is more go to the right
        else if (node.data.compareTo(value)>0) {
            return find(node.left, value);
        }else{
            return find(node.right,value);
        }
    }

    /* Insert */
    public void insert(Comparable value){
       root = insert(root,value);
    }

    //finds value in tree and returns the node
    private BSTNode insert(BSTNode node, Comparable value){

        if (node == null) {
            BSTNode newNode = new BSTNode(value);
            return newNode;
        }
        //if value is more than the node move to the right of the node
        else if (node.data.compareTo(value)<0) {
            node.right = insert(node.right,value);
            return node;
        }
        //if value is less than the node move to the left of the node
        else{
            node.left = insert(node.left,value);
            return node;
        }
    }

    /* Print */
    public void print(){
        print(root);
    }

    private void print(BSTNode node){
    	/*prints in order of left, current, and right for each call*/
        if(node!=null){
            print(node.left);
            System.out.print(node.data);
            print(node.right);
        }
    }

    /* Delete */
    public void delete (Comparable value){
        root = delete(root, value);
    }
    
    public BSTNode delete(BSTNode node, Comparable value){
        /*base case*/
        if (node==null) {
            return node;
        }

        /*going down the tree*/
        if(value.compareTo(node.data)<0){
            node.left = delete(node.left, value);
        }
        else if(value.compareTo(node.data)>0){
            node.right = delete(node.right, value);
        }

        /*else node is found*/
        else{
            /*node with only one child*/
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;

            /*node with two children*/
            node.data = removeSmallest(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    public Comparable removeSmallest(BSTNode node){
        if(node.left.left == null){
            BSTNode smallest = node.left.right;
            node.right = node.left.right;
            return smallest.data;
        } else {
            return removeSmallest(node.left);
        }
    }


}