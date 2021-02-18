/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thiago
 */
@Embeddable
public class TbProdutoIngredientePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_produto")
    private int codProduto;
    @Basic(optional = false)
    @Column(name = "cod_ingrediente")
    private int codIngrediente;

    public TbProdutoIngredientePK() {
    }

    public TbProdutoIngredientePK(int codProduto, int codIngrediente) {
        this.codProduto = codProduto;
        this.codIngrediente = codIngrediente;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codProduto;
        hash += (int) codIngrediente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProdutoIngredientePK)) {
            return false;
        }
        TbProdutoIngredientePK other = (TbProdutoIngredientePK) object;
        if (this.codProduto != other.codProduto) {
            return false;
        }
        if (this.codIngrediente != other.codIngrediente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbProdutoIngredientePK[ codProduto=" + codProduto + ", codIngrediente=" + codIngrediente + " ]";
    }
    
}
