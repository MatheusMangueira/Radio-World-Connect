package app.vercel.matheusMangueira.RadioWorldConnect.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.vercel.matheusMangueira.RadioWorldConnect.dtos.RadioDto;
import app.vercel.matheusMangueira.RadioWorldConnect.dtos.mapper.RadioMapper;
import app.vercel.matheusMangueira.RadioWorldConnect.model.RadioModel;
import app.vercel.matheusMangueira.RadioWorldConnect.repository.IRadioRepository;
import jakarta.transaction.Transactional;

@Service
public class RadioService {

   private final IRadioRepository radioRepository;

   public RadioService(IRadioRepository radioRepository) {
      this.radioRepository = radioRepository;
   }

   @Transactional
   public RadioModel save(RadioDto radioDto) {
      validadeSave(radioDto);
      return radioRepository.save(RadioMapper.toEntity(radioDto));
   }

   public List<RadioModel> findByPartialName(String name) {
      List<RadioModel> all = radioRepository.findByPartialName(name);

      if (all.isEmpty()) {
         throw new RuntimeException("Radio not found");
      }

      return all;
   }

   public Page<RadioModel> findAll(Pageable pageable) {
      return radioRepository.findAll(pageable);
   }

   public void validadeSave(RadioDto radio) {
      if (radioRepository.existsByName(
            radio.getName()))

         throw new RuntimeException("Radio already exists");

   }
}
