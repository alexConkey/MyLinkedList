public class Node{
  private String data;
  private Node next,prev;
  public Node(String value){
    data = value;
  }
  public String getData(){
    return data;
  }
  public Node getNext(){
    return next;
  }
  public Node getPrev(){
    return prev;
  }
  public void setData(String newData){
    data = newData;
  }
  public void setNext(Node newNext){
    next = newNext;
  }
  public void setPrev(Node newPrev){
    prev = newPrev;
  }
 //write get/set methods for all three instance variables.
}
