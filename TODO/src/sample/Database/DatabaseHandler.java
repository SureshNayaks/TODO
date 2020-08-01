package sample.Database;

import sample.model.Users;

import java.sql.*;

public class DatabaseHandler extends config{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        String JdbcURL = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+ "?autoReconnect=true&useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(JdbcURL,dbUser,dbPass);
        return dbConnection;
    }


    //write

    public void UserSignup(Users user){
        String insert = "INSERT INTO "+Const.USERS_TABLE+" ("+Const.USERS_FIRSTNAME+","+Const.USERS_LASTNAME+","+Const.USERS_USERNAME+
            ","+Const.USERS_PASSWORD+ ","+Const.USERS_LOCATION+","+Const.USERS_GENDER+")"+"VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getUserName());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getLocation());
            preparedStatement.setString(6,user.getGender());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public ResultSet loginuser(Users user){

        ResultSet resultSet =null;
        if (!user.getUserName().equals("") || !user.getPassword().equals("")){
            String query = "SELECT * FROM "+Const.USERS_TABLE+" WHERE "+
                    Const.USERS_USERNAME + "=?" +"AND " +Const.USERS_PASSWORD + "=?";
            //SELECT ALL FROM 'users' WHERE ('username'='username' ) AND ('password'='password);

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);

                preparedStatement.setString(1,user.getUserName());
                preparedStatement.setString(2,user.getPassword());

                resultSet= preparedStatement.executeQuery();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("please enter your valid credentials");
        }
        return resultSet;
    }

    //read

    //update

}
