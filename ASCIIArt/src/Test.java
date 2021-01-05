
public class Test {
  
  public static void main (String[] args) {
   Node<String> list = new Node<>("A", new Node<>("B",new Node<>("D",null)));
   
   System.out.print(list.getNext().getNext().getData());
}}
