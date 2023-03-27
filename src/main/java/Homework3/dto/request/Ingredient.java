package Homework3.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@@ -13,6 +13,6 @@
public class Ingredient {

    @JsonProperty("name")
    public String name;
    private String name;

}
