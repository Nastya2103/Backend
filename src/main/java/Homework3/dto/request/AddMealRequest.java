package Homework3.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@@ -20,14 +20,14 @@
public class AddMealRequest {

    @JsonProperty("date")
    public Integer date;
    private Integer date;
    @JsonProperty("slot")
    public Integer slot;
    private Integer slot;
    @JsonProperty("position")
    public Integer position;
    private Integer position;
    @JsonProperty("type")
    public String type;
    private String type;
    @JsonProperty("value")
    public Value value;
    private Value value;

}
