
package com.viptech.javaWeb.Data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThomasGrahamRepository extends JpaRepository<ThomasGraham,Integer>{
     
      List<ThomasGraham> findByContratoContaining(String contrato);
      List<ThomasGraham> findByRamalContaining(String ramal);
      List<ThomasGraham> findByStatusContaining(String status);

}
