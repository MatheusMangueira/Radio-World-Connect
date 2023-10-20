package app.vercel.matheusMangueira.RadioWorldConnect.dtos.mapper;

import app.vercel.matheusMangueira.RadioWorldConnect.dtos.RadioDto;
import app.vercel.matheusMangueira.RadioWorldConnect.model.RadioModel;

public class RadioMapper {

   private RadioMapper() {
   }

   public static RadioDto toDto(RadioModel radioModel) {
      if (radioModel == null) {

         return null;
      }
      var radioDto = new RadioDto();

      radioDto.setId(radioModel.getId());
      radioDto.setName(radioModel.getName());
      radioDto.setUrlRadio(radioModel.getUrlRadio());
      radioDto.setImage(radioModel.getImage());
      radioDto.setLongitude(radioModel.getLongitude());
      radioDto.setLatitude(radioModel.getLatitude());

      return radioDto;
   }

     public static RadioModel toEntity(RadioDto radioDto) {
      if (radioDto == null)
         return null;
      var radioModel = new RadioModel();
   
      radioModel.setId(radioDto.getId());
      radioModel.setName(radioDto.getName());
      radioModel.setUrlRadio(radioDto.getUrlRadio());
      radioModel.setImage(radioDto.getImage());
      radioModel.setLongitude(radioDto.getLongitude());
      radioModel.setLatitude(radioDto.getLatitude());
   
      return radioModel;
   }
   
}
