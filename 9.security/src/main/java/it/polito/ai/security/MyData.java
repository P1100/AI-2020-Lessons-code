package it.polito.ai.security;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MyData {
    String name;
    Date date;
//    List<String> roles;
}
