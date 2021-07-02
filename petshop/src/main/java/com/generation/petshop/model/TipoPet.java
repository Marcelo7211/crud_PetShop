package com.generation.petshop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tipo_pet")
public class TipoPet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Atributo não pode ser nem vazio e nem nulo!")
	private String descricao;
	
	@OneToMany(mappedBy = "tipoPet", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tipoPet")
	private List<ClientePet> clientPet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ClientePet> getClientPet() {
		return clientPet;
	}

	public void setClientPet(List<ClientePet> clientPet) {
		this.clientPet = clientPet;
	}	
	
}
