package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue
    private  Long id; //ID
    @NonNull private  String name; //姓名
    @NonNull private  String jobNumber; //工号
    @NonNull
    private Date createTime; //创建时间
    
}
