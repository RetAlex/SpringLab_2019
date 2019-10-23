package oleksii.epam.lab.spring2019.springdemoback.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity(name = "secrets")
@Table(name = "secrets2")
public class Secret {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "secret")
    private String secret;

    public Secret() {
    }
}
