package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    public static RequestSpecification jsonRequestSpec (){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build(); // Връщаме инстанцията на RequestSpecification след конфигурирането
    }
}
