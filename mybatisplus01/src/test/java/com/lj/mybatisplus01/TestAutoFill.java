package com.lj.mybatisplus01;

import com.lj.mybatisplus01.entity.MpUser;
import com.lj.mybatisplus01.entity.TestMybatisPlusUser;
import com.lj.mybatisplus01.service.MpUserService;
import com.lj.mybatisplus01.service.TestMybatisPlusUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAutoFill {

    @Autowired
    private TestMybatisPlusUserService userService;
    @Autowired
    private MpUserService mpUserService;

    @Test
    public void autoFill() {
        TestMybatisPlusUser user = new TestMybatisPlusUser();
        user.setName("tom").setAge(20).setEmail("tom@163.com");
        if (userService.save(user)) {
            userService.list().forEach(System.out::println);
        } else {
            System.out.println("添加数据失败");
        }
    }

    @Test
    public void autoFill2() {
        MpUser user = new MpUser();
        user.setName("tom").setAge(20).setEmail("tom@163.com");
        if (mpUserService.save(user)) {
            mpUserService.list().forEach(System.out::println);
        } else {
            System.out.println("添加数据失败");
        }
    }

    @Test
    public void testDelete() {
        if (mpUserService.removeById(1312074592317497346L)) {
            System.out.println("删除数据成功");
            mpUserService.list().forEach(System.out::println);
        } else {
            System.out.println("删除数据失败");
        }
    }
}
