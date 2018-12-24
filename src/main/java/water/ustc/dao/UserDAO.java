package water.ustc.dao;
import sc.ustc.dao.Conversation;
public class UserDAO  {

    public boolean insert(Object o){return true;}

    public boolean delete(Object o){return true;}

    public boolean update(Object o){return true;}

    public static Object query(Object o){

        Object userBean = Conversation.getObject(o);

        return userBean;
    }
}
