package com.sparta.test.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id; // 게시글 번호

    @Column(unique = true)
    private String title; // 게시글 제목


    @Column(length = 200)
    private String content; // 게시글 내용

    private Integer price; // 아이템 가격

    private String username; // 작성자

}
