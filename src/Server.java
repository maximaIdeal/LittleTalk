

/*
* Context�ӿڱ�ʾһ�����������ģ�����һ�����Ƶ�����İ���ɡ�
* ���������͸�����Щ�󶨵�һЩ������
*/
import java.rmi.RemoteException; 
import javax.naming.Context;
/*
* InitialContext����ִ�����������ĳ�ʼ�����ġ�    
* �ó�ʼ������ʵ�� Context �ӿڲ��ṩ�������Ƶ���ʼ�㡣
*/
import javax.naming.InitialContext;
public class Server {
  public static void main(String[] args) throws RemoteException {
	TalkGroupServer tsg01 = null;
	  
    try {
    	tsg01 = new TalkGServerImpl();
    	Context namingContext = new InitialContext();
    	namingContext.rebind("rmi://127.0.0.1/tsg01", tsg01);
    	System.out.println("��������������ע����1��Զ�̷������");
    	System.out.println("Little Talk Server Start !");
        
       
       
    } catch (Exception e) {
      e.printStackTrace();
    }
    
	//service02.setGion(3);
   
    
  }
}