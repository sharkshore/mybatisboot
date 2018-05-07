package com.shark.springboot.dal.specific;

import com.shark.springboot.dal.model.entity.UserDemoEntity;
import com.shark.springboot.dal.model.query.UserDemoQUERY;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by tuze on 2018/5/7.
 */
public class UserDemoSpecification {

    public static Specification<UserDemoEntity> getSpec(final UserDemoQUERY userDemoQUERY){
        return new Specification<UserDemoEntity>() {

            @Override
            public Predicate toPredicate(Root<UserDemoEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1=null;
                if(userDemoQUERY ==null){
                    return null;
                }
                if(userDemoQUERY.getName() !=null){
                    Predicate p2 = cb.equal(root.get("name"), userDemoQUERY.getName());
                    if(p1!=null) p1 = cb.and(p1, p2);
                    else p1=p2;
                }
                if (userDemoQUERY.getMobile() != null) {
                    Predicate p2 = cb.equal(root.get("mobile"), userDemoQUERY.getMobile());
                    if(p1!=null) p1 = cb.and(p1, p2);
                    else p1=p2;
                }
                if (userDemoQUERY.getAge() != null) {
                    Predicate p2 = cb.equal(root.get("age"), userDemoQUERY.getAge());
                    if(p1!=null) p1 = cb.and(p1, p2);
                    else p1=p2;
                }
                if (userDemoQUERY.getCreatedBy() != null) {
                    Predicate p2 = cb.equal(root.get("createdBy"), userDemoQUERY.getCreatedBy());
                    if(p1!=null) p1 = cb.and(p1, p2);
                    else p1=p2;
                }
                if (userDemoQUERY.getMinAge() != null) {
                    Predicate p2 = cb.gt(root.get("age"), userDemoQUERY.getMinAge());
                    if(p1!=null) p1 = cb.and(p1, p2);
                    else p1=p2;
                }
                if (userDemoQUERY.getMaxAge() != null) {
                    Predicate p2 = cb.lt(root.get("age"), userDemoQUERY.getMaxAge());
                    if(p1!=null) p1 = cb.and(p1, p2);
                    else p1=p2;
                }
                return p1;

            }
        };
    }
}
