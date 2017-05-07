import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

interface TalkGroupServer extends Remote{

	int 	addTalkGroup(String nickName) 			throws RemoteException;
	boolean pushTalk(String talk, int idx) 	throws RemoteException;
	ArrayList<String> flushOutBuffer(int idx) throws RemoteException;
	
}
