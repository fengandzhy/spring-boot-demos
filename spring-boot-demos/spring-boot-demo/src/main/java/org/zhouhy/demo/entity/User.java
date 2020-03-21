package org.zhouhy.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name ="t_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date regDate;

    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;
}
