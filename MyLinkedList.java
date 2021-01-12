public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){

 }
 public int size(){
   return size;
 }
 public boolean add(String value){
   Node newNode = new Node(value);
   end.setNext(newNode);
   newNode.setPrev(end);
   end = end.getNext();
 }
 public void add(int index, String value){
   int currentIndex = 0;
   Node current = start
   while(current < index){

   }
 }
 public String get(int index);
 public String set(int index, String value);
 public String toString();
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
