package vn.com.dsk.demo.feature.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookProposalRequest {
    @NotBlank
    private String idBook;
    @NotBlank
    private int quantity;
}
