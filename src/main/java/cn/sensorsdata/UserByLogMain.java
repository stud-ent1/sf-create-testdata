package cn.sensorsdata;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.sensorsdata.analytics.javasdk.exceptions.InvalidArgumentException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author lichengyu
 * @date 2022-03-25 3:18 下午
 * @description:
 */
public class UserByLogMain {
    public static void main(String[] args) throws IOException, InvalidArgumentException {
        // 使用 DebugConsumer 初始化 SensorsAnalytics
        final SensorsAnalytics sa = new SensorsAnalytics(new SensorsAnalytics.ConcurrentLoggingConsumer(args[0]));
        Random random = new Random();
        for (int i = 0; i < 5000000; i++) {
            Map<String, Object> properties = new HashMap<String, Object>();
            properties.put("mb_cus_id", "MB10874077");
            properties.put("mobile_number", "2022"+String.format("%07d", random.nextInt(5000000)));
            properties.put("push_id", "03035322032418124073017113059254");
            String distinct_id = "TEST" + System.currentTimeMillis() + random.nextInt(5000000);
            sa.profileSet(distinct_id, true, properties);
        }
    }

}
