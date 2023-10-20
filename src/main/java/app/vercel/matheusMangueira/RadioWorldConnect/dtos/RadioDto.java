package app.vercel.matheusMangueira.RadioWorldConnect.dtos;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import app.vercel.matheusMangueira.RadioWorldConnect.model.RadioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadioDto {

   UUID id;

   @NotBlank
   @Length(min = 3, max = 50)
   String name;

   @NotBlank
   String urlRadio;

   @NotBlank
   String image;

   @NotNull
   Double longitude;

   @NotNull
   Double latitude;

   public RadioDto(RadioModel radioModel) {
      id = radioModel.getId();
      name = radioModel.getName();
      urlRadio = radioModel.getUrlRadio();
      image = radioModel.getImage();
      longitude = radioModel.getLongitude();
      latitude = radioModel.getLatitude();
   }
}
