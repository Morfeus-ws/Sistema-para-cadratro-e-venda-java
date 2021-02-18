/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "tb_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEndereco.findAll", query = "SELECT t FROM TbEndereco t")
    , @NamedQuery(name = "TbEndereco.findByCodEndereco", query = "SELECT t FROM TbEndereco t WHERE t.codEndereco = :codEndereco")
    , @NamedQuery(name = "TbEndereco.findByCep", query = "SELECT t FROM TbEndereco t WHERE t.cep = :cep")
    , @NamedQuery(name = "TbEndereco.findByCidade", query = "SELECT t FROM TbEndereco t WHERE t.cidade = :cidade")
    , @NamedQuery(name = "TbEndereco.findByBairro", query = "SELECT t FROM TbEndereco t WHERE t.bairro = :bairro")
    , @NamedQuery(name = "TbEndereco.findByRua", query = "SELECT t FROM TbEndereco t WHERE t.rua = :rua")
    , @NamedQuery(name = "TbEndereco.findByNumero", query = "SELECT t FROM TbEndereco t WHERE t.numero = :numero")
    , @NamedQuery(name = "TbEndereco.findByComplemento", query = "SELECT t FROM TbEndereco t WHERE t.complemento = :complemento")})
public class TbEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_endereco")
    private Integer codEndereco;
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @ManyToMany(mappedBy = "tbEnderecoList")
    private List<TbCliente> tbClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEndereco")
    private List<TbCompra> tbCompraList;

    public TbEndereco() {
    }

    public TbEndereco(Integer codEndereco) {
        this.codEndereco = codEndereco;
    }

    public TbEndereco(Integer codEndereco, String cidade, String bairro, String rua, String numero) {
        this.codEndereco = codEndereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Integer codEndereco) {
        this.codEndereco = codEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @XmlTransient
    public List<TbCliente> getTbClienteList() {
        return tbClienteList;
    }

    public void setTbClienteList(List<TbCliente> tbClienteList) {
        this.tbClienteList = tbClienteList;
    }

    @XmlTransient
    public List<TbCompra> getTbCompraList() {
        return tbCompraList;
    }

    public void setTbCompraList(List<TbCompra> tbCompraList) {
        this.tbCompraList = tbCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEndereco != null ? codEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEndereco)) {
            return false;
        }
        TbEndereco other = (TbEndereco) object;
        if ((this.codEndereco == null && other.codEndereco != null) || (this.codEndereco != null && !this.codEndereco.equals(other.codEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbEndereco[ codEndereco=" + codEndereco + " ]";
    }
    
}
