import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

class TalkGServerImpl extends UnicastRemoteObject implements TalkGroupServer{

	//private static final long serialVersionUID = 1L;
	private List<Speaker> spCtrl;
	
	
	public TalkGServerImpl() throws RemoteException {
		this.spCtrl = new ArrayList<Speaker>();
		
		
		
		// TODO Auto-generated constructor stub
	}

	private synchronized Speaker getSpeakerNth(int nth){
		if(nth+1 <= this.spCtrl.size()){
			return this.spCtrl.get(nth);
		}
		return null;
	}
	
	
	
	@Override
	public synchronized int addTalkGroup(String nickName) throws RemoteException {
	
		int retIdx = -1;
		
		try{
			Speaker newSp = new Speaker( nickName);
			retIdx = this.spCtrl.size();
			this.spCtrl.add(newSp);
			System.out.println(nickName + "add talk");
			return retIdx;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retIdx;
	}

	@Override
	public synchronized boolean  pushTalk(String talk, int idx) throws RemoteException {
		
		Speaker objSpeak = this.getSpeakerNth(idx);
		
		if(objSpeak == null)
			return false;
		
		try{
			String newTalk = objSpeak.getName() + ": " + talk;
			for(int i = 0; i < this.spCtrl.size(); i++){
				if(i != idx)
					this.spCtrl.get(i).outBufferAdd(newTalk);	
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return false;
	}

	
	@Override
	public synchronized ArrayList<String> flushOutBuffer(int idx) throws RemoteException {
		Speaker sp = this.getSpeakerNth(idx);
		if(sp == null)
			return null;

		return sp.flushBuffer();
	}

}
