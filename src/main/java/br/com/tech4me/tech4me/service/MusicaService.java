package br.com.tech4me.tech4me.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4me.model.Musica;
import br.com.tech4me.tech4me.shared.MusicaDTO;

public interface MusicaService {
    MusicaDTO criarMusica(Musica musica);
    List<MusicaDTO> obterTodos();
    Optional<MusicaDTO> obterPorId(String id);
    void removerMusica(String id);
    MusicaDTO atualizarMusica(String id, Musica musicaNew);
}
