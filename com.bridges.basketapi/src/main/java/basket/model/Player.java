package basket.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String position;
    private String teamName;
    private int age;

    @Column(precision = 4, scale = 2)
    private BigDecimal pointsAverage;

    public Player(String teamName) {
        this.teamName = teamName;
    }

    // Getters e Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public BigDecimal getPointsAverage() { return pointsAverage; }
    public void setPointsAverage(BigDecimal pointsAverage) { this.pointsAverage = pointsAverage; }

    public String getTeamName() {return teamName;}

    public void setTeamName(String teamName) {this.teamName = teamName;}

}
