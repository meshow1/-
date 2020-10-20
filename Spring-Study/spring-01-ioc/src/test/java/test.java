import com.kuang.dao.UserDaoImpl;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;

public class test {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl());
        userService.getuser();
    }
}
