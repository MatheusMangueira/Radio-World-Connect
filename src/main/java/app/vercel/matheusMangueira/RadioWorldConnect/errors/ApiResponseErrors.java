package app.vercel.matheusMangueira.RadioWorldConnect.errors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ApiResponseErrors<T> {
   private String message;
   private T data;

   public ApiResponseErrors(String message, T data) {
      this.message = message;
      this.data = data;
   }

}
