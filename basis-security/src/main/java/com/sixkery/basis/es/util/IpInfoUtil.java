package com.sixkery.basis.es.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip 操作
 * @author: sixkery
 * @date:2021/3/21
 */
@Slf4j
@Component
public class IpInfoUtil {

    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip ==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("127.0.0.1".equals(ip)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    log.warn(e.toString());
                }
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        return ip;
    }

    /**
     * 获取IP返回地理信息
     * @param
     * @return
     */
    public String getIpCity(HttpServletRequest request) {

        String url = "https://apis.map.qq.com/ws/location/v1/ip?key=" + key + "&ip=" + getIpAddr(request);
        String result = "未知";
        try {
            String json = HttpUtil.get(url, 3000);
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            String status = jsonObject.get("status").getAsString();
            if ("0".equals(status)) {
                JsonObject adInfo = jsonObject.get("result").getAsJsonObject().get("ad_info").getAsJsonObject();
                String nation = adInfo.get("nation").getAsString();
                String province = adInfo.get("province").getAsString();
                String city = adInfo.get("city").getAsString();
                String district = adInfo.get("district").getAsString();
                if (StrUtil.isNotBlank(nation) && StrUtil.isBlank(province)) {
                    result = nation;
                } else {
                    result = province;
                    if (StrUtil.isNotBlank(city)) {
                        result += " " + city;
                    }
                    if (StrUtil.isNotBlank(district)) {
                        result += " " + district;
                    }
                }
            }
        } catch (Exception e) {
            log.info("获取IP地理信息失败");
        }
        return result;
    }

    public void getUrl(HttpServletRequest request) {

        try {
            String url = request.getRequestURL().toString();
            asyncUtil.getUrl(url);
        } catch (Exception e) {
            log.warn(e.toString());
        }
    }

    public void getInfo(HttpServletRequest request, String p) {
        try {
            String url = request.getRequestURL().toString();
            asyncUtil.getInfo(url, p);
        } catch (Exception e) {
            log.warn(e.toString());
        }
    }
}
