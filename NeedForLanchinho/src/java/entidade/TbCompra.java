/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thiago
 */
@Entity
@Table(name = "tb_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCompra.findAll", query = "SELECT t FROM TbCompra t")
    , @NamedQuery(name = "TbCompra.findByCodCompra", query = "SELECT t FROM TbCompra t WHERE t.codCompra = :codCompra")
    , @NamedQuery(name = "TbCompra.findByValorTotal", query = "SELECT t FROM TbCompra t WHERE t.valorTotal = :valorTotal")
    , @NamedQuery(name = "TbCompra.findByDataCompra", query = "SELECT t FROM TbCompra t WHERE t.dataCompra = :dataCompra")
    , @NamedQuery(name = "TbCompra.findByObservacoes", query = "SELECT t FROM TbCompra t WHERE t.observacoes = :observacoes")})
public class TbCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_compra")
    private Integer codCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @Column(name = "data_compra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private TbCliente codCliente;
    @JoinColumn(name = "cod_endereco", referencedColumnName = "cod_endereco")
    @ManyToOne(optional = false)
    private TbEndereco codEndereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCompra")
    private List<TbCompraProduto> tbCompraProdutoList;

    public TbCompra() {
        tbCompraProdutoList = new ArrayList<>();
    }

    public TbCompra(Integer codCompra) {
        this.codCompra = codCompra;
    }

    public TbCompra(Integer codCompra, BigDecimal valorTotal, Date dataCompra) {
        this.codCompra = codCompra;
        this.valorTotal = valorTotal;
        this.dataCompra = dataCompra;
    }

    public Integer getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(Integer codCompra) {
        this.codCompra = codCompra;
    }

    public double getValorTotal() {
        return valorTotal.doubleValue();
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = new BigDecimal(valorTotal);
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public TbCliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(TbCliente codCliente) {
        this.codCliente = codCliente;
    }

    public TbEndereco getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(TbEndereco codEndereco) {
        this.codEndereco = codEndereco;
    }
    
    public void addProduto(TbProduto produto, Integer quantidade) {
        TbCompraProduto compraProduto = new TbCompraProduto();
        compraProduto.setTbCompra(this);
        compraProduto.setTbProduto(produto);
        compraProduto.setQuantidadeProduto(quantidade);
        
        TbCompraProdutoPK compraProdutoPK = 
                new TbCompraProdutoPK(this.codCompra, produto.getCodProduto());
        compraProduto.setTbCompraProdutoPK(compraProdutoPK);
        
        this.tbCompraProdutoList.add(compraProduto);
    }
    
    public void removeProduto(TbProduto produto) {
        for (int i = 0; i < this.tbCompraProdutoList.size(); i++) {
            if (this.tbCompraProdutoList.get(i).getTbProduto().getCodProduto()
                    == produto.getCodProduto()) {
                this.tbCompraProdutoList.remove(i);
                return;
            }
        }
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
        hash += (codCompra != null ? codCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCompra)) {
            return false;
        }
        TbCompra other = (TbCompra) object;
        if ((this.codCompra == null && other.codCompra != null) || (this.codCompra != null && !this.codCompra.equals(other.codCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbCompra[ codCompra=" + codCompra + " ]";
    }
    
}
