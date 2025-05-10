package basket.controller;

import basket.model.Player;
import basket.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Player> criar(@RequestBody Player p) {
        return new ResponseEntity<>(service.salvar(p), HttpStatus.CREATED);
    }

    @GetMapping("/position/{position}")
    public List<Player> buscarPorPosicao(@PathVariable String position) {
        return service.buscarPorPosicao(position);
    }

    @GetMapping("/team/{teamName}")
    public List<Player> buscarPorTime(@PathVariable String teamName) {
        return service.buscarPorTime(teamName);
    }

    @GetMapping("/topscorers/{min}")
    public List<Player> cestinhas(@PathVariable BigDecimal min) {
        return service.buscarPorMediaPontosMaiorQue(min);
    }

    @GetMapping("/age/{min}/{max}")
    public List<Player> buscarPorIdadeEntre(@PathVariable int min, @PathVariable int max) {
        return service.buscarPorIdadeEntre(min, max);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> atualizar(@PathVariable Long id, @RequestBody Player p) {
        Player atualizado = service.atualizar(id, p);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
