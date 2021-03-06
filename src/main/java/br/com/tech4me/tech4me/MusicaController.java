package br.com.tech4me.tech4me;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4me.model.Musica;
import br.com.tech4me.tech4me.service.MusicaService;
import br.com.tech4me.tech4me.shared.MusicaDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/tech4music")
public class MusicaController {
    @Autowired
    private MusicaService servico;

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> obterMusicas(){
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicaDTO> obterPorId(@PathVariable String id){
        Optional<MusicaDTO> music = servico.obterPorId(id);

        if(music.isPresent()){
            return new ResponseEntity<>(music.get(),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaDTO> criarMusica (@RequestBody @Valid Musica musica) {
        return new ResponseEntity<>(servico.criarMusica(musica), HttpStatus.CREATED);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removerMusica(@PathVariable String id){
        Optional<MusicaDTO> music = servico.obterPorId(id);

        if(music.isPresent()){
            servico.removerMusica(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDTO> atualizrMusica(@PathVariable String id, @RequestBody Musica musicaNew){
        return new ResponseEntity<>(servico.atualizarMusica(id, musicaNew), HttpStatus.OK);
    }

}