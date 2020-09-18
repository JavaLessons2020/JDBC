import java.sql.*;
import java.time.LocalTime;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        try {

            //Получаем доступ к драйверу
            Class.forName("com.mysql.jdbc.Driver");
            //Создаем соединение
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_jdbc", "root", "root");
            //Создаем обьект который сможет передать запрос в базу данных
            Statement statement = connection.createStatement();




//Передача запроса в БД
            //statement.executeUpdate("UPDATE user set age=24 where  id = 1");
            //statement.executeUpdate("INSERT INTO user(first_name, last_name, age) VALUE ('Петро','Иванов', 29 )");
            //statement.executeUpdate("DELETE from user WHERE id=4");
            //System.out.println("Updating...");


            //Получуние resultSet с помощью запроса SELECT
//            ResultSet resultSet = statement.executeQuery("SELECT * from user");
//
//            //Данные о колонках
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt(1) +":"+ metaData.getColumnTypeName(1) + " " +
//                        resultSet.getString("first_name")+":"+ metaData.getColumnCount()+" " +
//                        resultSet.getString(3)+":"+ metaData.getColumnClassName(3)+" " +
//                        resultSet.getInt("age")+":"+ metaData.getColumnLabel(4));
//            }
            //statement.close();




            String firstName = null;
            String lastName = null;
            int age = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя фамилию и возраст");
            firstName = scanner.nextLine();
            lastName = scanner.nextLine();
            age = scanner.nextInt();


            //Подготавливает данные для отправки в базу данных
            PreparedStatement pre = connection.prepareStatement("INSERT INTO user(first_name, last_name, age) VALUE (?,?,?)");
            pre.setString(1,firstName);
            pre.setString(2,lastName);
            pre.setInt(3,age);
            //не забываем подтвердить запрос
            pre.executeUpdate();
            pre.close();




        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
