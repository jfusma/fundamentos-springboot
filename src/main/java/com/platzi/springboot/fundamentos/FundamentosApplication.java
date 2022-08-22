package com.platzi.springboot.fundamentos;

import com.platzi.springboot.fundamentos.component.MyFirstComponent;
import com.platzi.springboot.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final MyFirstComponent myFirstComponent;

    @Autowired
    private UserRepository userRepository;

    public FundamentosApplication(MyFirstComponent myFirstComponent) {
        this.myFirstComponent = myFirstComponent;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
        System.out.println();
    }

    private void saveUserInDataBase() {
        User user1 = new User("john", "john@domain.com", LocalDate.of(2000, 05, 02));
        User user2 = new User("andres", "andres@domain.com", LocalDate.of(1987, 02, 8));
        User user3 = new User("maria", "maria@domain.com", LocalDate.of(1975, 8, 20));
        User user4 = new User("sandra", "sandra@domain.com", LocalDate.of(2002, 07, 03));
        User user5 = new User("carlos", "carlos@domain.com", LocalDate.of(1999, 01, 04));
        User user6 = new User("ana", "ana@domain.com", LocalDate.of(1989, 02, 8));
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
		userList.stream().forEach(userRepository::save);
    }

    private void getUserFromJPQLMethod(){
        System.out.println("usuario de la bd x email : " + userRepository.findByUserEmail("john@domain.com")
                .orElseThrow(() -> new RuntimeException("no se encontro usuario por email")));
    }

    private void getAllUserUsingLikeQuery(){

        userRepository.findByAndSort( "a", Sort.by("id").ascending())
                .stream().forEach(System.out::println);
    }

    @Override
    public void run(String... args) throws Exception {
       // myFirstComponent.sayHello();
		saveUserInDataBase();
        getUserFromJPQLMethod();
        getAllUserUsingLikeQuery();
    }




}
