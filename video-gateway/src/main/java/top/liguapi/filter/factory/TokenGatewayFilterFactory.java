package top.liguapi.filter.factory;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import top.liguapi.admin.constant.RedisPrefix;
import top.liguapi.exceptions.TokenIllegalException;
import top.liguapi.exceptions.TokenIllegalExceptionEnum;

import java.util.Arrays;
import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/16 14:23
 */
@Component
@Slf4j
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    @Autowired
    private RedisTemplate redisTemplate;

    public TokenGatewayFilterFactory() {
        super(TokenGatewayFilterFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("requiredToken");
    }


    @Override
    public GatewayFilter apply(TokenGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("requiredToken:{}", config.requiredToken);
                // requiredToken=true,才需要认证
                if (config.requiredToken) {
                    String path = exchange.getRequest().getPath().toString();
                    // 登录接口不需要认证
                    log.info("path:{}", path);
                    if ("/admin/tokens".equals(path)) {
                        return chain.filter(exchange);
                    }
                    List<String> list = exchange.getRequest().getQueryParams().get("token");
                    if (list == null) {
                        throw new TokenIllegalException(TokenIllegalExceptionEnum.TOKEN_IS_EMPTY);
                    }
                    String token = list.get(0);
                    log.info("token:{}", token);
                    if (!redisTemplate.hasKey(RedisPrefix.TOKEN_KEY + token)) {
                        throw new TokenIllegalException(TokenIllegalExceptionEnum.TOKEN_IS_ILLEGAL);
                    }
                }
                return chain.filter(exchange);
            }
        };
    }

    @Data
    public static class Config {
        private boolean requiredToken;
    }
}
