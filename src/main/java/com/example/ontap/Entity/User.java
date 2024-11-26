package com.example.ontap.Entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String userName;
    private String pass;
    private String role;

    public static List<User> listus = new ArrayList<>();

    static {
        listus.add(new User("nguyenvv4","12345" ,"admin"));
        listus.add(new User("manhpdph49571" , "manh1234" , "staff"));
        listus.add(new User("staff2","staff123","staff"));
    }

}
