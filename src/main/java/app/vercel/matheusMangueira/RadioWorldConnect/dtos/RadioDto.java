package app.vercel.matheusMangueira.RadioWorldConnect.dtos;

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

   Long id;

   @NotBlank
   @Length(min = 3, max = 50)
   String name;

   @NotBlank
   String urlRadio;

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
