package app.vercel.matheusMangueira.RadioWorldConnect.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_radio")
@EqualsAndHashCode(of = "id")
public class RadioModel {

   @Id
   @GeneratedValue(generator = "UUID")
   private UUID id;

   @NotBlank
   private String name;

   @NotBlank
   private String urlRadio;

   @NotBlank
   private String image;

   @NotNull
   private Double longitude;

   @NotNull
   private Double latitude;

}
