package com.meiko.service.impl;

import com.meiko.dao.ContactDao;
import com.meiko.dao.impl.ContactDaoMySQLImpl;
import com.meiko.entity.Contact;
import com.meiko.exception.NameRepeatException;
import com.meiko.service.ContactService;

import java.util.List;

/**
 * Created by Meiko on 2019/4/26 20:08
 */
public class ContactServiceImpl implements ContactService {
    //ContactDao dao = new ContactDaoImpl();
    ContactDao dao = new ContactDaoMySQLImpl();

    public void addContact(Contact contact) throws NameRepeatException {
        //执行业务逻辑判断
        if(dao.checkContact(contact.getName())){
            //重复
            /**
             * 注意： 如果业务层方法出现任何业务异常，则返回标记（自定义异常）到servlet
             */
            throw new NameRepeatException("姓名重复，不可使用");
        }
        //如果不重复，才执行添加方法
        dao.addContact(contact);
    }

    public void deleteContact(String id) {
        dao.deleteContact(id);
    }

    public List<Contact> findAll() {
        return dao.findAll();
    }

    public Contact findById(String id) {
        return dao.findById(id);
    }

    public void updateContact(Contact contact) {
        dao.updateContact(contact);
    }

}
