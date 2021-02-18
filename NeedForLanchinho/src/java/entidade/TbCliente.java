/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tb_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t")
    , @NamedQuery(name = "TbCliente.findByCodCliente", query = "SELECT t FROM TbCliente t WHERE t.codCliente = :codCliente")
    , @NamedQuery(name = "TbCliente.findByEmail", query = "SELECT t FROM TbCliente t WHERE t.email = :email")
    , @NamedQuery(name = "TbCliente.findBySenha", query = "SELECT t FROM TbCliente t WHERE t.senha = :senha")
    , @NamedQuery(name = "TbCliente.findByNomeCompleto", query = "SELECT t FROM TbCliente t WHERE t.nomeCompleto = :nomeCompleto")
    , @NamedQuery(name = "TbCliente.findByCpf", query = "SELECT t FROM TbCliente t WHERE t.cpf = :cpf")
    , @NamedQuery(name = "TbCliente.findByDataNascimento", query = "SELECT t FROM TbCliente t WHERE t.dataNascimento = :dataNascimento")})
public class TbCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cliente")
    private Integer codCliente;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @JoinTable(name = "tb_endereco_cliente", joinColumns = {
        @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_endereco", referencedColumnName = "cod_endereco")})
    @ManyToMany
    private List<TbEndereco> tbEnderecoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCliente")
    private List<TbCompra> tbCompraList;

    public TbCliente() {
    }

    public TbCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public TbCliente(Integer codCliente, String email, String senha, String nomeCompleto, String cpf) {
        this.codCliente = codCliente;
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @XmlTransient
    public List<TbEndereco> getTbEnderecoList() {
        return tbEnderecoList;
    }

    public void setTbEnderecoList(List<TbEndereco> tbEnderecoList) {
        this.tbEnderecoList = tbEnderecoList;
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
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCliente)) {
            return false;
        }
        TbCliente other = (TbCliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbCliente[ codCliente=" + codCliente + " ]";
    }
    
}
