package br.com.psoa.notepadapi.controller

import br.com.psoa.notepadapi.model.Nota
import br.com.psoa.notepadapi.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
class NotaController {

    @Autowired
    lateinit var notaService : NotaService

    @GetMapping
    fun buscarTodos() : List<Nota> {
        return notaService.buscarTodas()
    }
    @GetMapping (value = "/titulo/{titulo}")
    fun buscar(@PathVariable (value = "titulo") titulo : String) : Nota {
        return notaService.buscar(titulo)
    }

    @PostMapping
    fun salser (@RequestBody nota: Nota) {
        notaService.salvar(nota)
    }
}