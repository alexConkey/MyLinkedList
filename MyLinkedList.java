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
    return true;
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
    return current.getData();
  }
  public String set(int index, String value){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Index " + index + " must be greater than or equal to 0 and less than size");
    }
    Node newNode = new Node(value);
    if (index == 0){
      newNode.setNext(start.getNext());
      newNode.getNext().setPrev(newNode);
      String pending = start.getData();
      start = newNode;
      return pending;
    }else if (index == size-1){
      newNode.setPrev(end.getPrev());
      newNode.getPrev().setNext(newNode);
      String pending = end.getData();
      end = newNode;
      return pending;
    }else{
      int currentIndex = 0;
      Node current = start;
      while(currentIndex != index){
        current =  current.getNext();
        currentIndex++;
      }
      newNode.setPrev(current.getPrev());
      newNode.setNext(current.getNext());
      newNode.getNext().setPrev(newNode);
      newNode.getPrev().setNext(newNode);
      return current.getData();
    }
  }
  public String toString(){
    if (size == 0){
      return "[]";
    }else{
      String finalStr = "[";
      Node current = start;
      for(int i = 0; i < size-1; i++){
        finalStr += (current.getData() + ", ");
        current = current.getNext();
      }
      return (finalStr + current.getData() + "]");
    }
  }
  public String remove(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Index " + index + " must be greater than or equal to 0 and less than size");
    }
    if (index == 0){
      String pending = start.getData();
      start = start.getNext();
      size--;
      return pending;
    }else if (index == size-1){
      String pending = end.getData();
      end = end.getPrev();
      size--;
      return pending;
    }else{
      int currentIndex = 0;
      Node current = start;
      while(currentIndex != index){
        current = current.getNext();
        currentIndex++;
      }
      current.getNext().setPrev(current.getPrev());
      current.getPrev().setNext(current.getNext());
      size--;
      return current.getData();
    }
  }
  public void removeAll(){
    size = 0;
  }
  public Node getStart(){
    return start;
  }
  public Node getEnd(){
    return end;
  }
  public int getSize(){
    return size;
  }

  public void extend(MyLinkedList other){
    if (size == 0 && other.getSize() != 0){
      start = other.getStart();
      end = other.getEnd();
      size = other.getSize();
      other.removeAll();
    }else if(size != 0 && other.getSize() != 0){
      end.setNext(other.getStart());
      other.getStart().setPrev(end);
      end = other.getEnd();
      size = size + other.size();
      other.removeAll();
    }
  }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
