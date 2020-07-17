package com.sixkery.access;

import com.sixkery.SecurityContextHolder;
import com.sixkery.common.ResponseModels;
import com.sixkery.authentication.UserDetails;
import com.sixkery.authentication.token.Authentication;
import com.sixkery.util.AntPathRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author sixkery
 */
public class FilterSecurityInterceptor extends GenericFilterBean {

    /**
     * 认证过的数组
     */
    private String[] authenticated;

    private AuthorizeService authorizeService;

    /**
     * 权限
     */
    private Map<String, List<String>> permissions;

    private List<String> permissionValues = new ArrayList<>();

    private List<String> protectResources = new ArrayList<>();

    public void initialization() {
        // 从角色权限配置中拿到所有受保护的资源
        if (permissions != null) {
            permissions.values().forEach(permissionValues::addAll);
            protectResources.addAll(permissionValues);
        }
        // 配置文件中显示声明需要登录才可访问的资源
        if (authenticated != null) {
            protectResources.addAll(Arrays.asList(authenticated));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (!requires((HttpServletRequest) request)) {
            chain.doFilter(request, response);
            return;
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {
            // throw new AccessDeniedException("Unauthorized");
            ResponseModels.unauthorized((HttpServletResponse) response);
            return;
        }

        boolean hasPerm = true;

        // 优先使用自定义权限判断
        if (authorizeService != null) {
            hasPerm = authorizeService.hasPermission(auth, (HttpServletRequest) request);
        }

        // 如果没有提供认证Service,则去配置文件中尝试获取权限配置
        if (authorizeService == null && (permissions != null && !permissions.isEmpty())) {
            UserDetails userDetails = (UserDetails) auth.principal();
            hasPerm = this.hasPermission(userDetails.getAuthorities(), (HttpServletRequest) request);
        }

        // 无权访问
        if (!hasPerm) {
            ResponseModels.forbidden((HttpServletResponse) response);
            return;
        }

        chain.doFilter(request, response);
    }

    public void setAuthenticated(String... authenticated) {
        this.authenticated = authenticated;
    }

    public void setAuthorizeService(AuthorizeService authorizeService) {
        this.authorizeService = authorizeService;
    }

    public void setPermissions(Map<String, List<String>> permissions) {
        this.permissions = permissions;
    }

    private boolean requires(HttpServletRequest request) {
        if (authenticated == null) {
            return false;
        }
        for (String s : protectResources) {
            if (new AntPathRequestMatcher(s).matches(request)) {
                return true;
            }
        }
        return false;
    }

    /**
     * SALES, WORKER
     *
     * @param authorities
     * @param request
     * @return
     */
    private boolean hasPermission(Collection<String> authorities, HttpServletRequest request) {
        // 如果当前请求不包含在Permissions中, 则返回True
        boolean isProtected = false;
        for (String s : permissionValues) {
            if (new AntPathRequestMatcher(s).matches(request)) {
                isProtected = true;
                break;
            }
        }
        if (!isProtected) {
            return true;
        }

        // 否则按角色判断当前用户是否具有所请求资源的访问权限
        List<String> userResources = new ArrayList<>();
        for (String authority : authorities) {
            if (permissions.containsKey(authority)) {
                userResources.addAll(permissions.get(authority));
            }
        }
        for (String resource : userResources) {
            if (new AntPathRequestMatcher(resource).matches(request)) {
                return true;
            }
        }
        return false;
    }

}
