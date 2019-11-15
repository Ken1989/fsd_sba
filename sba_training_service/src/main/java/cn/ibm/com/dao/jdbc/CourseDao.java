package cn.ibm.com.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.ibm.com.dao.entity.Course;

@Component
public class CourseDao extends BaseDao {

	/**
	 * Query the course data by parameters 
	 * @param course
	 * @return course list  (status = 1)
	 */
	public List<Course> findCourseByPage(Course course) {
		// Only find the course that is available --> status = 1
		String sql = "select * from course where 1 = 1 and status = 1";

		List<Object> parameters = new ArrayList<>();

		if (!StringUtils.isEmpty(course.getSkillType())) {
			sql += " and skilltype = ?";
			parameters.add(course.getSkillType());
		}

		if (!StringUtils.isEmpty(course.getMentorName())) {
			sql += " and mentorname = ?";
			parameters.add(course.getMentorName());
		}

		return (List<Course>) this.query(sql, parameters, course.getPage(), course.getPageSize());
	}

	/**
	 * Get the page num
	 * @param course
	 * @return
	 */
	public int getPageCount(Course course) {
		// Only find the course that is available --> status = 1
		String sql = "select * from course where 1 = 1 and status = 1";

		List<Object> parameters = new ArrayList<>();

		if (!StringUtils.isEmpty(course.getSkillType())) {
			sql += " and skilltype = ?";
			parameters.add(course.getSkillType());
		}

		if (!StringUtils.isEmpty(course.getMentorName())) {
			sql += " and mentorname = ?";
			parameters.add(course.getMentorName());
		}
		
		return super.getPageCount(course.getPageSize(), sql, parameters.toArray());

	}
}
