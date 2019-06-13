package com.qianfeng.merchant.service;

import com.qianfeng.merchant.po.TbImages;

public interface IImagesService {

    Integer addImage(TbImages tbImages)throws Exception;

    TbImages queryImageExistByMD5( String md5);

    void updateImageType( String imageType, String fkId, String imageId);

}
