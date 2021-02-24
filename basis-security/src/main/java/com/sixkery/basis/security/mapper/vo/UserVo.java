package com.sixkery.basis.security.mapper.vo;

import com.sixkery.basis.security.entity.PermissionDO;
import com.sixkery.basis.security.entity.RoleDO;
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
    private List<PermissionDO> permissionDos;

    /**
     * 角色
     */
    private List<RoleDO> roleDos;


}
