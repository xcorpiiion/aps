package br.com.unip.aps.service;


import br.com.unip.aps.domain.Cliente;
import br.com.unip.aps.domain.Endereco;
import br.com.unip.aps.domain.Telefone;
import br.com.unip.aps.repository.IClienteRepository;
import br.com.unip.aps.repository.IEnderecoRepository;
import br.com.unip.aps.repository.ITelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CadastroService implements ICadastroService{
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private ITelefoneRepository telefoneRepository;

	@Autowired
	private IEnderecoRepository enderecoRepository;

	private Cliente cliente;

	private Endereco endereco;

	private Telefone telefone;

	@Override
	public void cadastrarEmpresa(String nome, String cnpj, String email, String senha) {
		cliente = new Cliente();
		cliente.setCnpj(cnpj);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		clienteRepository.save(cliente);
	}

	@Override
	public void cadastrarEnderecoEmpresa(String rua, String complemento, String estado, String cidade, String cep) {
		endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setComplemento(complemento);
		endereco.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setCep(cep);
		enderecoRepository.save(endereco);
	}

	@Override
	public void cadastrarTelefoneEmpresa(String numeroTelefone, String ramal) {
		telefone = new Telefone();
		telefone.setRamal(ramal);
		telefone.setTelefone(numeroTelefone);
		telefoneRepository.save(telefone);
	}
}
