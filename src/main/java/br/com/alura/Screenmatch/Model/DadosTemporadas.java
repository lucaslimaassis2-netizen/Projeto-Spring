package br.com.alura.Screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DadosTemporadas(@JsonAlias("Season") Integer numero,
                              @JsonAlias("Episodes") List<DadosEpisodios> episodios) {
}
