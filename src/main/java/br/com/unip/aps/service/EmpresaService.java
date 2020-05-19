package br.com.unip.aps.service;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.repository.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService implements IEmpresaService {

    @Autowired
    private IEmpresaRepository empresaRepository;

    @Override
    public Empresa findById(Long id) {
        if(empresaRepository.findOne(id) == null) {
            return null;
        }
        return empresaRepository.findOne(id);
    }
}
