import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {
	public static void main(String[] args) {

	  
	String url = "rmi://127.0.0.1/";
	

	class ttP extends TimerTask{
			private TalkGroupServer tgs;
			private int idx;
	    	
			ttP( TalkGroupServer is, int i){
			  this.tgs= is;
			  this.idx = i;
		  }
	    	
	    	
			@Override
			  public void run() {
				  
					try {
					  ArrayList<String> out = null;
					  out = tgs.flushOutBuffer(idx);
					  if(out != null){
						  for( String talkRecord : out)
							  System.out.println(talkRecord);
					  }
				  } catch (RemoteException e) {
					e.printStackTrace();
				  }
			}
		}  
	  
    
    Timer timer = new Timer();
	 

 	
 
    try {
      Context namingContext = new InitialContext();
      
      TalkGroupServer tgs01 = (TalkGroupServer)namingContext.lookup("rmi://127.0.0.1/tsg01");
      
      Class stubClass = tgs01.getClass();
      System.out.println(tgs01 + " 是 " + stubClass.getName()
          + " 的实例！");
      // 获得本底存根已实现的接口类型
      Class[] interfaces = stubClass.getInterfaces();
      for (Class c : interfaces) {
        System.out.println("存根类实现了 " + c.getName() + " 接口！");
      }
      
      //System.out.println(service02.getGion());
      Scanner in = new Scanner(System.in);
      int idx;

      
      String nickName = in.nextLine();
      idx = tgs01.addTalkGroup(nickName);  
      System.out.println(nickName);
      
      if(idx != -1){
    	  System.out.println("you id = " + idx);
     
          TimerTask task = new ttP( tgs01,idx );
          timer.scheduleAtFixedRate(task, 0, 200);  
          
          while(true){
        	  String talk;
        	  talk = in.nextLine();
        	  if(tgs01.pushTalk(talk, idx))
        		  System.out.printf(" successed push");
          }
      }

      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("ERR ");

  }
}