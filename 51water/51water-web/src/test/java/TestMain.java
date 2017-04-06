import com.sun.beans.TypeResolver;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.lang.reflect.Method;

/**
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @date:2016年01月05日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class TestMain {
    public static void main(String[] args) {
        /*SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        Class<SqlSessionFactoryBean> clz = SqlSessionFactoryBean.class;
       Method[] result = clz.getMethods();
        for (int i = 0; i < result.length; i++) {
            Method method = result[i];
            System.out.println(method.getName());
            if (!method.getDeclaringClass().equals(clz)) {
                continue;
            }
            TypeResolver.erase(TypeResolver.resolveInClass(clz, method.getGenericParameterTypes()));
        }*/

        try {
            //TestMain testMain = TestMain.class.newInstance();
            TestMain testMain = new TestMain();
            Method
                    method = testMain.getClass().getMethod("method", XXX[].class);
            method.invoke(testMain, new Object[]{new XXX[2]});
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void method(XXX[] args) {
        System.out.println("sssssssssssss");
    }

    public void method(String[] args) {
        System.out.println("String");
    }
}

class XXX {

}
