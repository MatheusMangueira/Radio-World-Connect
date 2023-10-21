package app.vercel.matheusMangueira.RadioWorldConnect.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "radio")
@Table(name = "radio")
@EqualsAndHashCode(of = "id")
public class RadioModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank
   private String name;

   @NotBlank
   @Column(name = "url_radio")
   private String urlRadio;

   private String image;

   @NotNull
   private Double longitude;

   @NotNull
   private Double latitude;

}
