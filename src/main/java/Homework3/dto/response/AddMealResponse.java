package Homework3.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@@ -15,8 +15,8 @@
public class AddMealResponse {

    @JsonProperty("status")
    public String status;
    private String status;
    @JsonProperty("id")
    public Integer id;
    private Integer id;

}