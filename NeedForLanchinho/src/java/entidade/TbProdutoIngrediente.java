/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thiago
 */
@Entity
@Table(name = "tb_produto_ingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProdutoIngrediente.findAll", query = "SELECT t FROM TbProdutoIngrediente t")
    , @NamedQuery(name = "TbProdutoIngrediente.findByCodProduto", query = "SELECT t FROM TbProdutoIngrediente t WHERE t.tbProdutoIngredientePK.codProduto = :codProduto")
    , @NamedQuery(name = "TbProdutoIngrediente.findByCodIngrediente", query = "SELECT t FROM TbProdutoIngrediente t WHERE t.tbProdutoIngredientePK.codIngrediente = :codIngrediente")
    , @NamedQuery(name = "TbProdutoIngrediente.findByQuantidadeIngrediente", query = "SELECT t FROM TbProdutoIngrediente t WHERE t.quantidadeIngrediente = :quantidadeIngrediente")})
public class TbProdutoIngrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbProdutoIngredientePK tbProdutoIngredientePK;
    @Column(name = "quantidade_ingrediente")
    private Integer quantidadeIngrediente;
    @JoinColumn(name = "cod_ingrediente", referencedColumnName = "cod_ingrediente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbIngrediente tbIngrediente;
    @JoinColumn(name = "cod_produto", referencedColumnName = "cod_produto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbProduto tbProduto;

    public TbProdutoIngrediente() {
    }

    public TbProdutoIngrediente(TbProdutoIngredientePK tbProdutoIngredientePK) {
        this.tbProdutoIngredientePK = tbProdutoIngredientePK;
    }

    public TbProdutoIngrediente(int codProduto, int codIngrediente) {
        this.tbProdutoIngredientePK = new TbProdutoIngredientePK(codProduto, codIngrediente);
    }

    public TbProdutoIngredientePK getTbProdutoIngredientePK() {
        return tbProdutoIngredientePK;
    }

    public void setTbProdutoIngredientePK(TbProdutoIngredientePK tbProdutoIngredientePK) {
        this.tbProdutoIngredientePK = tbProdutoIngredientePK;
    }

    public Integer getQuantidadeIngrediente() {
        return quantidadeIngrediente;
    }

    public void setQuantidadeIngrediente(Integer quantidadeIngrediente) {
        this.quantidadeIngrediente = quantidadeIngrediente;
    }

    public TbIngrediente getTbIngrediente() {
        return tbIngrediente;
    }

    public void setTbIngrediente(TbIngrediente tbIngrediente) {
        this.tbIngrediente = tbIngrediente;
    }

    public TbProduto getTbProduto() {
        return tbProduto;
    }

    public void setTbProduto(TbProduto tbProduto) {
        this.tbProduto = tbProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbProdutoIngredientePK != null ? tbProdutoIngredientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProdutoIngrediente)) {
            return false;
        }
        TbProdutoIngrediente other = (TbProdutoIngrediente) object;
        if ((this.tbProdutoIngredientePK == null && other.tbProdutoIngredientePK != null) || (this.tbProdutoIngredientePK != null && !this.tbProdutoIngredientePK.equals(other.tbProdutoIngredientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbProdutoIngrediente[ tbProdutoIngredientePK=" + tbProdutoIngredientePK + " ]";
    }
    
}
