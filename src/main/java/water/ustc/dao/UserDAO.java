package water.ustc.dao;
import sc.ustc.dao.Conversation;
public class UserDAO  {

    public static boolean insert(Object o){
        return Conversation.insertObject(o);
    }

    public static boolean delete(Object o){
        return Conversation.deleteObjById(o);
    }
    public static boolean update(Object o) {
        return true;
    }

    public static Object query(Object o){

        Object userBean = Conversation.getObject(o);

        return userBean;
    }
}
