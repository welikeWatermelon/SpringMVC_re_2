package hello.springmvc.basic;

import lombok.Data;

@Data
// @Getter, @Setter 를 포함하는 애노테이션
public class HelloData {
    private String username;
    private int age;
}
