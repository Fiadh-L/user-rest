package io.wdevstudy.rest.service.logic;

import io.wdevstudy.rest.entity.User;
import io.wdevstudy.rest.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceLogicTest {
    //테스트 로직 작성시에는 메인 클레스와 동일한 패키지 구조를 만들어주어야 함

    @Autowired
    private UserService userService;
    //userServic 로직이 주입되어야 함. 1.생성자, 2.오토와이어드, 3.롬복 리콰이어드
    //단위테스트 시에는 required~/생성자 초기화 사용불가,

    private User kim;
    private User lee;

    @BeforeEach
    public void startUp() {
        this.kim = new User("Kim", "kim@namoosori.io");
        this.lee = new User("Lee", "lee@namoosori.io");
    }

    @Test
    public void registerTest() {
        User sample = User.sample();
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);
        this.userService.remove(sample.getId());
    }
    //테스트 시에 부러 에러 조건을 발생시켜서 로그도 확인해보기

    @Test
    public void find(){
    assertThat(this.userService.find(lee.getId())).isNotNull();
    assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());
    }

    @AfterEach
    public void cleanUp() {
        this.userService.remove(kim.getId());
        this.userService.remove(lee.getId());
    }

}
