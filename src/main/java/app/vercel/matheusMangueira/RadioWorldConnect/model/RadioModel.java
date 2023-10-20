package app.vercel.matheusMangueira.RadioWorldConnect.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "tb_radio")
@EqualsAndHashCode(of = "id")
public class RadioModel {

   @Id
   @GeneratedValue(generator = "UUID")
   private UUID id;

}
