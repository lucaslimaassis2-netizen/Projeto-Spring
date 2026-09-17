package br.com.alura.Screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadoSerie(@JsonAlias("Title") String titulo,
                        @JsonAlias("totalSeasons") Integer totalTemporadas,
                        @JsonAlias("imdbRating") String avaliacao) {

}
