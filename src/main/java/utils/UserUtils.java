package utils;

import com.github.javafaker.Faker;
import models.User;

public class UserUtils {


    public static User generateUSer(User.Gender gender){

        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new  Faker().internet().emailAddress();
        String password = new  Faker().internet().password();
       return new  User(firstName,lastName,email,password,gender);

    }

    public static void waitMe (int time ){

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
