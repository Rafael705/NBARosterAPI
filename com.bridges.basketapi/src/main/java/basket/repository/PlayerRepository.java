package basket.repository;

import basket.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByPositionIgnoreCase(String position);
    List<Player> findByTeamNameIgnoreCase(String teamName);
    List<Player> findByPointsAverageGreaterThan(BigDecimal min);
    List<Player> findByAgeBetween(int min, int max);
}
