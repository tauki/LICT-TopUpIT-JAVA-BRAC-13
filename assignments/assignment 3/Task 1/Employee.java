public class Employee {
	private float esal;
	private int eid;
	private String ename, edept;
	private Address eadd;
	
	//setters
	
	public void setEsal(float esal){
		this.esal = esal;
	}
	
	public void setEID(int eid){
		this.eid = eid;
	}
	
	public void setEname(String ename){
		this.ename = ename;
	}
	
	public void setEdept(String edept){
		this.edept = edept;
	}
	
	public Address setEadd(Address eadd){
		this.eadd = eadd;
	}
	
	//getters
	
	public float getEsal(){
		return esal;
	}
	
	public int getEID(){
		return eid;
	}
	
	public String getEname(){
		return ename;
	}
	
	public String getEdept(){
		return edept;
	}
	
	public Address getEadd(){
		return eadd;
	}
}