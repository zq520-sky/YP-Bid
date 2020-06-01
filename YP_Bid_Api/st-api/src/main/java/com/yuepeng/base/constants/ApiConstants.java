package com.yuepeng.base.constants;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 〈功能概述〉<br>
 *
 * @className: ApiConstants
 * @package: com.yuepeng.base.constants
 * @author: wzq
 * @date: 2020/5/26 15:26
 */
@Getter
@Setter
@Component
public class ApiConstants {

    @Value("${sign.salt}")
    public String signSalt;

    @Value(("${request.delay.time:60000}"))
    public Long requestDelaytime;

    public static final String PWD_SALT = "d9zZmXaxHMuD0ioEV5UOGbALJeB7qk14";


}
