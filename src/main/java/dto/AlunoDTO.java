package dto;

import java.io.Serializable;
import java.util.Date;
 
public class AlunoDTO implements Serializable {	 
	private Long id;
    private String nome;
    private Date dtnasc;
     
    public AlunoDTO() {
    	nome = "";
    }
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}

	@Override
	public String toString() {
		return "AlunoDTO [id=" + id + ", nome=" + nome + ", dtnasc=" + dtnasc + "]";
	}
	
}
