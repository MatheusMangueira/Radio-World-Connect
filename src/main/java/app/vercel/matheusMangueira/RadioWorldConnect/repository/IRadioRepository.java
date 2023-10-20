package app.vercel.matheusMangueira.RadioWorldConnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.vercel.matheusMangueira.RadioWorldConnect.model.RadioModel;

public interface IRadioRepository extends JpaRepository<RadioModel, Long> {

      boolean existsByName(String name);

      @Query("SELECT r FROM radio r WHERE r.name LIKE %:name%")
      List<RadioModel> findByPartialName(@Param("name") String name);
}
