package CA;

public class ShowList {
   private Show head=null;




   public void addShow(String name, int showNumber){
       if(head==null){
          head = new Show(name,showNumber);
       }
       else{
          Show temp = head;
          while(temp.getNextShow()!=null){
             temp=temp.getNextShow();
          }
          temp.setNextShow(new Show(name,showNumber));
       }
   }
   public void clearShows(){
      head=null;
   }
   public void ListShows(){
       if(head!=null) {
           Show temp = head;
           System.out.println(head.toString());
           while (temp.getNextShow() != null) {
               System.out.println(temp.getNextShow().toString());
               temp = temp.getNextShow();
           }
       }
       else{
           System.out.println("List is empty");
       }
   }
}