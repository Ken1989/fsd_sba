package cn.ibm.com.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ibm.com.dao.entity.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long>{

	public List<UserCourse> findByName(String name);
}
