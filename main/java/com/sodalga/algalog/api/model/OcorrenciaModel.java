package com.sodalga.algalog.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class OcorrenciaModel {

	
	
	private long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
}
