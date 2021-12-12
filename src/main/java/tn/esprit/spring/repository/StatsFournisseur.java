package tn.esprit.spring.repository;

public class StatsFournisseur {
	long count;
	String name;
	public StatsFournisseur(long count, String name) {
		super();
		this.count = count;
		this.name = name;
	}
	public StatsFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
