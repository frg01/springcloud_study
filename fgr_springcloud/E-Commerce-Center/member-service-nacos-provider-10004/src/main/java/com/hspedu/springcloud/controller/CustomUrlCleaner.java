package com.hspedu.springcloud.controller;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Component
public class CustomUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String originUrl) {//资源清洗

        //isBlank判断不为null,有长度，不是全部为空格
        if (StringUtils.isBlank(originUrl)){
            return originUrl;
        }
        if (originUrl.startsWith("/member/get")){//得到的url以/member/get开头，进行处理
            // /member/get开头 就返回以下资源名
            // 流控规则以下面为配置标准
            return "/member/get/*";
        }
        return originUrl;
    }
}
