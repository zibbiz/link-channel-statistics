/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2016-2026 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2019年6月4日
 *******************************************************************************/


package com.bzlue.askcrab.link.channel.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTemplateService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public boolean set(String key , String value){

        try {

            //任意类型转换成String
            String val = value;

            if(val==null||val.length()<=0){
                return false;
            }

            stringRedisTemplate.opsForValue().set(key,val);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean incr(String key, long value) {

        try {
            stringRedisTemplate.opsForValue().increment(key, value);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public String get(String key) {

        try {
            return stringRedisTemplate.opsForValue().get(key);
        }catch (Exception e){
            return null;
        }
    }

}