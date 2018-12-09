package cn.edu.nuc.ssm;

import cn.edu.nuc.ssm.logger.BaseLog;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml","classpath:spring-mvc.xml"})
public class BaseTest extends BaseLog {

}
