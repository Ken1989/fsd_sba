package cn.ibm.com.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.ibm.com.dao.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long>{
	
	@Query(value = "update course set status = 0 where id = :id", nativeQuery = true)
	public void disableCourseById(@Param("id") long courseId);
}
