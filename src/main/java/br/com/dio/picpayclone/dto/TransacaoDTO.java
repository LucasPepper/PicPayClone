package br.com.dio.picpayclone.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.diopicpayclone.enums.TipoTransacao;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class TransacaoDTO {

	@NotBlank
	private String codigo;

	@NotNull
	private UsuarioDTO origem;

	@NotNull
	private UsuarioDTO destino;

	@NotNull
	private LocalDateTime dataHora;

	@NotNull
	private Double valor;

	@NotNull
	private CartaoCreditoDTO cartaoCredito;

	@NotBlank
	private TipoTransacao tipoTransacao;

}