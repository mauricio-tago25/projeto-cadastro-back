package br.com.mauricio.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venda_det")
public class VendaDet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_venda")
	private Venda idVenda;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto idProduto;

	@Column(name = "quantidade")
	private Long quantidade;

	@Column(name = "preco_total")
	private Double precoTotal;

}
