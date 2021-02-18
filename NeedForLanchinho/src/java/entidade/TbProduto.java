/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thiago
 */
@Entity
@Table(name = "tb_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProduto.findAll", query = "SELECT t FROM TbProduto t")
    , @NamedQuery(name = "TbProduto.findByCodProduto", query = "SELECT t FROM TbProduto t WHERE t.codProduto = :codProduto")
    , @NamedQuery(name = "TbProduto.findByNomeProduto", query = "SELECT t FROM TbProduto t WHERE t.nomeProduto = :nomeProduto")
    , @NamedQuery(name = "TbProduto.findByPrecoProduto", query = "SELECT t FROM TbProduto t WHERE t.precoProduto = :precoProduto")
    , @NamedQuery(name = "TbProduto.findByListado", query = "SELECT t FROM TbProduto t WHERE t.listado = :listado")
    , @NamedQuery(name = "TbProduto.findByFgAtivo", query = "SELECT t FROM TbProduto t WHERE t.fgAtivo = :fgAtivo")})
public class TbProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_produto")
    private Integer codProduto;
    @Basic(optional = false)
    @Column(name = "nome_produto")
    private String nomeProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_produto")
    private BigDecimal precoProduto;
    @Column(name = "listado")
    private Boolean listado;
    @Column(name = "fg_ativo")
    private Boolean fgAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProduto")
    private List<TbProdutoIngrediente> tbProdutoIngredienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProduto")
    private List<TbCompraProduto> tbCompraProdutoList;

    public TbProduto() {
        this.tbProdutoIngredienteList = new ArrayList<>();
    }

    public TbProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public TbProduto(Integer codProduto, String nomeProduto) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto.doubleValue();
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = new BigDecimal(precoProduto);
    }

    public Boolean getListado() {
        return listado;
    }

    public void setListado(Boolean listado) {
        this.listado = listado;
    }

    public Boolean getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }

    public void addIngrediente(TbIngrediente ingrediente, Integer quantidade) {
        TbProdutoIngrediente produtoIngrediente = new TbProdutoIngrediente();
        produtoIngrediente.setTbProduto(this);
        produtoIngrediente.setTbIngrediente(ingrediente);
        produtoIngrediente.setQuantidadeIngrediente(quantidade);
        
        TbProdutoIngredientePK produtoIngredientePK = 
                new TbProdutoIngredientePK(this.codProduto, ingrediente.getCodIngrediente());
        produtoIngrediente.setTbProdutoIngredientePK(produtoIngredientePK);
        
        this.tbProdutoIngredienteList.add(produtoIngrediente);
    }
    
    public void removeIngrediente(TbIngrediente ingrediente) {
        for (int i = 0; i < this.tbProdutoIngredienteList.size(); i++) {
            if (this.tbProdutoIngredienteList.get(i).getTbIngrediente().getCodIngrediente()
                    == ingrediente.getCodIngrediente()) {
                this.tbProdutoIngredienteList.remove(i);
                return;
            }
        }
    }

    @XmlTransient
    public List<TbProdutoIngrediente> getTbProdutoIngredienteList() {
        return tbProdutoIngredienteList;
    }

    public void setTbProdutoIngredienteList(List<TbProdutoIngrediente> tbProdutoIngredienteList) {
        this.tbProdutoIngredienteList = tbProdutoIngredienteList;
    }

    @XmlTransient
    public List<TbCompraProduto> getTbCompraProdutoList() {
        return tbCompraProdutoList;
    }

    public void setTbCompraProdutoList(List<TbCompraProduto> tbCompraProdutoList) {
        this.tbCompraProdutoList = tbCompraProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProduto)) {
            return false;
        }
        TbProduto other = (TbProduto) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbProduto[ codProduto=" + codProduto + " ]";
    }
    
}
