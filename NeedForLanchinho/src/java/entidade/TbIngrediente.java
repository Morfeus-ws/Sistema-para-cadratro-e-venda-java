/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_ingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbIngrediente.findAll", query = "SELECT t FROM TbIngrediente t")
    , @NamedQuery(name = "TbIngrediente.findByCodIngrediente", query = "SELECT t FROM TbIngrediente t WHERE t.codIngrediente = :codIngrediente")
    , @NamedQuery(name = "TbIngrediente.findByNomeIngrediente", query = "SELECT t FROM TbIngrediente t WHERE t.nomeIngrediente = :nomeIngrediente")
    , @NamedQuery(name = "TbIngrediente.findByPrecoIngrediente", query = "SELECT t FROM TbIngrediente t WHERE t.precoIngrediente = :precoIngrediente")
    , @NamedQuery(name = "TbIngrediente.findByUnidadeIngrediente", query = "SELECT t FROM TbIngrediente t WHERE t.unidadeIngrediente = :unidadeIngrediente")
    , @NamedQuery(name = "TbIngrediente.findByFgAtivo", query = "SELECT t FROM TbIngrediente t WHERE t.fgAtivo = :fgAtivo")})
public class TbIngrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ingrediente")
    private Integer codIngrediente;
    @Basic(optional = false)
    @Column(name = "nome_ingrediente")
    private String nomeIngrediente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_ingrediente")
    private BigDecimal precoIngrediente;
    @Column(name = "unidade_ingrediente")
    private String unidadeIngrediente;
    @Column(name = "fg_ativo")
    private Boolean fgAtivo;
    @JoinColumn(name = "cod_categoria_ingrediente", referencedColumnName = "cod_categoria_ingrediente")
    @ManyToOne(optional = false)
    private TbCategoriaIngrediente codCategoriaIngrediente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbIngrediente")
    private List<TbProdutoIngrediente> tbProdutoIngredienteList;

    public TbIngrediente() {
    }

    public TbIngrediente(Integer codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public TbIngrediente(Integer codIngrediente, String nomeIngrediente) {
        this.codIngrediente = codIngrediente;
        this.nomeIngrediente = nomeIngrediente;
    }

    public Integer getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(Integer codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public double getPrecoIngrediente() {
        return precoIngrediente.doubleValue();
    }

    public void setPrecoIngrediente(double precoIngrediente) {
        this.precoIngrediente = new BigDecimal(precoIngrediente);
    }

    public String getUnidadeIngrediente() {
        return unidadeIngrediente;
    }

    public void setUnidadeIngrediente(String unidadeIngrediente) {
        this.unidadeIngrediente = unidadeIngrediente;
    }

    public Boolean getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }

    public TbCategoriaIngrediente getCodCategoriaIngrediente() {
        return codCategoriaIngrediente;
    }

    public void setCodCategoriaIngrediente(TbCategoriaIngrediente codCategoriaIngrediente) {
        this.codCategoriaIngrediente = codCategoriaIngrediente;
    }

    @XmlTransient
    public List<TbProdutoIngrediente> getTbProdutoIngredienteList() {
        return tbProdutoIngredienteList;
    }

    public void setTbProdutoIngredienteList(List<TbProdutoIngrediente> tbProdutoIngredienteList) {
        this.tbProdutoIngredienteList = tbProdutoIngredienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIngrediente != null ? codIngrediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbIngrediente)) {
            return false;
        }
        TbIngrediente other = (TbIngrediente) object;
        if ((this.codIngrediente == null && other.codIngrediente != null) || (this.codIngrediente != null && !this.codIngrediente.equals(other.codIngrediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbIngrediente[ codIngrediente=" + codIngrediente + " ]";
    }
    
}
