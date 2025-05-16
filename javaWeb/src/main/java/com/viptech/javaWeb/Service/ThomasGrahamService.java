
package com.viptech.javaWeb.Service;

import com.viptech.javaWeb.Data.ThomasGraham;
import com.viptech.javaWeb.Data.ThomasGrahamRepository;
import com.viptech.javaWeb.Exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThomasGrahamService {
    @Autowired
    private ThomasGrahamRepository tgRepository;

    public ThomasGraham criarThomasGraham( ThomasGraham tg) {
        tg.setId(null);
        return tgRepository.save(tg);
    
    }
    public ThomasGraham atualizarThomasGraham(Integer tgId, ThomasGraham tgRequest) {

        ThomasGraham tg = getThomasGrahamId(tgId);

        tg.setEmpresarial(tgRequest.getEmpresarial());

        tg.setContrato(tgRequest.getContrato());

        tg.setSala(tgRequest.getSala());

        tg.setCliente(tgRequest.getCliente());
        
        tg.setRamal(tgRequest.getRamal());
        
        tg.setTipo(tgRequest.getTipo());
        
        tg.setPlano(tgRequest.getPlano());
        
        tg.setStatus(tgRequest.getStatus());
        
        tg.setDataInstalacao(tgRequest.getDataInstalacao());
        
        tg.setObservacao(tgRequest.getObservacao());
        
        return tgRepository.save(tg);

    }
      public List<ThomasGraham> listarTodosThomasGraham() {
    return tgRepository.findAll();

    }
     public ThomasGraham getThomasGrahamId(Integer tgId) {

     return tgRepository.findById(tgId).orElseThrow(()
     -> new ResourceNotFoundException("Usuario não encontrado " + tgId));

    }
      
      public List<ThomasGraham> getTodosThomasGraham() {
        return tgRepository.findAll();
    }
   public List<ThomasGraham> buscarPorContrato(String contrato) {
        return tgRepository.findByContratoContaining(contrato);
    }
      
      /*  FUNÇÃO BUSCAR ID
      FUNÇÃO DELETAR INATIVA
       public void deletarThomasGraham(Integer tgId) {

        ThomasGraham tg = getThomasGrahamId(tgId);

        tgRepository.deleteById(tg.getId());

    }
    */
    
}
