
package com.viptech.javaWeb.Data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThomasGrahamRepository extends JpaRepository<ThomasGraham,Integer>{
    ThomasGraham findByContrato(String contrato);
}
