package Dao; /**
 * Created by Administrator on 2017/9/20.
 */

import Entity.Person;

import java.util.List;

public interface personDao {
    //增加数据
    int putData(Person person);

    //获取数据
    List<Person> getData();
}
