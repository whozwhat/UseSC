package water.ustc.dao;
import sc.ustc.dao.BaseDAO;
import java.sql.*;

public class UserDAO extends BaseDAO {

    public UserDAO(String driver,String url,String userName,String password){
        super(driver,url,userName,password);
    }

    public boolean insert(String sql){return true;}

    public boolean delete(String sql){return true;}

    public boolean update(String sql){return true;}

    public Object query(String sql, String[] args){
       // PreparedStatement ps = null;
        ResultSet rs = null;
        String userpw = null;
        try{
            rs = super.openDBConnection().prepareStatement(sql).executeQuery();
            while (rs.next())
            {
                userpw = rs.getString(1);
                System.out.println(userpw);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        UserBean userBean = new UserBean();
        userBean.setUserPass(userpw);
        return userBean;
    }
}
