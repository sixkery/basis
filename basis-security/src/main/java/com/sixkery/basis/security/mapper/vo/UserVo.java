package com.sixkery.basis.security.mapper.vo;

import com.sixkery.basis.security.dto.PermissionDto;
import com.sixkery.basis.security.dto.RoleDto;
import com.sixkery.basis.security.entity.UserDO;
import lombok.Data;

import java.util.List;

/**
 * @author sixkery
 */
@Data
public class UserVo extends UserDO {
    /**
     * 权限
     */
    private List<PermissionDto> permissionDos;

    /**
     * 角色
     */
    private List<RoleDto> roleDos;


}
