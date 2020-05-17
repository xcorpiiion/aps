package br.com.unip.aps.service;

import br.com.unip.aps.domain.Cliente;

public interface IClienteService {

    Cliente findById(Long id);

}
