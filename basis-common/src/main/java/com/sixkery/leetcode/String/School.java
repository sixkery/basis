package com.sixkery.leetcode.String;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author sixkery
 * @since 2023/8/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {

    public int id;

    public String name;

    public String age;

}

@Data
@EqualsAndHashCode(callSuper = true)
class ShangHai extends School {
    private String type;
}


class test {

    public static void main(String[] args) {
        ShangHai shangHai = new ShangHai();
        shangHai.setId(1);
        shangHai.setName("上海大学");
        shangHai.setType("A");

        ShangHai shangHai2 = new ShangHai();
        shangHai2.setId(2);
        shangHai2.setName("华东师范");
        shangHai2.setType("A");

        System.out.println(shangHai.equals(shangHai2));
        System.out.println(shangHai);
        System.out.println(shangHai2);

    }
}

