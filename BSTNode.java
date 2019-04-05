public class BSTNode{
    public Comparable data;
    public BSTNode left;
    public BSTNode right;
    //constructor
    public BSTNode(Comparable data){
        this.data=data;
    }

    //get data
    public Comparable data(){
        return data;
    }

    //get next
    public BSTNode getRight(){
        return right;
    }

    //set next
    public void setRight(BSTNode next){
        this.right = next;
    }

    //get left
    public BSTNode getLeft(){
        return left;
    }

    //set left
    public void setLeft(BSTNode next){
        this.left = next;
    }
}