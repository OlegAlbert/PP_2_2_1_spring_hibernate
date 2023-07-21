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

      /*Car car1 = new Car(123, "BMW");
      Car car2 = new Car(456, "Hyundai");
      Car car3 = new Car(789, "Mercedes");
      Car car4 = new Car(876, "Volga");

      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
*/
      userService.add(new User("User1", "Lastname1",
              "user1@mail.ru", new Car(123, "BMW")));
      userService.add(new User("User2", "Lastname2",
              "user2@mail.ru", new Car(456, "Hyundai")));
      userService.add(new User("User3", "Lastname3",
              "user3@mail.ru", new Car(789, "Mercedes")));
      userService.add(new User("User4", "Lastname4",
              "user4@mail.ru", new Car(876, "Volga")));





      /*List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }*/

      User user = userService.getUserByCar(new Car(789, "Mercedes"));
      System.out.println(user);

      context.close();
   }
}
