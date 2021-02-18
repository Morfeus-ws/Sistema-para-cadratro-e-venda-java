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
public class TbCompraProdutoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_compra")
    private int codCompra;
    @Basic(optional = false)
    @Column(name = "cod_produto")
    private int codProduto;

    public TbCompraProdutoPK() {
    }

    public TbCompraProdutoPK(int codCompra, int codProduto) {
        this.codCompra = codCompra;
        this.codProduto = codProduto;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCompra;
        hash += (int) codProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCompraProdutoPK)) {
            return false;
        }
        TbCompraProdutoPK other = (TbCompraProdutoPK) object;
        if (this.codCompra != other.codCompra) {
            return false;
        }
        if (this.codProduto != other.codProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbCompraProdutoPK[ codCompra=" + codCompra + ", codProduto=" + codProduto + " ]";
    }
    
}
