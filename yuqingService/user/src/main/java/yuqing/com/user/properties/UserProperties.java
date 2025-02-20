package yuqing.com.user.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")//配置批最绑定在nacos下，可以无需@RefreshScope就能实现自动刷新
@Data
public class UserProperties {
    String timeout;
    //短横线斜杠设为驼峰式
    String autoConfirm;
}
