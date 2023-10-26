package app.vercel.matheusMangueira.RadioWorldConnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.vercel.matheusMangueira.RadioWorldConnect.dtos.RadioDto;
import app.vercel.matheusMangueira.RadioWorldConnect.dtos.mapper.RadioMapper;
import app.vercel.matheusMangueira.RadioWorldConnect.errors.ApiResponseErrors;
import app.vercel.matheusMangueira.RadioWorldConnect.model.RadioModel;
import app.vercel.matheusMangueira.RadioWorldConnect.service.RadioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("radio")
public class RadioController {

   @Autowired
   private RadioService radioService;

   @PostMapping("/create")
   public ResponseEntity<ApiResponseErrors<RadioDto>> create(@Valid @RequestBody RadioDto radioModel,
         Pageable pageable) {
      Page<RadioModel> page = radioService.findAll(pageable);
      long totalElements = page.getTotalElements();

      if (totalElements >= 1000) {
         System.out.println(totalElements + " Limite de rádios atingido");
         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
               .body(new ApiResponseErrors<>("Limite de estações atingida", null));
      }

      var radio = radioService.save(radioModel);

      return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ApiResponseErrors<>("Estação criada com sucesso!", RadioMapper.toDto(radio)));
   }

   @GetMapping("/all")
   public ResponseEntity<Page<RadioModel>> getAll(@RequestParam(required = false) Integer page,
         @RequestParam(required = false) Integer size) {

      Page<RadioModel> radios;

      if (page != null && size != null) {
         Pageable pageable = PageRequest.of(page, size);
         radios = radioService.findAll(pageable);
      } else {
         radios = radioService.findAll(Pageable.unpaged());
      }

      return ResponseEntity.status(HttpStatus.OK).body(radios);
   }

   @GetMapping("/filter")
   public ResponseEntity<List<RadioModel>> getByPartialName(@RequestParam("name") String name) {
      List<RadioModel> radios = radioService.findByPartialName(name);
      return ResponseEntity.status(HttpStatus.OK).body(radios);
   }
}