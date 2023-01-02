package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "LastName1", "user1@mail.ru",
              new Car("Model1", 11111)));
      userService.add(new User("User2", "LastName2", "user2@mail.ru",
              new Car("Model2", 22222)));
      userService.add(new User("User3", "LastName3", "user3@mail.ru",
              new Car("Model3", 33333)));
      userService.add(new User("User4", "LastName4", "user4@mail.ru",
              new Car("Model4", 44444)));

      List<User> users = userService.getListUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
      }

      System.out.println("Найден " + userService.getUserByCar("Model1", 11111) +
              " с машиной Model1 ser:11111");
      System.out.println("Найден " + userService.getUserByCar("Model2", 22222) +
              " с машиной Model2 ser:22222");
      System.out.println("Найден " + userService.getUserByCar("Model3", 33333) +
              " с машиной Model3 ser:33333");
      System.out.println("Найден " + userService.getUserByCar("Model4", 44444) +
              " с машиной Model4 ser:44444");

      context.close();
   }
}