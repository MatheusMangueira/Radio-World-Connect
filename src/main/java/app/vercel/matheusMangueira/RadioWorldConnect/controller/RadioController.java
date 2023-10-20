package app.vercel.matheusMangueira.RadioWorldConnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import app.vercel.matheusMangueira.RadioWorldConnect.model.RadioModel;
import app.vercel.matheusMangueira.RadioWorldConnect.service.RadioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("radio")
public class RadioController {

   @Autowired
   private RadioService radioService;

   @PostMapping("/create")
   public ResponseEntity<RadioDto> create(@Valid @RequestBody RadioDto radioModel) {

      var radio = radioService.save(radioModel);

      return ResponseEntity.status(HttpStatus.CREATED).body(RadioMapper.toDto(radio));
   }

   @GetMapping("/all")
   public ResponseEntity<List<RadioModel>> getAll() {
      var radios = radioService.findAll();
      return ResponseEntity.status(HttpStatus.OK).body(radios);
   }

   @GetMapping("/filter")
   public ResponseEntity<List<RadioModel>> getByPartialName(@RequestParam("name") String name) {
      List<RadioModel> radios = radioService.findByPartialName(name);
      return ResponseEntity.status(HttpStatus.OK).body(radios);
   }
}