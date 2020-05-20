package br.com.unip.aps.service;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.domain.Ong;
import br.com.unip.aps.repository.IEmpresaRepository;
import br.com.unip.aps.repository.IOngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService implements ILoginService {

    @Autowired
    private IEmpresaRepository empresaRepository;

    @Autowired
    private IOngRepository ongRepository;

    @Override
    public Empresa fazerLoginEmpresa(String email, String senha) {
        for (Empresa empresas : empresaRepository.findAll()) {
            if (empresas.getEmail().equals(email) && empresas.getSenha().equals(senha)) {
                return empresas;
            }
        }
        return null;
    }

    @Override
    public Empresa retornaEmpresaLogada() {
        for (Empresa empresas : empresaRepository.findAll()) {
            if (empresas.isLogado()) {
                return empresas;
            }
        }
        return null;
    }

    @Override
    public Ong fazerLoginOng(String email, String senha) {
        for (Ong ongs : ongRepository.findAll()) {
            if (ongs.getEmail().equals(email) && ongs.getSenha().equals(senha)) {
                return ongs;
            }
        }
        return null;
    }

    @Override
    public Ong retornaOngLogada() {
        for (Ong ongs : ongRepository.findAll()) {
            if (ongs.isLogado()) {
                return ongs;
            }
        }
        return null;
    }


}
