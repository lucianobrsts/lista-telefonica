package br.com.boavista.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.boavista.dao.PessoaDAO;
import br.com.boavista.domain.Pessoa;
import br.com.boavista.relatorio.Relatorio;
import br.com.boavista.util.FacesUtil;
import lombok.Data;

@ManagedBean(name = "pessoaBean")
@ViewScoped
@Data
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = -1920692048518468781L;
	private Pessoa pessoaCadastro;
	private List<Pessoa> listaPessoas;
	private List<Pessoa> lista;
	private String fileName = "RelatorioContato.pdf";
	private Long codigo;
	
	@PostConstruct
	public void init() {
		pessoaCadastro = new Pessoa();
	}
	
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();

		try {
			if (pessoaDAO.existeNome(pessoaCadastro.getNome())) {
				FacesUtil.addErrorMessage("crud.jaExistente");
			} else {
				pessoaDAO.salvar(pessoaCadastro);
				FacesUtil.addSuccessMessage("crud.sucesso");
				pessoaCadastro = new Pessoa();
			}
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}
	
	public void carregarPesquisa() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			listaPessoas = pessoaDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erroListar");
		}
	}
	
	public void excluir() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoaCadastro);
			FacesUtil.addSuccessMessage("crud.sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}

	public void editar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.editar(pessoaCadastro);
			FacesUtil.addSuccessMessage("crud.sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}
	
	public void geraRelatorioContato() {
		Relatorio relatorio = new Relatorio();
		PessoaDAO pessoaDAO = new PessoaDAO();
		lista = pessoaDAO.listar();

		if (!lista.isEmpty()) {
			relatorio.getRelatorioContato(lista, fileName);
		} else {
			FacesUtil.addErrorMessage("pdf.semInfo");
		}
	}

}
