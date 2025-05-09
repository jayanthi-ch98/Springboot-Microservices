package example.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//creating a data transfer object for the entity class User for the security purpose instead of JPA
public class UserDto {

    private Long id;

    //Adding Validations for fields in api Request
    @NotEmpty
    private String FirstName;
    @NotEmpty
    private String LastName;
    @NotEmpty
    private String email;

}
