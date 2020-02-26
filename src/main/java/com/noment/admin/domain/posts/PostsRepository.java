package com.noment.admin.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /*
        보통 myBatis 등에서 Dao라 불리는 DB Layer 접근자.
        JPA에선 Repository라 불리며 인터페이스로 생성한다.
        <Entity클래스, PK타입>으로 상속하면 기본적인 CRUD 메소드가 자동으로 생성.
    */

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
