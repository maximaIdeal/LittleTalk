

/*
* Context接口表示一个命名上下文，它由一组名称到对象的绑定组成。
* 它包含检查和更新这些绑定的一些方法。
*/
import java.rmi.RemoteException; 
import javax.naming.Context;
/*
* InitialContext类是执行命名操作的初始上下文。    
* 该初始上下文实现 Context 接口并提供解析名称的起始点。
*/
import javax.naming.InitialContext;
public class Server {
  public static void main(String[] args) throws RemoteException {
	TalkGroupServer tsg01 = null;
	  
    try {
    	tsg01 = new TalkGServerImpl();
    	Context namingContext = new InitialContext();
    	namingContext.rebind("rmi://127.0.0.1/tsg01", tsg01);
    	System.out.println("服务器向命名表注册了1个远程服务对象！");
    	System.out.println("Little Talk Server Start !");
        
       
       
    } catch (Exception e) {
      e.printStackTrace();
    }
    
	//service02.setGion(3);
   
    
  }
}