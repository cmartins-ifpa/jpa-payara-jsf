package controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import dao.AlunoDAO;
import dto.AlunoDTO;
import entidades.Aluno;

@Named("alunoBean")
@RequestScoped
public class AlunoMB {
	private AlunoDTO aluno = new AlunoDTO();

	private List<Aluno> listAlunos = new ArrayList<Aluno>();

	@Inject
	private AlunoDAO dao;

	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getListAlunos() {
		// recupera todos os "alunos" do banco.
		this.listAlunos = dao.findAll();
		return listAlunos;
	}

	public void setListAlunos(List<Aluno> listAlunos) {
		this.listAlunos = listAlunos;
	}

	/**
	 * Método do cadastramento do aluno.
	 * 
	 * @return página de entrada (aluno.xhtml)
	 */
	public String adicionarAluno() {
		// adiciona o objeto "aluno" na base de dados

		Aluno a = new Aluno(aluno.getNome(), aluno.getDtnasc());

		dao.create(a);

		// Envia uma mensagem para a pagina informando que o aluno foi cadastrado
		String msg = "Aluno adicionado: " + a.getNome();
		FacesMessage fm = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage("msg", fm);

		// limpa o objeto para o próximo cadastro.
		aluno = new AlunoDTO();

		// Retorna para a página de entrada (aluno.xhtml).
		return "aluno";
	}

	public void delete (Long id) {
		Aluno aluno = dao.find(id);
		dao.remove(aluno);
		System.out.println("Aluno deletado... " + aluno.toString());
	}
}
