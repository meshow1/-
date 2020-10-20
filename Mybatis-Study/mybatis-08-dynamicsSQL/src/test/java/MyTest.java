import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDUtils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
//    @Test
//    public void test(){
//            SqlSession sqlSession = MybatisUtils.getSqlSession();
//            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//
//            Blog blog = new Blog();
//            blog.setId(IDUtils.getId());
//            blog.setTitle("Mybatis");
//            blog.setAuthor("狂神说");
//            blog.setCreateTime(new Date());
//            blog.setViews(9999);
//
//            mapper.addBlog(blog);
//
//            blog.setId(IDUtils.getId());
//            blog.setTitle("Java");
//            mapper.addBlog(blog);
//
//            blog.setId(IDUtils.getId());
//            blog.setTitle("Spring");
//            mapper.addBlog(blog);
//
//            blog.setId(IDUtils.getId());
//            blog.setTitle("微服务");
//            mapper.addBlog(blog);
//
//            sqlSession.commit();
//            sqlSession.close();
//
//    }
        @Test
        public void test(){

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            HashMap map = new HashMap();
            map.put("title", "Java");
            map.put(1,1);
            List<Blog> blogs = mapper.queryBlogIF(map);

            for (Blog blog : blogs) {
                    System.out.println(blog);
            }

        }
}

