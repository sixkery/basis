package com.sixkery.basis.es.mapper.vo;

import com.sixkery.basis.es.domain.dto.PermissionDto;
import com.sixkery.basis.es.domain.dto.RoleDto;
import com.sixkery.basis.es.domain.entity.UserDO;
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
