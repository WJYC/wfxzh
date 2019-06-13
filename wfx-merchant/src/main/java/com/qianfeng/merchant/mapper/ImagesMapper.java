package com.qianfeng.merchant.mapper;

import com.qianfeng.merchant.po.TbImages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ImagesMapper {

    Integer addImage(TbImages tbImages);

    List<TbImages> queryImageExistByMD5(@Param("imageMd5") String md5);

    void updateImageType(@Param("imageType") String imageType,@Param("fkId") String fkId,@Param("imageId") String imageId);

}
