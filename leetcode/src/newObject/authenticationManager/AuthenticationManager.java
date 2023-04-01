package newObject.authenticationManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1797. 设计一个验证系统
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class AuthenticationManager {

//    AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 timeToLive 参数。
//    generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
//    renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
//    countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。


    int timeToLive;
    Map<String, Integer> tokenIdMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokenIdMap = new ConcurrentHashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokenIdMap.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        //考虑更新前没有过期
        if (tokenIdMap.containsKey(tokenId) && tokenIdMap.get(tokenId) + timeToLive > currentTime) {
            tokenIdMap.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer integer : tokenIdMap.values()) {
            count += integer + timeToLive > currentTime ? 1 : 0;
        }
        return count;
    }
}
