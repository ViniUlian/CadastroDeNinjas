package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "idade")
    private int idade;

    @Column (name = "img_url")
    private String imgUrl;

    @Column(unique = true)
    private String email;

    @Column(name = "rank")
    private String rank;

    // @ManyToOne um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing key
    private MissoesModel missoes;


}
