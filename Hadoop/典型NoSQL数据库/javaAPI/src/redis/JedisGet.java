package redis;

import java.util.Map;
import redis.clients.jedis.*;

public class JedisGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("localhost");
		String value = jedis.hget("student.scofield", "English");
		System.out.println("scofield's English score is: "+value);
	}

}
