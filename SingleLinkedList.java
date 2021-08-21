public class SingleLinkedList<T> {
    public Node<T> head = null; // 최초 헤드는 null

    public class Node<T> { // 노드 만드는거 내부클래스를 만드는거 //데이터 공간을 만드는거
        T data; //데이터 클래스
        Node<T> next = null; // 포인터인거죠

        public Node(T data) {
            this.data = data; // 저장하느거
        }
    }


    public void addNode(T data) {
        if (head == null) { // 헤드가 널이다 그러므로 첫 노드라는 의미
            head = new Node<T>(data); // 헤드에 노드를 만들어서 데이터를 넣어주면 됨
        } else {
            Node<T> node = this.head; // 노드가 널이 아니면 현재 노드를 헤드로 놓고
            while (node.next != null) { //노드의 넥스트 가 널이 아니면 + 넥스트 노드가 널이면 스탑
                node = node.next; //노드를 노드의 넥스트 에 놓는다.
            }
            node.next = new Node<T>(data);// 노드의 상태가 널 -> 맨끝에 있는 노드의 포인트를 노드로 연결된다는것
        }
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data)
    {
        if(this.head == null)// 헤드가 널이면
        {
            return null;// 데이터가 없는 것으로 널을 리턴 하면 된다.
        }else// 헤드가 널이 아니면
        {
           Node<T> node = this.head;// 헤드부터 시작 해서
           while (node != null)//현재 노드가 널이 아니면
           {
               if(node.data == data){// 현재 노드가 우리가 찾고자하는 데이터 인지를 확인하고
                   return node; // 맞다면 해당노드로 리턴 하면 되고
               }else
               {
                   node = node.next;//아니면 다음 노드로 간다ㅣ.
               }
           }
        }
        return null;
    }


    public void addNodeInside(T data, T isData )//데이터 뿐만 아니라 어느 데이타 의 위치를 알아야 한다 그것이 isData 이다.
    {
        Node<T> searchedNode = this. search(isData); // 데이터 노드를 찾는 코드

        if(searchedNode == null)//해당값을 가진 노드가 없다라는 의미이다. 그러면 링크드리스트 맨뒤에다 넣어주면 된다. 기존에 있던 addNode 를 사용
        {
            this.addNode(data);
        }else // 엘스!! 만약에 노드가 있다면
        {
            Node<T>nextNode = searchedNode.next;// 그뒤에 해당 노드를 넣으면 될꺼 같은디요..
            searchedNode.next = new Node<T>(data);//원래 있었던 노드를 새로운 노드로 가리키는 것이고
            searchedNode.next.next = nextNode;//앞 넥스트까지는 새로만든 노드.!그뒤 넥스트는 포인터가 되는 것이다.
        }

    }
   public boolean delNode(T isData)
   {
       if(this.head == null){
           return false;

       }else
       {
           Node<T> node = this.head;
           if(node.data == isData)
           {
               this.head = this.head.next;
               return true;
           }else
           {
               while (node.next!= null)// 노드의 다음 값이 널이 아니면
               {
                   if(node.next.data == isData) //노드.넥스트의 데이터 값이 삭제해야할 데이터면
                   {
                        node.next=node.next.next; //노드가 가리키는 포인터를 다음이 아니라 중간 노드가 삭제가 되니 다음 다음으로 바꾼다는 말
                        return true;
                   }
                   node= node.next;
               }
               return  false;
           }

       }
   }

    public static void main(String[] args) {

        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        System.out.println(5+5);
        MyLinkedList.addNodeInside(5,1);
//        MyLinkedList.delNode(3);
//        MyLinkedList.delNode(1);
        MyLinkedList.delNode(10);
        MyLinkedList.printAll();
    }

}






