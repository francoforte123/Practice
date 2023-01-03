package Practices.Entitie;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "practices")
public class Practice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String numberPractice;
    private String numberIdUser;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;
    private int amount;
    private String nameUser;
    private String surnameUser;
    private boolean isDelete;
}
