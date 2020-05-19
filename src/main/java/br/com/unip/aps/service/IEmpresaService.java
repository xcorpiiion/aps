package br.com.unip.aps.service;

import br.com.unip.aps.domain.Empresa;

public interface IEmpresaService {

    Empresa findById(Long id);

}
