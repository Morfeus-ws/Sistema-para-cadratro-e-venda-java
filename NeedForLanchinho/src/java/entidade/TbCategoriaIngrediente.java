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
@Table(name = "tb_categoria_ingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCategoriaIngrediente.findAll", query = "SELECT t FROM TbCategoriaIngrediente t")
    , @NamedQuery(name = "TbCategoriaIngrediente.findByCodCategoriaIngrediente", query = "SELECT t FROM TbCategoriaIngrediente t WHERE t.codCategoriaIngrediente = :codCategoriaIngrediente")
    , @NamedQuery(name = "TbCategoriaIngrediente.findByCategoriaIngrediente", query = "SELECT t FROM TbCategoriaIngrediente t WHERE t.categoriaIngrediente = :categoriaIngrediente")})
public class TbCategoriaIngrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_categoria_ingrediente")
    private Integer codCategoriaIngrediente;
    @Basic(optional = false)
    @Column(name = "categoria_ingrediente")
    private String categoriaIngrediente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCategoriaIngrediente")
    private List<TbIngrediente> tbIngredienteList;

    public TbCategoriaIngrediente() {
    }

    public TbCategoriaIngrediente(Integer codCategoriaIngrediente) {
        this.codCategoriaIngrediente = codCategoriaIngrediente;
    }

    public TbCategoriaIngrediente(Integer codCategoriaIngrediente, String categoriaIngrediente) {
        this.codCategoriaIngrediente = codCategoriaIngrediente;
        this.categoriaIngrediente = categoriaIngrediente;
    }

    public Integer getCodCategoriaIngrediente() {
        return codCategoriaIngrediente;
    }

    public void setCodCategoriaIngrediente(Integer codCategoriaIngrediente) {
        this.codCategoriaIngrediente = codCategoriaIngrediente;
    }

    public String getCategoriaIngrediente() {
        return categoriaIngrediente;
    }

    public void setCategoriaIngrediente(String categoriaIngrediente) {
        this.categoriaIngrediente = categoriaIngrediente;
    }

    @XmlTransient
    public List<TbIngrediente> getTbIngredienteList() {
        return tbIngredienteList;
    }

    public void setTbIngredienteList(List<TbIngrediente> tbIngredienteList) {
        this.tbIngredienteList = tbIngredienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCategoriaIngrediente != null ? codCategoriaIngrediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCategoriaIngrediente)) {
            return false;
        }
        TbCategoriaIngrediente other = (TbCategoriaIngrediente) object;
        if ((this.codCategoriaIngrediente == null && other.codCategoriaIngrediente != null) || (this.codCategoriaIngrediente != null && !this.codCategoriaIngrediente.equals(other.codCategoriaIngrediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbCategoriaIngrediente[ codCategoriaIngrediente=" + codCategoriaIngrediente + " ]";
    }
    
}
