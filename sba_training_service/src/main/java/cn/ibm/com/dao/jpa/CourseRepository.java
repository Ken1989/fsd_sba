package cn.ibm.com.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ibm.com.dao.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long>{

}
