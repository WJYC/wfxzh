package com.qianfeng.merchant.service.impl;

import com.qianfeng.merchant.mapper.ImagesMapper;
import com.qianfeng.merchant.po.TbImages;
import com.qianfeng.merchant.service.IImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImagesServiceImpl implements IImagesService {
    @Autowired
    private ImagesMapper imagesMapper;



    @Override
    public Integer addImage(TbImages tbImages)throws Exception {
        return imagesMapper.addImage(tbImages);
    }

    @Override
    public TbImages queryImageExistByMD5(String md5) {
        List<TbImages> tbImages = imagesMapper.queryImageExistByMD5(md5);
        if (null== tbImages || tbImages.isEmpty()) {
            return null;
        }
        return tbImages.get(0);
    }

    @Override
    public void updateImageType(String imageType, String fkId, String imageId) {
        imagesMapper.updateImageType(imageType, fkId, imageId);
    }
}
