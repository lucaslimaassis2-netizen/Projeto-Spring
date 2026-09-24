package br.com.alura.Screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosEpisodios(@JsonAlias("Title") String titulo,
                             @JsonAlias("Episode") Integer numeroEp,
                             @JsonAlias("imdbRating") String avaliacao,
                             @JsonAlias("Released")String dataLancamento) {
}
