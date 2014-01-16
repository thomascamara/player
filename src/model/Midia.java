package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Midia")
public class Midia {

	@Id  
    @Column(name = "cd_midia")  
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqmidia")  
    @SequenceGenerator(name = "seqmidia", sequenceName = "seqmidia", allocationSize = 0)
	private long cdMidia;

	@Column(name="ds_url")
	private String dsUrl;

	@Column(name="nm_musica")
	private String nmMusica;
	
	@Column(name="nm_artista")
	private String nmArtista;
	
	@Column(name="tp_midia")
	private Integer tpMidia;
	
	@ManyToOne
	@JoinColumn(name="cd_genero")
	private Genero genero;

	public long getCdMidia() {
		return cdMidia;
	}

	public void setCdMidia(long cdMidia) {
		this.cdMidia = cdMidia;
	}

	public String getDsUrl() {
		return dsUrl;
	}

	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}

	public String getNmMusica() {
		return nmMusica;
	}

	public void setNmMusica(String nmMusica) {
		this.nmMusica = nmMusica;
	}
	
	public Integer getTpMidia()
	{
		return tpMidia;
	}
	
	public void setTpMidia(Integer tpMidia)
	{
		this.tpMidia = tpMidia;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNmArtista() {
		return nmArtista;
	}

	public void setNmArtista(String nmArtista) {
		this.nmArtista = nmArtista;
	}
}
