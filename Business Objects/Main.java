package BusinessObjects;


public class Main {
  public static void main(String[] args){
     Schedule sched1 = new Schedule(1,"W200","Jean-Claude","Van Damme","M-F 8am-5pm");
     Schedule sched2 = new Schedule(1,"W200","Jean","Van","M-F 9am-6pm");
     Schedulelist allSched = new Schedulelist();
     
     allSched.addSchedule(sched1);
     allSched.addSchedule(sched2);
     
     allSched.displaySchedule();
     
  }  
}
