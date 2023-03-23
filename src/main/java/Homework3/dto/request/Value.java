package Homework3.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@@ -15,6 +15,6 @@
public class Value {

    @JsonProperty("ingredients")
    public List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

}
