package basket.service;

import basket.model.Player;
import basket.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository repo;

    public PlayerService(PlayerRepository repo) {
        this.repo = repo;
    }

    public List<Player> listarTodos() {
        return repo.findAll();
    }

    public Player salvar(Player p) {
        return repo.save(p);
    }

    public List<Player> buscarPorPosicao(String position) {
        return repo.findByPositionIgnoreCase(position);
    }

    public List<Player> buscarPorTime(String teamName) {
        return repo.findByTeamNameIgnoreCase(teamName);
    }

    public List<Player> buscarPorMediaPontosMaiorQue(BigDecimal min) {
        return repo.findByPointsAverageGreaterThan(min);
    }

    public List<Player> buscarPorIdadeEntre(int min, int max) {
        return repo.findByAgeBetween(min, max);
    }

    public List<Player> cestinhas(BigDecimal min){
        return repo.findByPointsAverageGreaterThan(min);
    }

    public Player atualizar(Long id, Player novo) {
        Optional<Player> existente = repo.findById(id);
        if (existente.isPresent()) {
            Player p = existente.get();
            p.setName(novo.getName());
            p.setAge(novo.getAge());
            p.setPosition(novo.getPosition());
            p.setTeamName(novo.getTeamName());
            p.setPointsAverage(novo.getPointsAverage());
            return repo.save(p);
        } else {
            throw new RuntimeException("Player com ID " + id + " não encontrado.");
        }
    }

    public void deletar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Player com ID " + id + " não encontrado.");
        }
    }
}
