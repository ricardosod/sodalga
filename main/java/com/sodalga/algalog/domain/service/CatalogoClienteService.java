package com.sodalga.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sodalga.algalog.domain.exception.NegocioException;
import com.sodalga.algalog.domain.model.Cliente;
import com.sodalga.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

	
	private ClienteRepository clienteRepository; 
	
	public Cliente buscar(Long clienteId) {
	return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
	}
	
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		    
		if (emailEmUso) {
			throw new NegocioException("já existe um cliente cadastrado com este e-mail");
		}
		
		return clienteRepository.save(cliente);
	}
	
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}

