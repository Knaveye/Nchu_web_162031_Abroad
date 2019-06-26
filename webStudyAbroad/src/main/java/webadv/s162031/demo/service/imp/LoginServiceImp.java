package webadv.s162031.demo.service.imp;

import org.springframework.stereotype.Service;
import webadv.s162031.demo.service.LoginService;

/**
 * @author: yjp
 * @date:
 * @description:
 */
@Service
public class LoginServiceImp implements LoginService {
    @Override
    public boolean verify(String token) {
        return false;
    }
}
