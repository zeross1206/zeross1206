package com.scar.test.repository;

import com.scar.test.domain.Image;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Image entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("select image from Image image where image.user_image.login = ?#{principal.username}")
    List<Image> findByUser_imageIsCurrentUser();
}
