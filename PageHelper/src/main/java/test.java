import Dao.personDao;
import Entity.Person;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */
public class test {


    //加载mybaits文件
    private SqlSession getPersonDao(String resource){
        InputStream inputStream= null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    @Test
    public void createData(){
        SqlSession sqlSession=getPersonDao("mybaits-config.xml");
        personDao personDao=sqlSession.getMapper(personDao.class);
        //制造100条数据
        for(int i=101;i<=200;i++) {
            personDao.putData(new Person("小明"+i, "篮球", (long) i-100));
        }
        sqlSession.commit();
    }


    @Test
    public void getPerson(){
        //首先获取全部数据
        SqlSession sqlSession=getPersonDao("mybaits-config.xml");
        personDao mapper = sqlSession.getMapper(personDao.class);

        //方法一：
        //取第1页的数据，第一页显示10行
        PageHelper.startPage(1, 10);
        //得到的peopleList 类型是Page<E>,Page<E>类型里面包含了count, pageNum, pageSize,
        // startRow, endRow, total, pages, reasonable, pageSizeZero 变量
        List<Person> peopleList=mapper.getData();
        //可以直接输出看看有什么变量
        System.out.println(peopleList.toString());
        //如果需要使用Page<E> 的方法获取属性 需要方法一是：强制转换，方法二是 pageInfo。
        //方法一:
        System.out.println("获取一下总数 "+((Page)peopleList).getTotal());
        System.out.println("总页数有 "+((Page)peopleList).getPages());
        System.out.println(peopleList.get(1));
        //方法二：
        //pageInfo对结果进行封装
        PageInfo pageInfo=new PageInfo(peopleList);
        System.out.println("获取一下总数 "+pageInfo.getTotal());

        //遍历数据
        for (Person aPeopleList : peopleList) {
            System.out.println(aPeopleList);
        }



    }
}
