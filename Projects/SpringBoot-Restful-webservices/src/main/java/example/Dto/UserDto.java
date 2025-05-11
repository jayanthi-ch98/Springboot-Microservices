package example.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        description="User information about "
)
//creating a data transfer object for the entity class User for the security purpose instead of JPA
public class UserDto {

    @Schema(
            description = "unique id for the User DTO"
    )
    private Long id;
    //Adding Validations for fields in api Request
    @Schema(
            description = "Field for the FirstName"
    )
    @NotEmpty
    private String FirstName;
    @NotEmpty
    @Schema(
            description = "Field for the LastName"
    )
    private String LastName;
    @NotEmpty
    @Schema(
            description = "Field for the Email"
    )
    private String email;

}
