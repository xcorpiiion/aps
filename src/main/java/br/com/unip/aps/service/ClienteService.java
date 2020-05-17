package br.com.unip.aps.service;

import br.com.unip.aps.domain.Cliente;
import br.com.unip.aps.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Cliente findById(Long id) {
        if(clienteRepository.findOne(id) == null) {
            return null;
        }
        return clienteRepository.findOne(id);
    }
}
