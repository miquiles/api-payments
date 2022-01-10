package api.checkout.payments.backend.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String complement;
    private String street;
    private String zipCode;
    private String number;
    private String city;
    private String state;
    private String district;

}
