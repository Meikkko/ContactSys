package com.meiko.dao;

import com.meiko.entity.Contact;

import java.util.List;

/**
 * Created by Meiko on 2019/4/26 19:44
 */
public interface ContactDao {
    public void addContact(Contact contact);//添加联系人
    public void updateContact(Contact contact);//修改联系人
    public void deleteContact(String id);//删除联系人
    public List<Contact> findAll();  //查询所有联系人
    public Contact findById(String id);//根据编号查询联系人
    public boolean checkContact(String name);//根据姓名查询是否重复
}
