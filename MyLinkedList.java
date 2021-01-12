public class MyLinkedList{
  private int size;
  private Node start,end;
  public MyLinkedList(){
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean add(String value){
    Node newNode = new Node(value);
    if (size == 0){
      start = newNode;
      end = newNode;
    }else{
      end.setNext(newNode);
      newNode.setPrev(end);
      end = end.getNext();
    }
    size++;
  }
  public void add(int index, String value){
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException("Index " + index + " must be greater than or equal to 0 and less than or equal to size");
    }
    Node newNode = new Node(value);
    if (size == 0){
      start = newNode;
      end = newNode;
    }else{
      if (index == 0){
        start.setPrev(newNode);
        newNode.setNext(start);
        start = newNode;
      }else if (index == size){
        end.setNext(newNode);
        newNode.setPrev(end);
        end = newNode;
      }else{
        int currentIndex = 0;
        Node current = start;
        while(currentIndex != index){
          current = current.getNext();
          currentIndex++;
        }
        current.getPrev().setNext(newNode);
        newNode.setPrev(current.getPrev());
        current.setPrev(newNode);
        newNode.setNext(current);
      }
    }
    size++;
  }
  public String get(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Index " + index + " must be greater than or equal to 0 and less than size");
    }
    int currentIndex = 0;
    Node current = start;
    while(currentIndex != index){
      current =  current.getNext();
      currentIndex++;
    }
    return current;
  }
  public String set(int index, String value){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Index " + index + " must be greater than or equal to 0 and less than size");
    }
    Node newNode = new Node(value);
    if (index == 0){
      newNode.setNext(start.getNext());
      start = newNode;
    }else if (index == size-1){
      newNode.setPrev(end.getPrev());
      end = newNode;
    }else{
      int currentIndex = 0;
      Node current = start;
      while(currentIndex != index){
        current =  current.getNext();
        currentIndex++;
      }
      newNode.setPrev(current.getPrev());
      newNode.setNext(current.getNext());
    }

  }
  public String toString(){
    String finalStr = "{";
    Node current = start;
    for(int i = 0; i < size-1; i++){
      finalStr += (current.getData() + ", ");
      current = current.getNext();
    }
    return (finalStr + current.getData() + "}")
  }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
