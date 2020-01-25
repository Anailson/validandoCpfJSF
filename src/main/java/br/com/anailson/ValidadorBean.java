package br.com.anailson;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "validadorBean")
public class ValidadorBean {
	
	private static final long serialVersionUID = 1L;

	private String cpf;
	
	private int idade;
	

	public void validar() {
		if (cpf == null || "".equals(cpf)) {
				FacesContext.getCurrentInstance().addMessage("msgValidador", new FacesMessage("CPF Vazio"));
		} else if (cpf.length() != 11) {
			FacesContext.getCurrentInstance().addMessage("msgValidador", new FacesMessage("CPF deve ter 11 dígitos"));
		} else {
			FacesContext.getCurrentInstance().addMessage("msgValidador",
					new FacesMessage("CPF Validado com sucesso !!"));
		}
	}
	
	
	public void idadevalidar() {
		
		if(idade < 18) {
			FacesContext.getCurrentInstance().addMessage("msgidade", new FacesMessage("Menor de idade"));
		}else {
			FacesContext.getCurrentInstance().addMessage("msgidade", new FacesMessage("Maior de idade"));
		}
	}
	
	

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

}
