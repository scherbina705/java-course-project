package com.stwitter.dao.impl;

import com.stwitter.dao.HobbyDao;
import com.stwitter.entity.Hobby;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class HobbyDaoImpl extends GenericDaoImpl<Hobby, Long> implements HobbyDao {

}
