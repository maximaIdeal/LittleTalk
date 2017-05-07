
import java.util.*;

public class Speaker implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> outBuffer;
	private String name;

	Speaker(){}
	
	Speaker(String nickName) {
		this.outBuffer = new ArrayList<String>();
		this.name = nickName;
	}

	public synchronized boolean outBufferAdd( String str){
		try{
			if(str.length() > 0)
				this.outBuffer.add(str);
			return true;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return false;
	}
	
	public synchronized ArrayList<String> flushBuffer(){
		if(this.outBuffer.size() == 0)
			return null;
		try{
			ArrayList<String> retLst = new ArrayList<String>(this.outBuffer);
			this.outBuffer.clear();
			
			return retLst;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public synchronized int sizeOBuffer(){
		return this.outBuffer.size();		
	}
	
	public List<String> getOutBuffer() {
		return outBuffer;
	}

	public void setOutBuffer(List<String> outBuffer) {
		this.outBuffer = outBuffer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
