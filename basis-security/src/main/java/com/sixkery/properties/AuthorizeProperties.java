package com.sixkery.properties;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AuthorizeProperties {

    private String[] authenticated;

    private Map<String, List<String>> permissions;

}
