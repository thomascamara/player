package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genero")
public class Genero {
	
	@Id
	@GeneratedValue
	@Column(name="cd_genero")
	private long cdGenero;
	
	@Column(name="nm_genero")
	private String nmGenero;
	
	public Genero(){
		
	}

	public long getCdGenero() {
		return cdGenero;
	}

	public void setCdGenero(long cdGenero) {
		this.cdGenero = cdGenero;
	}

	public String getNmGenero() {
		return nmGenero;
	}

	public void setNmGenero(String nmGenero) {
		this.nmGenero = nmGenero;
	}
	
	

}
