package com.project.sns.repository;

import com.project.sns.model.entity.CommentEntity;
import com.project.sns.model.entity.LikeEntity;
import com.project.sns.model.entity.PostEntity;
import com.project.sns.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentEntityRepository extends JpaRepository<CommentEntity, Integer> {

    Page<CommentEntity> findAllByPost(PostEntity post, Pageable pageable);

//    void deleteAllByPost(PostEntity post);

    @Transactional
    @Modifying
    @Query("UPDATE CommentEntity entity SET deleted_at = NOW() where entity.post = :post")
    void deleteAllByPost(@Param("post") PostEntity postEntity);

}
