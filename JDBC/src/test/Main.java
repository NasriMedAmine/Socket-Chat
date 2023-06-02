package test;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static Predicate<User> whoIs() {
        return p -> p.getPseudo() == "ala";
    }
    public static void main(String[] args){
        User user1 = new User("mohamed","nasrii","eeeee@mail.com",22);
        User user2 = new User("ala","nasri","aaaa@mail.com",33);
        User user3 = new User("hama","nasri2","zzzz@mail.com",14);
        ArrayList<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        System.out.println(list);



//        list.get(2)
        System.out.println("----");
        System.out.println(list.size());
        System.out.println(list.get(0));

    }
}
