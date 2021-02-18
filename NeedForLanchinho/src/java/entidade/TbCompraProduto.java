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
@Table(name = "tb_compra_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCompraProduto.findAll", query = "SELECT t FROM TbCompraProduto t")
    , @NamedQuery(name = "TbCompraProduto.findByCodCompra", query = "SELECT t FROM TbCompraProduto t WHERE t.tbCompraProdutoPK.codCompra = :codCompra")
    , @NamedQuery(name = "TbCompraProduto.findByCodProduto", query = "SELECT t FROM TbCompraProduto t WHERE t.tbCompraProdutoPK.codProduto = :codProduto")
    , @NamedQuery(name = "TbCompraProduto.findByQuantidadeProduto", query = "SELECT t FROM TbCompraProduto t WHERE t.quantidadeProduto = :quantidadeProduto")})
public class TbCompraProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbCompraProdutoPK tbCompraProdutoPK;
    @Column(name = "quantidade_produto")
    private Integer quantidadeProduto;
    @JoinColumn(name = "cod_compra", referencedColumnName = "cod_compra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbCompra tbCompra;
    @JoinColumn(name = "cod_produto", referencedColumnName = "cod_produto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbProduto tbProduto;

    public TbCompraProduto() {
    }

    public TbCompraProduto(TbCompraProdutoPK tbCompraProdutoPK) {
        this.tbCompraProdutoPK = tbCompraProdutoPK;
    }

    public TbCompraProduto(int codCompra, int codProduto) {
        this.tbCompraProdutoPK = new TbCompraProdutoPK(codCompra, codProduto);
    }

    public TbCompraProdutoPK getTbCompraProdutoPK() {
        return tbCompraProdutoPK;
    }

    public void setTbCompraProdutoPK(TbCompraProdutoPK tbCompraProdutoPK) {
        this.tbCompraProdutoPK = tbCompraProdutoPK;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public TbCompra getTbCompra() {
        return tbCompra;
    }

    public void setTbCompra(TbCompra tbCompra) {
        this.tbCompra = tbCompra;
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
        hash += (tbCompraProdutoPK != null ? tbCompraProdutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCompraProduto)) {
            return false;
        }
        TbCompraProduto other = (TbCompraProduto) object;
        if ((this.tbCompraProdutoPK == null && other.tbCompraProdutoPK != null) || (this.tbCompraProdutoPK != null && !this.tbCompraProdutoPK.equals(other.tbCompraProdutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbCompraProduto[ tbCompraProdutoPK=" + tbCompraProdutoPK + " ]";
    }
    
}
