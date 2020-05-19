package br.com.unip.aps.service;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.domain.Ong;
import br.com.unip.aps.repository.IOngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OngService implements IOngService {

    @Autowired
    private IOngRepository ongRepository;

    @Override
    public Ong findById(Long id) {
        if(ongRepository.findOne(id) == null) {
            return null;
        }
        return ongRepository.findOne(id);
    }
}
