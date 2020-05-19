package br.com.unip.aps.service;


import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.domain.Endereco;
import br.com.unip.aps.domain.Ong;
import br.com.unip.aps.domain.Telefone;
import br.com.unip.aps.repository.IEmpresaRepository;
import br.com.unip.aps.repository.IEnderecoRepository;
import br.com.unip.aps.repository.IOngRepository;
import br.com.unip.aps.repository.ITelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CadastroService implements ICadastroService{
	
	@Autowired
	private IEmpresaRepository empresaRepository;

	@Autowired
	private IOngRepository ongRepository;

	@Autowired
	private ITelefoneRepository telefoneRepository;

	@Autowired
	private IEnderecoRepository enderecoRepository;


	@Override
	public void cadastrarEmpresa(Empresa empresa) {
		telefoneRepository.save(empresa.getTelefone());
		enderecoRepository.save(empresa.getEndereco());
		empresaRepository.save(empresa);
	}

	@Override
	public void cadastrarOng(Ong ong) {
		telefoneRepository.save(ong.getTelefone());
		enderecoRepository.save(ong.getEndereco());
		ongRepository.save(ong);
	}
}
