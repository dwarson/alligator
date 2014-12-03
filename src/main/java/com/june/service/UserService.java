package com.june.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.User;
import com.june.repository.UserDao;
import com.june.service.user.ShiroDbRealm.ShiroUser;
import com.june.utils.Digests;
import com.june.utils.Encodes;

@Component
@Transactional
public class UserService {
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserDao userDao;

    public List<User> getAllUser() {
        return (List<User>) userDao.findAll();
    }

    public User getUser(Long id) {
        return userDao.findOne(id);
    }

    public User findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void registerUser(User user) {
        entryptPassword(user);
        user.setRoles("user");
        user.setRegisterDate(new Date());
        userDao.save(user);
    }

    public void updateUser(User user) {
        if (StringUtils.isNotBlank(user.getPlainPassword())) {
            entryptPassword(user);
        }
        userDao.save(user);
    }

    public void deleteUser(Long id) {
        if (isSupervisor(id)) {
            logger.warn("User {} trying to delete admin user",
                    getCurrentUserName());
            throw new ServiceException("Can not delete Admin");
        }
        userDao.delete(id);
    }

    private boolean isSupervisor(Long id) {
        return id == 1;
    }

    /**
     * set password，generate the random salt, then with 1024 times of sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(),
                salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    private String getCurrentUserName() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.loginName;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
