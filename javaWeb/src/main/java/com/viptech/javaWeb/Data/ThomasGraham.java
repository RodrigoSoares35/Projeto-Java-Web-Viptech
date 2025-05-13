
package com.viptech.javaWeb.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="thomasgraham")
public class ThomasGraham {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String empresarial;
    private String contrato;
    private String sala;
    private String Cliente;
    private String ramal;
    private String tipo;
    private String plano;
    private String Status;
    private String dataInstalacao;
    private String observacao;
    
}
