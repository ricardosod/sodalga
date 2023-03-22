package com.sodalga.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sodalga.algalog.domain.exception.NegocioException;
import com.sodalga.algalog.domain.model.Entrega;
import com.sodalga.algalog.domain.model.Ocorrencia;
import com.sodalga.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

	
	private BuscaEntregaService buscaEntregaService;
	
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
		
	}
}
