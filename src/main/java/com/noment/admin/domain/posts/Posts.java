package com.noment.admin.domain.posts;


import com.noment.admin.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드에 getter 메소드 생성
@NoArgsConstructor // 기본 생성자 자동 추가 , public Posts(){}와 같은 효과
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙
    private Long id;

    @Column(length = 500 , nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성 , 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    /*
        Setter 메소드를 생성하지 않은 이유
        - 해당 클래스의 인스턴스의 값들이 언제 어디서 변해야 하는지 구분 할 수 없음.
        - 변경 및 유지관리 복잡.
        - 따라서, Entity 클래스에서는 setter 메소드를 생성하지 않음.

        => Q. 어떻게 값을 채워서 DB에 INSERT 할 것 인가?
           A. 빌더 어노테이션을 통해 제공되는 빌더 클래스사용.
    */
}
